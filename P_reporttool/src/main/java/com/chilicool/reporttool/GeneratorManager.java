package com.chilicool.reporttool;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GeneratorManager {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "app-data.xml", "app-tools.xml", "data/mybatis-config.xml" });
			GeneratReportCode currBean = (GeneratReportCode) context.getBean("reportToolUtil");
			CommonUtil.logInfo("spring 初始化完成，准备生成代码...");
			currBean.generateCode();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
