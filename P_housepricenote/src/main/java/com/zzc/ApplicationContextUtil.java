package com.zzc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-29 上午11:03:47 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class ApplicationContextUtil implements ApplicationContextAware{
	private static ApplicationContext context;
	/**
	 *
	 * @param applicationContext
	 * @throws BeansException 
	 * @author zhangzechen
	 * @date 2014-5-29 上午11:04:36
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
	public static ApplicationContext getContext() {
		return context;
	}
}
