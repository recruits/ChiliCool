package com.chilicool.reporttool;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

@Service
public class GeneratReportCode {

	public void generateCode() {
		initParam();
		
		createBeanParser();
		
		generateJavaBean();
		
		generateServiceBean();
		
		generateDbData();
	}

	public void createBeanParser(){
		if(!nextStep){
			return;
		}
		
		String tFilePath = this.propObj.getProperty(CommonUtil.templateFilePath);
		if(StringUtils.isEmpty(tFilePath)){
			CommonUtil.logInfo(CommonUtil.ERROR,"配置数据模板文件属性为空，请检查【printTemplate.properties  -->  templateFilePath】");
			nextStep = false;
			return;
		}
		beanParser = new TemplateParser();
		beanInfo = beanParser.buildTemplateBean(tFilePath);
		CommonUtil.logInfo("模板文件解析完成，对应的JAVABEAN名称：" + beanInfo.getBeanName());
	}
	
	public void generateJavaBean() {
		if(!nextStep){
			return;
		}
		
		String javaBeanPath = this.propObj.getProperty(CommonUtil.javaBeanPath);
		if(StringUtils.isEmpty(javaBeanPath)){
			CommonUtil.logInfo(CommonUtil.ERROR,"配置数据JavaBean路径为空，请检查【printTemplate.properties  -->  javaBeanPath】");
			nextStep = false;
			return;
		}
		
		this.beanInfo.setBeanPackage(this.beanPackage);
		javaBeanCreater = new JavaBeanCreater();
		javaBeanCreater.createBeanFile(javaBeanPath, beanInfo);
		CommonUtil.logInfo("JavaBean文件创建完成，文件路径：" + javaBeanCreater.getBeanFilePath());
	}

	public void generateServiceBean() {
		if(!nextStep){
			return;
		}
		
		String serviceBeanPath = this.propObj.getProperty(CommonUtil.serviceBeanPath);
		if(StringUtils.isEmpty(serviceBeanPath)){
			CommonUtil.logInfo(CommonUtil.ERROR,"配置数据ServiceBean路径为空，请检查【printTemplate.properties  -->  serviceBeanPath】");
			nextStep = false;
			return;
		}
		
		this.beanInfo.setServiceBeanPackage(this.serviceBeanPackage);
		serviceBeanCreater = new ServiceBeanCreater();
		serviceBeanCreater.createBeanFile(serviceBeanPath, beanInfo);
		CommonUtil.logInfo("ServiceBean文件创建完成，文件路径：" + serviceBeanCreater.getBeanFilePath());
	}
	
	public void generateDbData(){
		if(!nextStep || ignoreDbDataCheck()){
			return;
		}
		
		try {
			dbDataService = (DbDataService) SpringContextUtil.getBean(DbDataService.class);
			dbDataService.saveCfgData(beanInfo, serviceBeanCreater.getServiceBeanName());
		} catch (BeansException e) {
			e.printStackTrace();
		} 
	}
	
	private boolean ignoreDbDataCheck(){
		if(StringUtils.isNotEmpty(ignoreDbData) && "Y".equals(ignoreDbData.toUpperCase())){
			CommonUtil.logInfo("跳过模板信息插入数据库操作，如果需要插入数据库，请修改【printTemplate.properties  -->  ignoreDbData=N】！");
			return true;
		}
		return false;
	}
	
	private Properties propObj = null;
	private TemplateBeanInfo beanInfo = null;
	private TemplateParser beanParser = null;
	private JavaBeanCreater javaBeanCreater = null;
	private ServiceBeanCreater serviceBeanCreater = null;
	private DbDataService dbDataService = null;
	private boolean nextStep = true;
	private String ignoreDbData = "";
	private String beanPackage = "";
	private String serviceBeanPackage = "";
	
	private void initParam(){
		if(null == propObj){
			this.propObj = CommonUtil.getProperties();
			this.ignoreDbData = this.propObj.getProperty(CommonUtil.ignoreDbData);
			this.beanPackage = this.propObj.getProperty(CommonUtil.javaBeanPackage);
			this.serviceBeanPackage = this.propObj.getProperty(CommonUtil.serviceBeanPackage);
		}
	}
}
