package com.chilicool.core;

import java.util.HashSet;
import java.util.Set;

/**
 * 网页保存类. <br>
 * 保存与页面相关的解析内容，包括：编码、标题、标签、描述、内容、网址集.
 * 
 * @author zhangzechen@chilicool.com
 * @date 2014-9-30 下午4:27:43 <br>
 *       Copyright: Copyright (c) 2014 chilicool
 */
public class WebPage {
	private String pageUrl = "";
	private String pageContent = "";
	private String pageEncoding = "";
	private String pageTitle = "";
	private String pageLabel = "";
	private String pageDescription = "";
	private Set<String> pageUrlSet = new HashSet<String>();
	public String getPageUrl() {
		return pageUrl;
	}
	public String getPageEncoding() {
		return pageEncoding;
	}
	public String getPageContent() {
		return pageContent;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public String getPageLabel() {
		return pageLabel;
	}
	public String getPageDescription() {
		return pageDescription;
	}
	public Set<String> getPageUrlSet() {
		return pageUrlSet;
	}
}
