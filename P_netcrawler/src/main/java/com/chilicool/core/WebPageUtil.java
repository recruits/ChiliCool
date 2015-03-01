package com.chilicool.core;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import org.apache.commons.lang3.StringUtils;

/**
 * 网址解析类. <br>
 * 使用网址做为入参，请求当前网址页面，并进行解析，生成WebPage对象.
 * 
 * @author zhangzechen@chilicool.com
 * @date 2014-9-30 下午4:31:28 <br>
 *       Copyright: Copyright (c) 2014 chilicool
 */
public class WebPageUtil {
	// URL对象
	private URL url;
	
	// 网址解析结果
	private String resCode = "";
	private String errorMsg = "";
	
	private boolean contZipFlag = false;
	private short pageEncodingType = 1;
	private String pageEncoding = "UTF-8";

	private WebPageUtil(String netUrlStr) throws MalformedURLException,
			IOException {
		try {
			url = new URL(netUrlStr);
		} catch (MalformedURLException e) {
			throw e;
		}
	}
	public short getPageEncodingType() {
		return pageEncodingType;
	}
	public String getPageResponseCode() {
		return resCode;
	}
	public String getPageErrorMsg() {
		return errorMsg;
	}
	public boolean isContZipFlag() {
		return contZipFlag;
	}
	public boolean getContZipFlag() {
		return contZipFlag;
	}
	public String getPageEncoding() {
		try {
			// 1. 从http响应头信息[Content-Type]中获取 [Content-Type text/html;
			// charset=GBK]
			HttpURLConnection httpConn = (HttpURLConnection) url
					.openConnection();
			confHttpConnection(httpConn);
			resCode = httpConn.getResponseCode() + "";

			if (resCode.startsWith("2")) {
				// 判断页面内容是否压缩
				String contType = httpConn.getHeaderField("Content-Encoding");
				if (StringUtils.isNotEmpty(contType)
						&& contType.indexOf("gzip") != -1) {
					contZipFlag = true;
				}

				String contentType = httpConn.getHeaderField("Content-Type");
				String matcherStr = "charset=";
				if (StringUtils.isNotEmpty(contentType)
						&& contentType.indexOf(matcherStr) != -1) {
					pageEncoding = contentType.substring(
							contentType.indexOf(matcherStr)
									+ matcherStr.length()).toUpperCase();
					closeHttpConn(httpConn);

					return pageEncoding;
				}
				closeHttpConn(httpConn);

				// 2. 解析页面源码
				BufferedReader in = null;
				try {
					in = new BufferedReader(new InputStreamReader(
							url.openStream()));

					int loopcnt = 100;
					String line = null;

					while ((line = in.readLine()) != null && loopcnt > 0) {
						Pattern encodReg = Pattern.compile("charset=.+?\"");
						Matcher encod = encodReg.matcher(line.toLowerCase());
						while (encod.find()) {
							String encoding = encod.group().replace("\"", "");
							pageEncoding = encoding
									.substring(8, encoding.length())
									.toUpperCase().toUpperCase();

							pageEncodingType = 2;
							return pageEncoding;
						}
						loopcnt--;
					}
				} catch (IOException e1) {
					errorMsg = e1.getMessage();
				} finally {
					try {
						if (null != in) {
							in.close();
						}
					} catch (IOException e) {
						errorMsg = e.getMessage();
					}
				}

				// 3. 使用工具探测器
				try {
					CodepageDetectorProxy detector = CodepageDetectorProxy
							.getInstance();
					Charset charset = detector.detectCodepage(url);

					if (null != charset) {
						pageEncoding = charset.name().toUpperCase();

						pageEncodingType = 3;
						return pageEncoding;
					}
				} catch (IOException e) {
					errorMsg = e.getMessage();
				}
			}
		} catch (ProtocolException pe) {
			errorMsg = pe.getMessage();
		} catch (IOException ioe) {
			errorMsg = ioe.getMessage();
		}

		return pageEncoding;
	}
	// 内容获取
	public String getPageContent() {
		StringBuilder builder = new StringBuilder();

		BufferedReader in = null;
		InputStreamReader inReader = null;
		GZIPInputStream gzin = null;
		try {
			if (isContZipFlag()) {
				// 建立解压流
				gzin = new GZIPInputStream(url.openStream());
				inReader = new InputStreamReader(gzin, pageEncoding);
			} else {
				inReader = new InputStreamReader(url.openStream(), pageEncoding);
			}

			in = new BufferedReader(inReader);
			String line;
			while ((line = in.readLine()) != null) {
				builder.append(StringUtils.isEmpty(line) ? "" : line);
			}
		} catch (IOException e1) {
			errorMsg = e1.getMessage();
		} finally {
			try {
				if (null != gzin) {
					gzin.close();
				}
				if (null != inReader) {
					inReader.close();
				}
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				errorMsg = e.getMessage();
			}
		}

		return builder.toString();
	}
	private void closeHttpConn(HttpURLConnection httpConn) {
		if (null != httpConn) {
			httpConn.disconnect();
		}
	}
	private HttpURLConnection confHttpConnection(HttpURLConnection httpConn)
			throws ProtocolException {
		try {
			httpConn.setConnectTimeout(10000);
			httpConn.setReadTimeout(10000);
			httpConn.setRequestMethod("GET");
			httpConn.setRequestProperty("Charset", pageEncoding);
			httpConn.setRequestProperty(
					"User-Agent",
					"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.121 Safari/535.2");
		} catch (ProtocolException e) {
			throw e;
		}
		return httpConn;
	}
}
