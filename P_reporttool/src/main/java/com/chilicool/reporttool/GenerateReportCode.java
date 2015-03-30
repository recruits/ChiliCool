package com.chilicool.reporttool;

public interface GenerateReportCode {
	public void generateCode(String fileName);
	public void generateJavaBean();
	public void generateServiceBean();
	public void addCfgTemplateInfo();
	public void addCfgTemplateAttrInfo();
}
