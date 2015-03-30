package com.chilicool.reporttool;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

public class CreateServiceBean {

	public void createBeanFile(String filePath, TemplateBeanInfo beanInfo){
		if(null == beanInfo || StringUtils.isEmpty(filePath)){
			return ;
		}
		initClassInfo(filePath, beanInfo);
		
		createTemplateBeanFile();
	}
	
	private void createTemplateBeanFile(){
		// 开始生成Bean文件
		StringBuffer beanFile = new StringBuffer(beanPackage);
		
		// 引入类型
		beanFile.append(lineFeed).append(lineFeed).append(importListInfo);
		
		// 创建类签名
		beanFile.append(lineFeed).append(lineFeed).append(MessageFormat.format(beanDefInfo, this.serviceName));
		
		// 创建方法列表
		beanFile.append(lineFeed).append(lineFeed).append(impMethod1);
		beanFile.append(lineFeed).append(lineFeed).append(impMethod2);
		
		beanFile.append(lineFeed).append(classDefEnd);
		
		FileOperUtil.writeFileContent(beanFilePath, reDealFileCont(beanFile.toString()));
	}
	
	private String reDealFileCont(String fileCont){
		return fileCont.replaceAll(LEFT_BRE , "{").replaceAll(RIGHT_BRE , "}");
	}
	
	private void initClassInfo(String filePath, TemplateBeanInfo beanInfo){
		String beanName = beanInfo.getBeanName();
		String prefix = beanName.substring(0,2).toUpperCase();
		if(prefix.equals("GN") || prefix.equals("GJ") || prefix.equals("HX")){
			beanName = prefix + "Deal" + beanName.substring(2) + "Service";
		}
		this.serviceName = beanName;
		this.beanFileDir = filePath;
		this.beanFilePath = filePath + "\\" + beanName + ".java";
		this.beanInfo = beanInfo;
	}
	
	private String lineFeed = System.getProperty("line.separator");
	private TemplateBeanInfo beanInfo;
	
	private String serviceName = "";
	private String beanFileDir = "";
	private String beanFilePath = "";
	private String beanPackage = "package cn.cttic.wtms.common.report.service.impl;";
	private String importListInfo = "import java.util.List;" + lineFeed + "import java.util.Map;" + lineFeed + "import org.springframework.stereotype.Service;" + lineFeed + "import cn.cttic.wtms.common.report.model.ITemplateBean;";
	private String beanDefInfo = "@Service" + lineFeed + "public class {0} extends DealBaseBusiService`";
	private String impMethod1 = "\t@Override" + lineFeed + "\tprotected List<? extends ITemplateBean> buildDataSource() `" + lineFeed + "\t\treturn null;" + lineFeed + "\t!";
	private String impMethod2 = "\t@Override" + lineFeed + "\tprotected Map<String, Object> buildReportParams() `" + lineFeed + "\t\treturn null;" + lineFeed + "\t!";
	private String classDefEnd = "!";
	private String LEFT_BRE = "`";
	private String RIGHT_BRE = "!";
}
