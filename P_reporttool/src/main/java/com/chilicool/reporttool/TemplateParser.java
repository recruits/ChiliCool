package com.chilicool.reporttool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class TemplateParser {
	
	public TemplateBeanInfo buildTemplateBean(String templateFullName){
		// 初始模板信息
		if(StringUtils.isEmpty(templateFullName)){
			this.templateValid = false;
			return null;
		}
		
		initParam(templateFullName);
		
		readTemplateFileCont();
		
		createTemplateBean();
		
		return this.templateBean;
	}
	
	private void readTemplateFileCont(){
		this.templateCont = CommonUtil.readFileContent(this.templatePath);
	}
	
	private void createTemplateBean(){
		if(templateValid){
			collectAttrStr();
			
			collectAttrList();
			
			createSubBeanList();
		}
	}
	
	/**
	 * 收集模板中的字符串属性
	 * 
	 * @author zhangzechen
	 * @date 2015年3月26日 下午4:16:29
	 */
	private void collectAttrStr(){
		if(null == this.templateBean){
			this.templateBean = new TemplateBeanInfo();
		}
		List<TemplateBeanAttrInfo> attrInfos = this.templateBean.getBeanAttrInfo();
		if(CollectionUtils.isEmpty(attrInfos)){
			attrInfos = new ArrayList<TemplateBeanAttrInfo>();
		}
		
		Pattern attrReg = Pattern.compile("<field\\s+name=\"(\\w+)\"\\s+class=\"java.lang.String\"/>");
		Matcher attrMat = attrReg.matcher(this.templateCont);
		while (attrMat.find()) {
			String attrName = attrMat.group(1);
			
			TemplateBeanAttrInfo attrInfo = new TemplateBeanAttrInfo();
			attrInfo.setAttrName(attrName);
			attrInfo.setAttrType("java.lang.String");
			attrInfo.setList(false);
			attrInfo.setAttrMethodName(attrName.substring(0,1).toUpperCase() + attrName.substring(1));
			attrInfos.add(attrInfo);
		}
		
		this.templateBean.setBeanAttrInfo(attrInfos);
	}
	
	/**
	 * 
	 * 
	 * @author zhangzechen
	 * @date 2015年3月26日 下午4:16:43
	 */
	private void collectAttrList(){
		if(null == this.templateBean){
			this.templateBean = new TemplateBeanInfo();
		}
		List<TemplateBeanAttrInfo> attrInfos = this.templateBean.getBeanAttrInfo();
		if(CollectionUtils.isEmpty(attrInfos)){
			attrInfos = new ArrayList<TemplateBeanAttrInfo>();
		}
		
		Pattern attrReg = Pattern.compile("<field\\s+name=\"(\\w+)\"\\s+class=\"java.util.List\"/>");
		Matcher attrMat = attrReg.matcher(this.templateCont);
		while (attrMat.find()) {
			String attrName = attrMat.group(1);
			
			TemplateBeanAttrInfo attrInfo = new TemplateBeanAttrInfo();
			attrInfo.setAttrName(attrName);
			attrInfo.setAttrType("java.util.List");
			attrInfo.setList(true);
			attrInfo.setAttrMethodName(attrName.substring(0,1).toUpperCase() + attrName.substring(1));
			attrInfos.add(attrInfo);
		}
		
		this.templateBean.setBeanAttrInfo(attrInfos);
	}
	
	private void createSubBeanList(){
		if(null == this.templateBean){
			this.templateBean = new TemplateBeanInfo();
		}
		List<TemplateBeanAttrInfo> attrInfos = this.templateBean.getBeanAttrInfo();
		if(CollectionUtils.isNotEmpty(attrInfos)){
			Map<String, TemplateBeanInfo> subBeanInfos = this.templateBean.getSubBeans();
			if(null == subBeanInfos || subBeanInfos.size() == 0){
				subBeanInfos = new HashMap<String, TemplateBeanInfo>();
			}
			
			boolean hasListFlag = false;
			for(TemplateBeanAttrInfo attrInfo : attrInfos){
				if("java.util.List".equals(attrInfo.getAttrType())){
					Pattern subBeanReg = Pattern
							.compile("<dataSourceExpression><!\\[CDATA\\[new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource\\(\\$F\\{"
									+ attrInfo.getAttrName()
									+ "}\\)\\]\\]></dataSourceExpression>\\s+<subreportExpression><!\\[CDATA\\[\\$P\\{SUBREPORT_DIR\\}\\s+\\+\\s+\"(\\w+).jasper\"\\]\\]></subreportExpression>");
					Matcher subBeanMat = subBeanReg.matcher(this.templateCont);
					while (subBeanMat.find()) {
						String subBeanName = subBeanMat.group(1);
						String subTemplateName = this.templateDir + "\\" + subBeanName + ".jrxml";
						
						TemplateBeanInfo subBeanInfo = new TemplateParser().buildTemplateBean(subTemplateName);
						if(null != subBeanInfo){
							subBeanInfos.put(attrInfo.getAttrName(), subBeanInfo);
						}
						
						attrInfo.setAttrBeanType(subBeanName);
					}
					
					hasListFlag = true;
				}
			}
			
			if (hasListFlag) {
				this.templateBean.setHasListAttr(true);
			}
			this.templateBean.setSubBeans(subBeanInfos);
		}
	}
	
	private void initParam(String templateFullName){
		this.templatePath = templateFullName;
		this.templateDir = templateFullName.substring(0, templateFullName.lastIndexOf("\\"));
		this.templateName = templateFullName.substring(this.templateDir.length() + 1);
		this.templateName = this.templateName.substring(0, this.templateName.lastIndexOf("."));
		
		if(null == this.templateBean){
			this.templateBean = new TemplateBeanInfo();
			this.templateBean.setBeanName(this.templateName);
		}
	}
	
	private boolean templateValid = true;
	private String templateName;	// 模板名称
	private String templateCont;	// 模板内容
	private String templatePath;	// 模板路径，绝对路径
	private String templateDir;		// 模板目录
	private List<String> subTemplateName;			// 子模板名称
	private Map<String, String> subTemplateCont;	// 子模板内容
	private TemplateBeanInfo templateBean;			// 模板Bean
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplateCont() {
		return templateCont;
	}
	public void setTemplateCont(String templateCont) {
		this.templateCont = templateCont;
	}
	public String getTemplatePath() {
		return templatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	public String getTemplateDir() {
		return templateDir;
	}
	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}
	public List<String> getSubTemplateName() {
		return subTemplateName;
	}
	public void setSubTemplateName(List<String> subTemplateName) {
		this.subTemplateName = subTemplateName;
	}
	public Map<String, String> getSubTemplateCont() {
		return subTemplateCont;
	}
	public void setSubTemplateCont(Map<String, String> subTemplateCont) {
		this.subTemplateCont = subTemplateCont;
	}
	public TemplateBeanInfo getTemplateBean() {
		return templateBean;
	}
	public void setTemplateBean(TemplateBeanInfo templateBean) {
		this.templateBean = templateBean;
	}
}
