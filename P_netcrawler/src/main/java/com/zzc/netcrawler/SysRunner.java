package com.zzc.netcrawler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzc.netcrawler.busideal.SysController;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午5:11:13 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class SysRunner {
	private static ApplicationContext app;
	
	public static void main(String[] args) {
		String[] xmlConf = new String[]{"classpath:spring-config.xml", "classpath:mybatis-config.xml"};
		app = new ClassPathXmlApplicationContext(xmlConf);
		
		SysController taskRunner = (SysController) app.getBean("sysController");
		taskRunner.init();
		taskRunner.sysStart();
	}
}
