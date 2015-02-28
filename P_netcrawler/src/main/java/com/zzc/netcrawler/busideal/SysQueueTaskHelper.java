package com.zzc.netcrawler.busideal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zzc.netcrawler.dao.NetIndexMapper;
import com.zzc.netcrawler.domain.NetIndex;
import com.zzc.netcrawler.service.NetIndexService;

/**
 * 任务队列辅助处理类. <br>
 * 	重置索引数据状态[DEAL->ADD].
 *  获取任务数据，入队
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午2:33:06 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SysQueueTaskHelper {
	private final Logger log = Logger.getLogger(SysQueueTaskHelper.class);
	@Resource
	private NetIndexMapper netIdxDao;
	@Resource
	private NetIndexService netIdxService;
	
	public void init(){
		resetIdxSts();
	}
	/**
	 * 检查索引数据状态，修正处理中数据
	 * @author zhangzechen
	 * @date 2014-6-10 下午3:06:21
	 */
	private void resetIdxSts(){
		log.info("TASK INFO	: start to reset task-status ...");
		long begTime = System.currentTimeMillis();
		List<Integer> stsIds = new ArrayList<Integer>();
		stsIds.add(ConstBusiCode.NetSts.STS_DEAL);
		int operCnt = batchModNetIdx(netIdxService.getNetIdxList(stsIds, null));
		long endTime = System.currentTimeMillis();
		log.info("TASK INFO	: finished reset task-status, total records[" + operCnt + "], total times[" + (endTime - begTime) + "]");
	}
	
	/**
	 * 批量更新索引数据
	 * @param netIdxList
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午3:15:43
	 */
	private int batchModNetIdx(List<NetIndex> netIdxList){
		int modCnt = 0;
		// 检查索引数据，对状态为ADD，但是已存在INFO表中的数据，修正其数据状态为DONE
		
		
		// 初始化索引数据状态
		for(NetIndex netIndex : netIdxList){
			netIndex.setStsId(ConstBusiCode.NetSts.STS_ADD);
			netIndex.setUpdateTime(new Date());
			modCnt += netIdxDao.updateByPrimaryKeySelective(netIndex);
		}
		return modCnt;
	}
	
	/**
	 * 启动任务管理
	 * 	判断当前任务队列长度，>100，不做处理；<100，新增一批任务
	 *  新增任务入队
	 * @author zhangzechen
	 * @date 2014-6-10 下午3:32:19
	 */
	public void startConsume(){
		dealTask();
		
		final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		final int fixMin = 1;
		Calendar cTime = buildSchedul(fixMin);
        log.info("TASK INFO	: task-mgr timmer will be run on[" + sdf1.format(cTime.getTime()) + "]");
        
        // 启动定时器  
        Timer logTimer = new Timer();  
        TimerTask logTask = new TimerTask() {  
            @Override
			public void run() { 
            	dealTask();
            }  
        }; 
        // 指定任务在整点、半点执行,且在当前时间后的第一个整点或者半点执行。
        logTimer.schedule(logTask, cTime.getTime(), fixMin * 60 * 1000); 
	}
	private Calendar buildSchedul(int fixMin){
        Calendar c = Calendar.getInstance();  
        // 整分钟已过秒  
        int tmp1 = c.get(Calendar.SECOND);  
        // 过5分钟的分钟  
        int tmp2 = c.get(Calendar.MINUTE) % fixMin;  
        // 存放到达5分钟整点秒  
        int seconds = (fixMin - tmp2) * 60 - tmp1;  
        // 调整启动时间  
        c.add(Calendar.SECOND, seconds);  
        return c;
	}
	/**
	 * 任务执行方法
	 * @author zhangzechen
	 * @date 2014-6-11 下午1:14:54
	 */
	private void dealTask(){
		int newAddSize = 0;
    	int queueSize = SysQueueTaskHolder.getQueueSize();
    	
    	log.info("TASK INFO	: task queue size is[" + queueSize + "]");
    	if(queueSize < SysQueueTaskHolder.QueueIdxConst.QUE_LIMIT){
    		List<Integer> stsIds = new ArrayList<Integer>();
    		stsIds.add(ConstBusiCode.NetSts.STS_ADD);
    		
    		// 获取任务列表
    		List<NetIndex> netIdxs = netIdxService.getNetIdxList(stsIds, SysQueueTaskHolder.QueueIdxConst.QUE_LEN);
    		newAddSize = netIdxs.size();
    		for(NetIndex netIdx : netIdxs){
    			// 新任务入队
    			SysQueueTaskHolder.inQueue(netIdx);
    			
    			// 任务状态回写
    			netIdx.setStsId(ConstBusiCode.NetSts.STS_DEAL);
    			netIdx.setUpdateTime(new Date());
    			netIdxDao.updateByPrimaryKeySelective(netIdx);
    		}
    		if(newAddSize > 0){
    			SysQueueTaskHolder.operQueAddTime();
    		}
    	}
    	log.info("TASK INFO	: task queue new-add [" + newAddSize + "] record!");
	}
}
