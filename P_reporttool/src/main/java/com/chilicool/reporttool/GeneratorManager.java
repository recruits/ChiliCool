package com.chilicool.reporttool;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorManager {
	
	@Autowired
	private GeneratReportCode currBean;
	
	public void generate() {
		try {
			//GeneratReportCode currBean = (GeneratReportCode) SpringContextUtil.getBean(GeneratReportCode.class);
			CommonUtil.logInfo("spring 初始化完成，准备生成代码...");
			currBean.generateCode();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
	
	/*
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "cttic-data.xml", "cttic-tools.xml", "data/mybatis-config.xml" });
			GeneratReportCode currBean = (GeneratReportCode) context.getBean("reportToolUtil");
			CommonUtil.logInfo("spring 初始化完成，准备生成代码...");
			currBean.generateCode();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
	 */
}
