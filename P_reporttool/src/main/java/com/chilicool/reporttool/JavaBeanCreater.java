package com.chilicool.reporttool;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class JavaBeanCreater {
	
	public void createBeanFile(String filePath, TemplateBeanInfo beanInfo){
		if(null == beanInfo || StringUtils.isEmpty(filePath)){
			return ;
		}
		initBeanInfo(filePath, beanInfo);
		
		createTemplateBeanFile();
	}
	
	private void createTemplateBeanFile(){
		String beanPkg = "package " + this.beanInfo.getBeanPackage();
		beanPkg = "package ".equals(beanPkg) ? this.beanPackage : beanPkg;
		
		// 开始生成Bean文件
		StringBuffer beanFile = new StringBuffer(beanPkg);
		StringBuffer beanAttrMethod = new StringBuffer();
		StringBuffer strucFuncName = new StringBuffer();
		StringBuffer strucFuncCont = new StringBuffer();
		
		// 引入List类型
		beanFile.append(lineFeed).append(lineFeed);
		if(this.beanInfo.isHasListAttr()){
			beanFile.append(importListInfo).append(lineFeed).append(importInterfaceInfo);
		} else {
			beanFile.append(importInterfaceInfo);
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
					
					strucFuncName.append(" List<").append(currAttr.getAttrBeanType()).append("> ").append(currAttr.getAttrName()).append(",");
				} else {
					beanFile.append(lineFeed).append(MessageFormat.format(attrStrInfo, currAttr.getAttrName()));
					
					beanAttrMethod.append(lineFeed).append(MessageFormat.format(createAttrMethodInfo, currAttr.getAttrMethodName(), currAttr.getAttrName(), currAttr.getAttrName(), currAttr.getAttrName()));
					beanAttrMethod.append(lineFeed).append(MessageFormat.format(getAttrMethodInfo, currAttr.getAttrMethodName(), currAttr.getAttrName()));
					
					strucFuncName.append(" String ").append(currAttr.getAttrName()).append(",");
				}
				strucFuncCont.append(lineFeed).append("\t\t").append("this.").append(currAttr.getAttrName()).append("=").append(currAttr.getAttrName()).append(";");
			}
		}
		
		String strucFuncNameInfo = strucFuncName.toString();
		strucFuncNameInfo = StringUtils.removeEnd(strucFuncNameInfo, ",");
		String strucFuncContInfo = strucFuncCont.toString();
		
		beanFile.append(lineFeed).append(MessageFormat.format(strucFunction, beanInfo.getBeanName()));
		beanFile.append(lineFeed).append(MessageFormat.format(strucFunctionWithField, beanInfo.getBeanName(), strucFuncNameInfo, strucFuncContInfo));
		beanFile.append(beanAttrMethod.toString());
		beanFile.append(lineFeed).append(classDefEnd);
		
		CommonUtil.writeFileContent(beanFilePath, reDealFileCont(beanFile.toString()));
		
		Map<String, TemplateBeanInfo> subBeanInfos = beanInfo.getSubBeans();
		if(null != subBeanInfos && subBeanInfos.size() > 0){
			Set<String> keyName = subBeanInfos.keySet();
			for(String currAttrName : keyName){
				TemplateBeanInfo currSubBean = subBeanInfos.get(currAttrName);
				if(null != currSubBean){
					currSubBean.setBeanPackage(this.beanInfo.getBeanPackage());	// 补充类路径
					new JavaBeanCreater().createBeanFile(this.beanFileDir, currSubBean);
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
	public String getBeanFilePath() {
		return beanFilePath;
	}


	// 模板对象类
	private String lineFeed = System.getProperty("line.separator");
	private TemplateBeanInfo beanInfo;
	
	// 文件创建基础数据
	private String beanFileDir = "";
	private String beanFilePath = "";
	private String beanPackage = "package cn.cttic.vehicle.business.model;";
	private String importListInfo = "import java.util.List;";
	private String importInterfaceInfo = "import cn.cttic.sysframe.frame.model.ITemplateBean;";
	private String beanDefInfo = "public class {0} extends ITemplateBean`";
	private String strucFunction = "\tpublic {0}() `" + lineFeed + "\t\tsuper();" + lineFeed + "\t!";
	private String strucFunctionWithField = "\tpublic {0}({1}) `" + lineFeed + "\t\tsuper();{2}" + lineFeed + "\t!";
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
