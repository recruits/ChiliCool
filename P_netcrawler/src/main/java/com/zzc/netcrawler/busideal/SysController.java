package com.zzc.netcrawler.busideal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午4:27:25 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SysController {
	private static Logger log = Logger.getLogger(SysController.class);
	
	@Resource
	private SysCacheHelper cacheHelper;
	@Resource
	private SysQueueIdxHelper queIdxHelper;
	@Resource
	private SysQueueIdxNewHelper queIdxNewHelper;
	@Resource
	private SysQueueInfoHelper queInfoHelper;
	@Resource
	private SysQueueTaskHelper queTaskHelper;
	@Resource
	private SysLogHelper queLogHelper;
	
	public void init(){
		log.info("SYS INFO	: start to init sys component ...");
		cacheHelper.init();
		queTaskHelper.init();
		log.info("SYS INFO	: finished init sys component !");
	}
	
	public void sysStart(){
		log.info("SYS INFO	: start to run sys component ...");
		queIdxHelper.startConsume();
		queIdxNewHelper.startConsume();
		queInfoHelper.startConsume();
		queTaskHelper.startConsume();
		queLogHelper.startConsume();
		
		createSysDealer();
		log.info("SYS INFO	: finished run sys component !");
	}
	
	private void createSysDealer(){
		log.info("SYS INFO	: start to create busi dealer ...");
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(ConstThread.T_NUM);
		for (int i = 0; i < ConstThread.T_NUM; i++) {
			fixedThreadPool.execute(new BusiDealer());
			log.info("SYS INFO	: finished create busi dealer[" + i + "] !");
		}
		log.info("SYS INFO	: finished create all busi dealer, total number is[" + ConstThread.T_NUM + "]!");
	}
		
	public interface ConstThread{
		int T_NUM = 500; // 任务线程总数
		int TID_NUM = 5; // 新解析数据入表线程总数
	}
}
