package com.chilicool.reporttool;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class CreateJavaBean {
	
	public void createBeanFile(String filePath, TemplateBeanInfo beanInfo){
		if(null == beanInfo || StringUtils.isEmpty(filePath)){
			return ;
		}
		initBeanInfo(filePath, beanInfo);
		
		createTemplateBeanFile();
	}
	
	private void createTemplateBeanFile(){
		// 开始生成Bean文件
		StringBuffer beanFile = new StringBuffer(beanPackage);
		StringBuffer beanAttrMethod = new StringBuffer();
		
		// 引入List类型
		if(this.beanInfo.isHasListAttr()){
			beanFile.append(lineFeed).append(lineFeed).append(importListInfo);
		}
		
		// 创建类签名
		String beanName = beanInfo.getBeanName();
		beanFile.append(lineFeed).append(lineFeed).append(MessageFormat.format(beanDefInfo, beanName));
		
		// 创建属性列表，同时生成属性方法列表
		List<TemplateBeanAttrInfo> beanAttrs = beanInfo.getBeanAttrInfo();
		if(CollectionUtils.isNotEmpty(beanAttrs)){
			for(TemplateBeanAttrInfo currAttr : beanAttrs){
				if(currAttr.isList()){
					beanFile.append(lineFeed).append(MessageFormat.format(attrListInfo, currAttr.getAttrBeanType(), currAttr.getAttrName()));
					
					beanAttrMethod.append(lineFeed).append(MessageFormat.format(createListMethodInfo, currAttr.getAttrMethodName(), currAttr.getAttrBeanType(), currAttr.getAttrName(), currAttr.getAttrName(), currAttr.getAttrName() ));
					beanAttrMethod.append(lineFeed).append(MessageFormat.format(getListMethodInfo, currAttr.getAttrBeanType(), currAttr.getAttrMethodName(), currAttr.getAttrName()));
				} else {
					beanFile.append(lineFeed).append(MessageFormat.format(attrStrInfo, currAttr.getAttrName()));
					
					beanAttrMethod.append(lineFeed).append(MessageFormat.format(createAttrMethodInfo, currAttr.getAttrMethodName(), currAttr.getAttrName(), currAttr.getAttrName(), currAttr.getAttrName()));
					beanAttrMethod.append(lineFeed).append(MessageFormat.format(getAttrMethodInfo, currAttr.getAttrMethodName(), currAttr.getAttrName()));
				}
			}
		}
		
		beanFile.append(beanAttrMethod.toString());
		beanFile.append(lineFeed).append(classDefEnd);
		
		FileOperUtil.writeFileContent(beanFilePath, reDealFileCont(beanFile.toString()));
		
		Map<String, TemplateBeanInfo> subBeanInfos = beanInfo.getSubBeans();
		if(null != subBeanInfos && subBeanInfos.size() > 0){
			Set<String> keyName = subBeanInfos.keySet();
			for(String currAttrName : keyName){
				TemplateBeanInfo currSubBean = subBeanInfos.get(currAttrName);
				if(null != currSubBean){
					new CreateJavaBean().createBeanFile(this.beanFileDir, currSubBean);
				}
			}
		}
	}
	
	private String reDealFileCont(String fileCont){
		return fileCont.replaceAll(LEFT_BRE , "{").replaceAll(RIGHT_BRE , "}");
	}
	
	private void initBeanInfo(String filePath, TemplateBeanInfo beanInfo){
		this.beanFileDir = filePath;
		this.beanFilePath = filePath + "\\" + beanInfo.getBeanName() + ".java";
		this.beanInfo = beanInfo;
	}
	
	// 模板对象类
	private String lineFeed = System.getProperty("line.separator");
	private TemplateBeanInfo beanInfo;
	
	// 文件创建基础数据
	private String beanFileDir = "";
	private String beanFilePath = "";
	private String beanPackage = "package cn.cttic.wtms.common.report.model;";
	private String importListInfo = "import java.util.List;";
	private String beanDefInfo = "public class {0} extends ITemplateBean`";
	private String attrStrInfo = "\tprivate String {0};";
	private String attrListInfo = "\tprivate List<{0}> {1};";
	private String getAttrMethodInfo = "\tpublic String get{0}() `" + lineFeed + "\t\treturn {1};" + lineFeed + "\t!";
	private String createAttrMethodInfo = "\tpublic void set{0}(String {1}) `" + lineFeed + "\t\tthis.{2} = {3};" + lineFeed + "\t!";
	private String getListMethodInfo = "\tpublic List<{0}> get{1}() `" + lineFeed + "\t\treturn {2};" + lineFeed + "\t!";
	private String createListMethodInfo = "\tpublic void set{0}(List<{1}> {2}) `" + lineFeed + "\t\tthis.{3} = {4};" + lineFeed + "\t!";
	private String classDefEnd = "!";
	private String LEFT_BRE = "`";
	private String RIGHT_BRE = "!";
}
