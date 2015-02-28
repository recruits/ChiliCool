package com.zzc.hpnote.service;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzc.hpnote.busi.SystemControlTask;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-28 下午12:05:42 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mybatis-config.xml","classpath:spring-config.xml"})
public class SystemControlTaskTest {
	@Resource
	private SystemControlTask sysControllerTask;
	/**
	 *
	 * @throws java.lang.Exception 
	 * @author zhangzechen
	 * @date 2014-5-28 下午12:05:42
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 *
	 * @throws java.lang.Exception 
	 * @author zhangzechen
	 * @date 2014-5-28 下午12:05:42
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		sysControllerTask.startTask();
	}

}
