package com.chilicool.reporttool;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chilicool.reporttool.dao.CfgPrintTemplateAttrMapper;
import com.chilicool.reporttool.dao.CfgPrintTemplateMapper;
import com.chilicool.reporttool.domain.CfgPrintTemplate;
import com.chilicool.reporttool.domain.CfgPrintTemplateAttr;
import com.chilicool.reporttool.domain.CfgPrintTemplateExample;

@Service
public class DbDataService {

	@Autowired
	private CfgPrintTemplateMapper cfgPrintTemplateMapper;
	@Autowired
	private CfgPrintTemplateAttrMapper cfgPrintTemplateAttrMapper;
	
	public void saveCfgData(TemplateBeanInfo beanInfo, String serviceBeanName){
		initParam(beanInfo, serviceBeanName);
		
		// 查询配置数据是否已经存在
		boolean checkFlag = ifCfgDataExist();
		
		if(!checkFlag){
			return ;
		}
		
		// 插入配置记录[template]
		String templateId = addTemplateInfoToDb();
		
		// 插入配置记录[templateAttr]
		addTemplateAttrInfoToDb(templateId);
	}
	
	private void addTemplateAttrInfoToDb(String templateId){
		List<TemplateBeanAttrInfo> templateAttrs = this.beanInfo.getBeanAttrInfo();
		if(CollectionUtils.isEmpty(templateAttrs)){
			logErrorInfo("模板属性数据为空，入库数据为：0");
		} else {
			for(TemplateBeanAttrInfo currAttrInfo : templateAttrs){
				if("java.util.List".equals(currAttrInfo.getAttrType())){
					continue;
				}
				CfgPrintTemplateAttr cfgPrintTemplateAttr = new CfgPrintTemplateAttr();
				cfgPrintTemplateAttr.setAttrCode(currAttrInfo.getAttrName());
				cfgPrintTemplateAttr.setTemplateId(templateId);
				cfgPrintTemplateAttr.setAttrValueFormat("{0}");
				
				cfgPrintTemplateAttrMapper.insert(cfgPrintTemplateAttr);
			}
			logErrorInfo("模板属性数据插入成功，入库数据为：" + templateAttrs.size());
		}
	}
	
	private String addTemplateInfoToDb(){
		CfgPrintTemplate cfgPrintTemplate = buildTemplateInfo();
		cfgPrintTemplateMapper.insert(cfgPrintTemplate);
		logErrorInfo("模板配置数据入库成功，templateId=" + cfgPrintTemplate.getTemplateId());
		return cfgPrintTemplate.getTemplateId();
	}
	
	private CfgPrintTemplate buildTemplateInfo(){
		Date currTime = new Date();
		CfgPrintTemplate cfgPrintTemplate = new CfgPrintTemplate();
		cfgPrintTemplate.setTemplateId(generateTemplateId());
		cfgPrintTemplate.setTemplateName(templateName);
		cfgPrintTemplate.setPrintName(templateName);
		cfgPrintTemplate.setTemplateLang("C");
		cfgPrintTemplate.setTemplatePath(templatePath);
		cfgPrintTemplate.setBusiType(busiType);
		cfgPrintTemplate.setTemplateVersion("00");
		cfgPrintTemplate.setTemplateService(serviceBeanName);
		cfgPrintTemplate.setUseType("1");
		cfgPrintTemplate.setCreateDate(currTime);
		cfgPrintTemplate.setModifyDate(currTime);
		cfgPrintTemplate.setState("1");
		cfgPrintTemplate.setTemplateGroup(templateGroup);
		return cfgPrintTemplate;
	}
	
	private boolean ifCfgDataExist(){
		templateName = this.propObj.getProperty(CommonUtil.templateName);
		templatePath = this.propObj.getProperty(CommonUtil.templatePath);
		templateGroup = this.propObj.getProperty(CommonUtil.templateGroup);
		busiType = this.propObj.getProperty(CommonUtil.busiType);

		if (StringUtils.isEmpty(templateName)
				|| StringUtils.isEmpty(templatePath)
				|| StringUtils.isEmpty(busiType)
				|| StringUtils.isEmpty(templateGroup)) {
			logErrorInfo("配置数据缺失，请检查：[printTemplate.properties  -->  templateName,templatePath,templateGroup,busiType] ");
			return false;
		}

		templateGroup = templateGroup.toUpperCase();
		CfgPrintTemplateExample example = new CfgPrintTemplateExample();
		CfgPrintTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andTemplateNameEqualTo(templateName);

		CfgPrintTemplateExample.Criteria criteria2 = example.createCriteria();
		criteria2.andTemplatePathEqualTo(templatePath);
		example.or(criteria2);

		CfgPrintTemplateExample.Criteria criteria3 = example.createCriteria();
		criteria3.andBusiTypeEqualTo(busiType);
		example.or(criteria3);

		List<CfgPrintTemplate> cfgPrintTemplates = cfgPrintTemplateMapper
				.selectByExample(example);
		if (CollectionUtils.isNotEmpty(cfgPrintTemplates)) {
			logErrorInfo("配置数据在数据库中已经存在，请检查配置数据是否设置正确：[printTemplate.properties  -->  templateName,templatePath,busiType] ");
			return false;
		}

		return true;
	}
	
	private String generateTemplateId(){
		CfgPrintTemplateExample example = new CfgPrintTemplateExample();
		CfgPrintTemplateExample.Criteria criteria = example.createCriteria();
		criteria.andTemplateGroupEqualTo(templateGroup);
		example.setOrderByClause(" template_id desc");
		List<CfgPrintTemplate> cfgPrintTemplates = cfgPrintTemplateMapper.selectByExample(example);
		
		String templateId = "";
		if(CollectionUtils.isNotEmpty(cfgPrintTemplates)){
			CfgPrintTemplate currCfgPrintTemplate = cfgPrintTemplates.get(0);
			String maxTemplateId = currCfgPrintTemplate.getTemplateId();
			if(StringUtils.isNotEmpty(maxTemplateId)){
				templateId = (Long.valueOf(maxTemplateId) + 1) + "";
			}
		}
		if(StringUtils.isEmpty(templateId)){
			templateId = createTemplateIdByGroup();
		}
		return templateId;
	}
	
	private String createTemplateIdByGroup(){
		if("GN".equals(templateGroup)){
			return "100001";
		} else if ("GJ".equals(templateGroup)){
			return "200001";
		} else {
			return "300001";
		}
	}
	
	private void logErrorInfo(String error){
		System.out.println("----- " + error);
	}
	
	private void initParam(TemplateBeanInfo beanInfo, String serviceBeanName){
		this.serviceBeanName = serviceBeanName;
		this.beanInfo = beanInfo;
		this.propObj = CommonUtil.getProperties();
	}
	
	private TemplateBeanInfo beanInfo; 
	private Properties propObj;
	private String templateName = "";
	private String templatePath = "";
	private String templateGroup = "";
	private String busiType = "";
	private String serviceBeanName = "";
}
