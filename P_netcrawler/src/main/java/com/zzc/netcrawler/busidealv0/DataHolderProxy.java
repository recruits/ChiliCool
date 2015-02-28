package com.zzc.netcrawler.busidealv0;

import com.zzc.netcrawler.beanset.NetAddr;
import com.zzc.netcrawler.service.PageHolderUrl;

public class DataHolderProxy {
	private static DataHolder dataHolder = new DataHolder();
	
	/**
	 * 系统启动，初始化使用
	 * @return
	 */
	public static boolean initDataHolder(){
		return dataHolder.initQueue();
	}
	
	/**
	 * 执行线程获取任务
	 * @return
	 */
	public static NetAddr getOneTask(int threadId){
		return dataHolder.getOneTask(threadId);
	}
	
	/**
	 * 执行线程提交任务
	 * @return
	 */
	public static void submitOneTask(PageHolderUrl pageHolder){
		dataHolder.addOneTask(pageHolder);
	}
	
	public static void startLogger(){
		dataHolder.netLogController();
	}
}
