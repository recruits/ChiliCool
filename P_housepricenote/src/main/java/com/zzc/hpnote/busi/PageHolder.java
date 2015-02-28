package com.zzc.hpnote.busi;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import org.apache.commons.lang.StringUtils;

/**
 * 页面工具类
 * @decription 加载传入的页面地址，取编码、标题、标签、描述、内容、网址集、处理时间
 * @author zhangzechen
 *
 */
public class PageHolder {
	private boolean contZipFlag = false;
	private String pageUrl = "";
	private short pageEncodingType = 1;
	private String pageEncoding = "";
	private String pageContent = "";
	private String pageTitle = "";
	private String pageLabel = "";
	private String pageDescription = "";
	//private final Set<String> pageUrlSet = new HashSet<String>();
	
	// 增加一些辅助业务处理信息
	/** 时间  **/
	private long begTime = 0;
	private long endTime = 0;
	private long totTime = 0;
	/** HTTP返回编码  **/
	private String pageRespCode = "";
	/** HTTP异常信息 **/
	private String pageErrorMsg = "";
	
	public PageHolder(String pageUrl) throws MalformedURLException, IOException{
		try {
			begTime = System.currentTimeMillis();
			this.pageUrl = pageUrl;
			PageUtil pageUtil = new PageUtil(pageUrl);
			
			pageEncoding = pageUtil.getPageEncoding();
			contZipFlag = pageUtil.getContZipFlag();
			pageEncodingType = pageUtil.getPageEncodingType();
			pageRespCode = pageUtil.getPageResponseCode();
			if(pageRespCode.startsWith("2")){
				pageContent = pageUtil.getPageContent();
				if(StringUtils.isNotEmpty(pageContent)){
					pageContent = pageContent.toLowerCase();
					if(pageContent.indexOf("</head>") != -1){
						Map<String, String> pageExtInfo = PageParser
								.getPageExtInfo(pageContent.substring(0, pageContent.indexOf("</head>")));
						
						pageTitle = pageExtInfo.get("pageTitle");
						pageLabel = pageExtInfo.get("pageLabel");
						pageDescription = pageExtInfo.get("pageDescription");
					}
					//pageUrlSet = PageParser.getPageExtUrlSet(pageContent);
				}
			}
			pageErrorMsg = pageUtil.getPageErrorMsg();
			
			endTime = System.currentTimeMillis();
			totTime = endTime - begTime;
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} 
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public String getPageEncoding() {
		return pageEncoding;
	}
	public short getPageEncodingType() {
		return pageEncodingType;
	}
	public String getPageContent() {
		return pageContent;
	}
//	public Set<String> getPageUrlSet() {
//		return pageUrlSet;
//	}
	public String getPageTitle() {
		return pageTitle;
	}
	public boolean isContZipFlag() {
		return contZipFlag;
	}
	public String getPageLabel() {
		return pageLabel;
	}
	public String getPageDescription() {
		return pageDescription;
	}
	public long getTotTime() {
		return totTime;
	}
	public String getPageRespCode() {
		return pageRespCode;
	}
	public String getPageErrorMsg() {
		return pageErrorMsg;
	}
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(
				"------------------------------------------------------------").append("\n")
				.append("----- beg-time      :").append(begTime).append("\n")
				.append("----- end-time      :").append(endTime).append("\n")
				.append("----- total-time    :").append(totTime).append("\n")
				.append("----- page-code     :").append(pageEncoding).append("\n")
				.append("----- page-code-type:").append(pageEncodingType).append("\n")
				.append("----- page-title    :").append(pageTitle).append("\n")
				.append("----- page-label    :").append(pageLabel).append("\n")
				.append("----- page-desc     :").append(pageDescription).append("\n")
//				.append("----- page-urls     :").append(pageUrlSet).append("\n")
				.append("----- page-resp-code:").append(pageRespCode).append("\n")
				.append("----- page-error-msg:").append(pageErrorMsg).append("\n");
		return builder.toString();
	}
	
	private class PageUtil{
		private short pageEncodingType = 1;
		private String pageEncoding = "UTF-8";
		private boolean contZipFlag = false;
		
		private String resCode = "";
		private String errorMsg = "";

