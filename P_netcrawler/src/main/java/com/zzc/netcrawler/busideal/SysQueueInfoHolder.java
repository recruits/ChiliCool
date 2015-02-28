package com.zzc.netcrawler.busideal;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.zzc.netcrawler.domain.NetInfo;

/**
 * 数据保存队列<br>
 * 	解析完的数据，需要将内容保存到数据表中.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午2:22:05 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class SysQueueInfoHolder {
	private static Queue<NetInfo> queue = new ConcurrentLinkedQueue<NetInfo>();
	// 业务辅助记录
	private static int TOTAL_TASK_NUM = 0;	// 加入任务队列的总任务数
	private static int TOTAL_ADD_TIME = 0; 	// 数据队列消费队列的次数
	
	/**
	 * 数据入队
	 * @param netIndex
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午2:21:04
	 */
	public static boolean inQueue(NetInfo netInfo){
		if(queue.size() > QueueIdxConst.QUE_LEN){
			return false;
		}
		queue.offer(netInfo);
		TOTAL_TASK_NUM++;
		return true;
	}
	
	/**
	 * 数据出队
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午2:21:18
	 */
	public static NetInfo outQueue(){
		if(queue.isEmpty()){
			return null;
		}
		return queue.poll();
	}
	
	/**
	 * 队列长度
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午3:19:38
	 */
	public static synchronized int getQueueSize(){
		return queue.size();
	}
	
	public static void operQueAddTime(){
		TOTAL_ADD_TIME++;
	}
	public static int getOperQueAddTime(){
		return TOTAL_ADD_TIME;
	}
	public static int getOperQueTotNum(){
		return TOTAL_TASK_NUM;
	}
	
	public interface QueueIdxConst{
		int QUE_LEN = 5000;
	}
}
