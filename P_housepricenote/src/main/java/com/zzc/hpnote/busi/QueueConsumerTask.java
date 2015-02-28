package com.zzc.hpnote.busi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzc.hpnote.dao.BaseInfoMapper;
import com.zzc.hpnote.dao.PriceInfoMapper;
import com.zzc.hpnote.domain.BaseInfo;
import com.zzc.hpnote.domain.InfoModel;
import com.zzc.hpnote.domain.PriceInfo;
import com.zzc.hpnote.domain.PriceInfoExample;

/**
 * 消息队列消费者. <br>
 * 	由单独线程执行
 * 	
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 上午11:19:10 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class QueueConsumerTask extends Thread{
	private final static Logger log = Logger.getLogger(QueueConsumerTask.class);
	@Autowired
	private BaseInfoMapper baseInfoDao;
	@Autowired
	private PriceInfoMapper priceInfoDao;
	
	@Override
	public void run() {
		log.info("THREAD-QUEUE	: start to run task ...");
		long loopCnt = 0;
		while(true){
			log.info("THREAD-QUEUE	: start to deal the [" + loopCnt + "] time ...");
			doTask();
			log.info("THREAD-QUEUE	: finished deal the [" + loopCnt++ + "] time !");
		}
	}

	private void doTask() {
		// 1. 任务启动日志
		
		// 2. 启动队列监视
		InfoModel info = QueueManager.outQueue();
		if(null != info){
			log.info("THREAD-QUEUE	: ready to deal data ...");
			BaseInfo baseInfo = info.getBaseInfo();
			PriceInfo priceInfo = info.getPriceInfo();
			
			InfoModel.OperType operType = info.getType();
			switch(operType){
				case ADD:
					log.info("THREAD-QUEUE	: current busi type is [" + InfoModel.OperType.ADD.name() + "]");
					if(null != baseInfo){
						baseInfoDao.insert(baseInfo);
					}
					if(null != priceInfo){
						priceInfoDao.insert(priceInfo);
					}
					break;
				case MOD:
					log.info("THREAD-QUEUE	: current busi type is [" + InfoModel.OperType.MOD.name() + "]");
					if(null != priceInfo){
						PriceInfoExample example = new PriceInfoExample();
						PriceInfoExample.Criteria criteria = example.createCriteria();
						criteria.andHIdEqualTo(priceInfo.gethId());
						priceInfoDao.updateByExampleSelective(priceInfo, example);
					}
			}
		} else {
			log.info("THREAD-QUEUE	: ready to sleep 5SEC ...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