		private URL url ;
		public PageUtil(String netUrlStr) throws MalformedURLException, IOException{
			try {
				url = new URL(netUrlStr);
			} catch (MalformedURLException e) {
				throw e;
			}
		}
		public short getPageEncodingType(){
			return pageEncodingType;
		}
		public String getPageResponseCode(){
			return resCode;
		}
		public String getPageErrorMsg(){
			return errorMsg;
		}
		public boolean getContZipFlag(){
			return contZipFlag;
		}
		public String getPageEncoding(){
			try {
				/**
				{null=[HTTP/1.1 200 OK], 
				Expires=[Sat, 17 May 2014 07:05:40 GMT], 
				X-UA-Compatible=[IE=EmulateIE7, IE=EmulateIE7], 
				Connection=[keep-alive], 
				X-Cache=[HIT from syq-wn-esfhc01v.light.soufun.com, from syq-wn-ys08.light.soufun.com], 
				X-Powered-By=[ASP.NET], 
				Server=[nginx], 
				Cache-Control=[public], 
				X-AspNet-Version=[4.0.30319], 
				Vary=[Accept-Encoding], 
				Transfer-Encoding=[chunked], 
				Date=[Fri, 16 May 2014 07:35:26 GMT], 
				Content-Encoding=[gzip], 
				Content-Type=[text/html; charset=gb2312]}
				**/
				// 1. 从http响应头信息[Content-Type]中获取      [Content-Type	text/html; charset=GBK]
				HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
				confHttpConnection(httpConn);
				resCode = httpConn.getResponseCode() + "";
				
				if(resCode.startsWith("2")){
					// 判断页面内容是否压缩
					String contType = httpConn.getHeaderField("Content-Encoding");
					if(contType.indexOf("gzip") != -1){
						contZipFlag = true;
					}
					
					String contentType = httpConn.getHeaderField("Content-Type");
			        String matcherStr = "charset=";
					if(StringUtils.isNotEmpty(contentType) && contentType.indexOf(matcherStr) != -1){
						pageEncoding = contentType.substring(contentType.indexOf(matcherStr) + matcherStr.length()).toUpperCase(); 
						closeHttpConn(httpConn);
						
						return pageEncoding;
					}
					closeHttpConn(httpConn);
			        
					// 2. 解析页面源码
					BufferedReader in = null;
					try {
						in = new BufferedReader(new InputStreamReader(url.openStream()));
						
						int loopcnt = 100;
						String line = null;
						
						while ((line = in.readLine()) != null && loopcnt > 0) {
							Pattern encodReg = Pattern.compile("charset=.+?\"");
							Matcher encod = encodReg.matcher(line.toLowerCase());
							while (encod.find()) {
								String encoding = encod.group().replace("\"", "");
								pageEncoding =encoding.substring(8, encoding.length()).toUpperCase().toUpperCase(); 
								
								pageEncodingType = 2;
								return pageEncoding;
							}
							loopcnt --;
						}
					} catch (IOException e1) {
						errorMsg = e1.getMessage();
					} finally {
						try {
							if(null != in){
								in.close();
							}
						} catch (IOException e) {
							errorMsg = e.getMessage();
						}
					}
					
					// 3. 使用工具探测器
					try {
						CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
						Charset charset = detector.detectCodepage(url);
						
						if(null != charset){
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
		public String getPageContent(){
			StringBuilder builder = new StringBuilder();
			
			BufferedReader in = null;
			InputStreamReader inReader = null;
			GZIPInputStream gzin = null;
			try {
                if(isContZipFlag()){
                	// 建立解压流
                	gzin =  new GZIPInputStream(url.openStream());
                	inReader = new InputStreamReader(gzin, pageEncoding);
                } else {
                	inReader = new InputStreamReader(url.openStream(), pageEncoding);
                }
				
				in = new BufferedReader(inReader);
				String line;
				while ((line = in.readLine()) != null ) {
					builder.append(StringUtils.isEmpty(line) ? "" : line);
				}
			} catch (IOException e1) {
				errorMsg = e1.getMessage();
			} finally {
				try {
					if(null != gzin){
						gzin.close();
					}
					if(null != inReader){
						inReader.close();
					}
					if(null != in){
						in.close();
					}
				} catch (IOException e) {
					errorMsg = e.getMessage();
				}
			}
			
			return builder.toString();
		}
		/**
public String getHtmlContent(String htmlurl, String charset)
        throws IOException {
    StringBuffer sb = new StringBuffer();
    String acceptEncoding = "";
    // 1.生成 HttpClinet 对象并设置参数 
    HttpClient httpClient = new HttpClient();
    // 设置 Http 连接超时 5s
    httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(
            5000);
    GetMethod method = new GetMethod(htmlurl);
    // 设置 get 请求超时 5s
    method.getParams()
            .getDoubleParameter(HttpMethodParams.SO_TIMEOUT, 10000);
    // 设置请求重试处理
    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
            new DefaultHttpMethodRetryHandler());
    int statusCode;
    try {
        statusCode = httpClient.executeMethod(method);
        // 判断访问的状态码
        if (statusCode != HttpStatus.SC_OK) {
            return sb.toString();
        } else {
            if (method.getResponseHeader("Content-Encoding") != null)
                acceptEncoding = method
                        .getResponseHeader("Content-Encoding").getValue();
            if (acceptEncoding.toLowerCase().indexOf("gzip") > -1) {
                // 建立gzip解压工作流
                InputStream is;
                is = method.getResponseBodyAsStream();
                GZIPInputStream gzin = new GZIPInputStream(is);
                InputStreamReader isr = new InputStreamReader(gzin, charset); // 设置读取流的编码格式，自定义编码
                java.io.BufferedReader br = new java.io.BufferedReader(isr);
                String tempbf;
                while ((tempbf = br.readLine()) != null) {
                    sb.append(tempbf);
                    sb.append("\r\n");
                }
                isr.close();
                gzin.close();
                System.out.println(sb);
            } else {
                InputStreamReader isr;
                isr = new InputStreamReader(
                        method.getResponseBodyAsStream(), charset);
                java.io.BufferedReader br = new java.io.BufferedReader(isr);
                String tempbf;
                while ((tempbf = br.readLine()) != null) {
                    sb.append(tempbf);
                    sb.append("\r\n");
                }
                isr.close();
            }
        }
    } catch (HttpException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
    method.abort();
    method.releaseConnection();
    return sb.toString();
}
		 **/
		
		private void closeHttpConn(HttpURLConnection httpConn){
			if(null != httpConn){
				httpConn.disconnect();
			}
		}
		private HttpURLConnection confHttpConnection(HttpURLConnection httpConn) throws ProtocolException{
			try {
				httpConn.setConnectTimeout(10000); 
				httpConn.setReadTimeout(10000);   
				httpConn.setRequestMethod("GET");
				httpConn.setRequestProperty("Charset", pageEncoding);
				httpConn.setRequestProperty(
								"User-Agent",
								"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.121 Safari/535.2");
				httpConn.setRequestProperty("X-Forwarded-For", "162.150.10.16");
			} catch (ProtocolException e) {
				throw e;
			}
			return httpConn;
		}
	}
	
	static class PageParser{
		// 扩展信息
		public static Map<String, String> getPageExtInfo(String pageContent){
			Map<String, String> pageInfo = new HashMap<String, String>();
			
			// 网页标题
			String titleName = null;
			Pattern titleReg = Pattern.compile("<title>(.+?)</title>");
			Matcher title = titleReg.matcher(pageContent);
			while (title.find()) {
				titleName = title.group(1);
			}
			if(StringUtils.isNotEmpty(titleName)){
				pageInfo.put(
						"pageTitle",
						titleName.length() > PageLimitLen.TITLE_LEN ? titleName.substring(0, PageLimitLen.TITLE_LEN) : titleName);
			}
			
			// 网页关键字
			String labelName = null;
			Pattern labelReg = Pattern.compile("<meta +name=\"keywords\" +content=\"(.+?)\"");
			Matcher labels = labelReg.matcher(pageContent);
			while (labels.find()) {
				labelName = labels.group(1);
				String labelNameCheck = labelName.replaceAll(" ", "");
				if(labelNameCheck.equals("\"/><metaname=")){
					labelName = "";
				}
				if(labelNameCheck.startsWith("\"><title>")){
					labelName = "";
				}
				if(labelNameCheck.startsWith("\"><link")){
					labelName = "";
				}
			}
			if(StringUtils.isNotEmpty(labelName)){
				pageInfo.put(
						"pageLabel",
						labelName.length() > PageLimitLen.LABEL_LEN ? labelName.substring(0, PageLimitLen.LABEL_LEN) : labelName);
			}
			
			// 网页描述
			String descName = null;
			Pattern descReg = Pattern.compile("<meta +name=\"description\" +content=\"(.+?)\"");
			Matcher desc = descReg.matcher(pageContent);
			while (desc.find()) {
				descName = desc.group(1);
				String descNameCheck = descName.replaceAll(" ", "");
				if(descNameCheck.equals("\"/><metaname=")){
					descName = "";
				}
				if(descNameCheck.startsWith("\"><title>")){
					labelName = "";
				}
				if(descNameCheck.startsWith("\"><link")){
					labelName = "";
				}
			}
			if(StringUtils.isNotEmpty(descName)){
				pageInfo.put(
						"pageDescription",
						descName.length() > PageLimitLen.DESC_LEN ? descName.substring(0, PageLimitLen.DESC_LEN) : descName);
			}
			
			return pageInfo;
		}
		
		// 网址列表
		public static Set<String> getPageExtUrlSet(String pageContent){
			Set<String> pageUrlSet = new HashSet<String>();
			// "http", "https", "ftp", "mailto", "telnet", "file", "ldap", "gopher", 
            // "jdbc", "rmi", "jndi", "jar", "doc", "netdoc", "nfs", "verbatim", "finger", "daytime", 
            // "systemresource"
			Pattern siteReg = Pattern.compile("href=\"?((http|https|ftp):\\/\\/([0-9A-Za-z]+\\.){1,3}[0-9A-Za-z]+)\\/?\"?");
			Matcher site = siteReg.matcher(pageContent);
			while (site.find()) {
				String siteLink = site.group(1);
				
				pageUrlSet.add(siteLink);
			}
			
			return pageUrlSet;
		}
	}
	
	static interface PageLimitLen {
		public static final int TITLE_LEN = 100; 
		public static final int LABEL_LEN = 200; 
		public static final int DESC_LEN = 500; 
	}
}
