package com.chilicool.reporttool;


public class GenerateReportCodeImpl implements GenerateReportCode{
	
	public static void main(String[] args) {
		String fileName = "C:\\Users\\zhangzechen\\Desktop\\dtwork\\报表业务模板\\GN\\GNNormalCargo.jrxml";
		new GenerateReportCodeImpl().generateCode(fileName);
	}

	@Override
	public void generateCode(String fileName) {
		String filePath = "C:\\Users\\zhangzechen\\Desktop\\dtwork";
		
		TemplateParser parser = new TemplateParser();
		TemplateBeanInfo templateBean = parser.buildTemplateBean(fileName);
		System.out.println("----- parse template finished , bean-name:" + templateBean.getBeanName());
		new CreateJavaBean().createBeanFile(filePath, templateBean);
		System.out.println("----- create bean file finished .");
		new CreateServiceBean().createBeanFile(filePath, templateBean);
		System.out.println("----- create service file finished .");
	}

	@Override
	public void generateJavaBean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateServiceBean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCfgTemplateInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCfgTemplateAttrInfo() {
		// TODO Auto-generated method stub
		
	}

	public TemplateBeanInfo convertTemplateToBean(String filePath){
		
		return null;
	}
}
