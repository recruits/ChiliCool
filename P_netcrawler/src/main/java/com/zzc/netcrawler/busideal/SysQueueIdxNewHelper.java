package com.zzc.netcrawler.busideal;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zzc.netcrawler.dao.NetIndexMapper;
import com.zzc.netcrawler.domain.NetIndex;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午4:06:08 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SysQueueIdxNewHelper {
	private final Logger log = Logger.getLogger(SysQueueTaskHelper.class);
	@Resource
	private NetIndexMapper netIdxDao;
	
	/**
	 * 启动一个队列消费线程
	 * @author zhangzechen
	 * @date 2014-6-10 下午4:15:29
	 */
	public void startConsume(){
		Thread runner = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					while(SysQueueIdxNewHolder.getQueueSize() > 0){
						NetIndex netIdx = SysQueueIdxNewHolder.outQueue();
						netIdxDao.insert(netIdx);
						log.info("T-[IN]	: finished save one idx info!");
					}
					
					try {
						Thread.sleep(ConstBusiCode.QueHelperUtil.T_SLEEP_TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		runner.start();
	}
}
