package com.zzc.netcrawler.busideal;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.zzc.netcrawler.domain.NetIndex;
import com.zzc.netcrawler.domain.NetInfo;
import com.zzc.netcrawler.service.PageHolderUrl;


/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午4:37:25 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class BusiDealer implements Runnable{
	private final Logger log = Logger.getLogger(BusiDealer.class);
	private static int EXEC_TIME = 0;
	/**
	 * 
	 * @author zhangzechen
	 * @date 2014-6-10 下午4:38:11
	 */
	@Override
	public void run() {
		while(true){
			Thread currThread = Thread.currentThread();
			log.info("BUSI INFO		: it's the dealer-[" + currThread.getId() + "]'s [" + (EXEC_TIME++) + "] time running... ");
			
			// 1. 获取任务
			NetIndex netIdx = SysQueueTaskHolder.outQueue();
			if(null == netIdx){
				sleepForShort();
				continue;
			}
			log.info("BUSI INFO		: 1. get task info successful ! ");
			
			// 2. 处理任务
			Set<String> netUrls = null;
			NetInfo netInfo = null;
			Date currTime = new Date();
			String execMsg = "";
			try {
				PageHolderUrl pageHolder = new PageHolderUrl(netIdx.getNetUrl());
				execMsg = pageHolder.getPageErrorMsg();
				
				if(execMsg.equals("")){
					netInfo = pageHolder.getNetInfo();
					netInfo.setNetId(netIdx.getNetId());
					
					netIdx.setStsId(ConstBusiCode.NetSts.STS_DONE);
					netIdx.setUpdateTime(currTime);
					
					netUrls = pageHolder.getPageUrlSet();
				} else {
					netIdx.setStsId(ConstBusiCode.NetSts.STS_EXEC);
				}
			} catch (MalformedURLException e) {
				netIdx.setStsId(ConstBusiCode.NetSts.STS_EXEC);
				e.printStackTrace();
			} catch (IOException e) {
				netIdx.setStsId(ConstBusiCode.NetSts.STS_EXEC);
				e.printStackTrace();
			}
			netIdx.setExecMsg(execMsg);
			log.info("BUSI INFO		: 2. deal task info successful ! ");
			
			// 3. 验正缓存数据
			List<NetIndex> netIdxNews = new ArrayList<NetIndex>(); 
			if(!CollectionUtils.isEmpty(netUrls)){
				for(String netUrl : netUrls){
					if(SysCacheHolder.existNetUrlInCache(netUrl)){
						continue;
					} else {
						// 加入缓存
						SysCacheHolder.putNetUrlToCache(netUrl);
						
						// 加入队列
						NetIndex netIdxNew = new NetIndex();
						netIdxNew.setCreateTime(currTime);
						netIdxNew.setUpdateTime(currTime);
						netIdxNew.setNetUrl(netUrl);
						netIdxNew.setStsId(ConstBusiCode.NetSts.STS_ADD);
						netIdxNews.add(netIdxNew);
					}
				}
			}
			log.info("BUSI INFO		: 3. check task info in cache successful ! ");
			
			// 4. 提交到队列
			while(!SysQueueIdxHolder.inQueue(netIdx)){
				sleepForShort();
			}
			
			if(null != netInfo){
				while(!SysQueueInfoHolder.inQueue(netInfo)){
					sleepForShort();
				}
			}
			if(null != netIdxNews){
				for(NetIndex netIdxTmp : netIdxNews){
					while(!SysQueueIdxNewHolder.inQueue(netIdxTmp)){
						sleepForShort();
					}
				}
			}
			log.info("BUSI INFO		: 4. submit task info into queue successful ! ");
		}
	}
	
	private void sleepForShort(){
		try {
			Thread.sleep(ConstBusiCode.QueHelperUtil.T_SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
