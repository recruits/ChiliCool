package com.chilicool.fang_data;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.chilicool.core.PageHolder;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * 
 * @author zhangzechen@cttic.cn
 * @date 2014-10-7 上午11:10:58 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class PageHelper {
	public String getWebUrl(){
		return "http://esf.fang.com/newsecond/newslist/{0}_5.htm";
	}
	
	public String getAbsoluteFilePath(String filePath) {
		if (StringUtils.isEmpty(filePath)) {
			return null;
		}
		URL url = this.getClass().getResource(filePath);
		if (null == url || StringUtils.isEmpty(url.getFile())) {
			return null;
		}
		return url.getFile();
	}

	public List<PageData> dealWebPage(String webUrl)
			throws MalformedURLException, IOException {
		List<PageData> pageDatas = new ArrayList<PageData>();
		String pageContent = new PageHolder(webUrl).getPageContent();

		// 网页关键字
		Pattern labelReg = Pattern
				.compile("<li><span class=\"txt\"><a href=\"http://esf.fang.com/newsecond/news/[0-9]{7,8}\\.htm\" target=\"_blank\">(.+?)</a></span><span class=\"time gray6\">([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2})</span></li>");
		Matcher labels = labelReg.matcher(pageContent);
		while (labels.find()) {
			PageData pageData = new PageData();
			pageData.setCont(labels.group(1).trim());
			pageData.setDate(labels.group(2).trim());
			pageDatas.add(pageData);
		}

		return pageDatas;
	}
}
