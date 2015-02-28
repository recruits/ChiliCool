package com.zzc.netcrawler.busideal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzc.netcrawler.dao.NetInfoMapper;
import com.zzc.netcrawler.domain.NetInfo;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午4:05:52 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SysQueueInfoHelper {
	@Resource
	private NetInfoMapper netInfoDao;
	
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
					while(SysQueueInfoHolder.getQueueSize() > 0){
						NetInfo netInfo = SysQueueInfoHolder.outQueue();
						try{
							netInfoDao.insert(netInfo);
						} catch (Exception exp){
							exp.printStackTrace();
						}
					}
					SysQueueInfoHolder.operQueAddTime();
					
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
