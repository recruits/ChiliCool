package com.zzc.hpnote.busi;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


/**
 * 系统启动控制. <br>
 * .
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 下午4:58:17 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SystemControlTask {
	private final static Logger log = Logger.getLogger(SystemControlTask.class);
	@Resource
	private SystemCacheHelper sysCacheHelper;
	@Resource
	private QueueConsumerTask queueConsumerThread;
	@Resource
	private ProcessControlTask processControlThread;
//	private ExecutorService taskThreadPool;
	
	/**
	 * 启动任务;主要进行系统初始化、任务线程创建
	 * @author zhangzechen
	 * @date 2014-5-17 下午5:06:58
	 */
	public void startTask(){
		log.info("--------------------------------------------------");
		log.info("SYS_INFO	: system is starting ...");
		// 1. 系统初始化清理
		/**
		 	1.1 
		**/
		
		
		// 2. 执行初始化工作
		/**
			2.1  初始化系统缓存管理器
			2.2 缓存容器注入数据
		**/
		log.info("--------------------------------------------------");
		log.info("SYS_INFO	: start to init cache ...");
		initCacheMgr();
		log.info("SYS_INFO	: start to init cache-data...");
		initCacheData();
		log.info("SYS_INFO	: finished init cache !");
		log.info("--------------------------------------------------");
		
		// 3. 执行线程池创建工作
		/**
			3.1 创建队列消费线程
			3.2 创建任务处理线程
		**/
		log.info("--------------------------------------------------");
		log.info("SYS_INFO	: start to init thread pool ...");
		initThreadPool();
		log.info("SYS_INFO	: finished init thread pool !");
		log.info("--------------------------------------------------");
	}
	/**
	 * 关闭任务;显式调用来关闭正在执行的任务，在关闭前进行适当的清理工作。
	 * @author zhangzechen
	 * @date 2014-5-17 下午5:07:38
	 */
	public void finishTask(){
		// 关闭缓存
		clearCacheMgr();
		
		// 关闭正在执行的线程
		clearThreadPool();
	}
	
	/**
	 * 创建缓存容器
	 * @author zhangzechen
	 * @date 2014-5-25 上午10:35:42
	 */
	private void initCacheMgr(){
		SystemCache.init();
	}
	/**
	 * 缓存容器注入初始数据
	 * @author zhangzechen
	 * @date 2014-5-28 上午9:48:39
	 */
	private void initCacheData(){
		sysCacheHelper.init();
	}
	/**
	 * 初始化线程池
	 * @author zhangzechen
	 * @date 2014-5-25 上午10:35:59
	 */
	private void initThreadPool(){
//		queueConsumerThread = new QueueConsumerTask();
		// 队列消费者线程[先做单线程]
		queueConsumerThread.start();
		
		new Thread(processControlThread).run();
//		// 任务处理线程[先指定为10个]
//		taskThreadPool = Executors.newFixedThreadPool(SysConst.T_NUM);
//		taskThreadPool.execute(singletonTaskThread);
	}
	
	private void clearCacheMgr(){
		SystemCache.closeCache();
	}
	private void clearThreadPool(){
		// 先关闭任务线程
//		taskThreadPool.shutdown();
		
		// 再关闭队列消费线程
		queueConsumerThread.interrupt();
	}
	
//	private interface SysConst{
//		int T_NUM = 1;
//	}
}
