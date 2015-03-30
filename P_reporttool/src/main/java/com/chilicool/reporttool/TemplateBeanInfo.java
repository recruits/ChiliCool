package com.chilicool.reporttool;

import java.util.List;
import java.util.Map;

public class TemplateBeanInfo {
	private String beanName;
	private List<TemplateBeanAttrInfo> beanAttrInfo;
	private boolean hasListAttr;
	private Map<String, TemplateBeanInfo> subBeans;
//	private List<TemplateBeanInfo> subBeans;
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public List<TemplateBeanAttrInfo> getBeanAttrInfo() {
		return beanAttrInfo;
	}
	public void setBeanAttrInfo(List<TemplateBeanAttrInfo> beanAttrInfo) {
		this.beanAttrInfo = beanAttrInfo;
	}
	public boolean isHasListAttr() {
		return hasListAttr;
	}
	public void setHasListAttr(boolean hasListAttr) {
		this.hasListAttr = hasListAttr;
	}
	public void setSubBeans(Map<String, TemplateBeanInfo> subBeans) {
		this.subBeans = subBeans;
	}
	public Map<String, TemplateBeanInfo> getSubBeans() {
		return subBeans;
	}
}