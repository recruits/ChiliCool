package com.zzc.netcrawler.busidealv0;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.zzc.netcrawler.beanset.NetAddr;
import com.zzc.netcrawler.service.PageHolderUrl;

public class SysRunner {
	private static Logger log = Logger.getLogger(SysRunner.class);
	/**
		Java通过Executors提供四种线程池，分别为：
		newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
		newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
		newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
		newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
	**/
	public void start(int threadNbr){
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(threadNbr);
		
		log.info(ConstHolder.StrTool.initPrefix("task-runner"));
		for (int i = 0; i < threadNbr; i++) {
		    final int index = i;
		    
		    log.info(ConstHolder.StrTool.dealPrefix("create task-" + index));
		    fixedThreadPool.execute(new Runnable() {
		        @Override
		        public void run() {
		        	int sleepTimes = 0;
		        	
		        	while(true){
		            	NetAddr task = DataHolderProxy.getOneTask(index);
		            	
		            	log.info("get one task successful:\n" + task);
		            	if(null != task){
		            		// 任务有效，执行
		            		try {
								PageHolderUrl pageHolder = new PageHolderUrl("");
								
								DataHolderProxy.submitOneTask(pageHolder);
								
								log.info("deal one task successful!");
							} catch (MalformedURLException e) {
								log.error(e);
							} catch (IOException e) {
								log.error(e);
							}
		            	} else {
		            		log.info("task is unvaild, and read to sleep at " + sleepTimes + " time!");
		            		try {
		            			if(sleepTimes >= ConstHolder.TNumber.T_SLEEP_NBR){
		            				break;
			            		}
		            			sleepTimes ++;
								Thread.sleep(60 * 1000);
							} catch (InterruptedException e) {
								log.error(e);
							}
		            	}
		        	}
		        }
		    });
		    log.info(ConstHolder.StrTool.dealSuffix("create task-" + index));
		}
		log.info(ConstHolder.StrTool.initSuffix("task-runner"));
	}
}
