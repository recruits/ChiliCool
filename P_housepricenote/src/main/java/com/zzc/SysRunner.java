package com.zzc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzc.hpnote.busi.SystemControlTask;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * 
 * @author zhangzechen@cttic.cn
 * @date 2014-5-29 上午10:44:16 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class SysRunner {
	private static ApplicationContext app;

	public static void main(String[] args) {
		String[] xmlConf = new String[]{"classpath:spring-config.xml", "classpath:mybatis-config.xml"};
		app = new ClassPathXmlApplicationContext(xmlConf);
		
		SystemControlTask taskRunner = (SystemControlTask) app.getBean("sysController");
		taskRunner.startTask();
	}
}
