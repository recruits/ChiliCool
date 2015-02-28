package com.zzc.netcrawler.busideal;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.zzc.netcrawler.domain.NetIndex;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午2:28:25 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class SysQueueTaskHolder {
	private static Queue<NetIndex> queue = new ConcurrentLinkedQueue<NetIndex>();
	// 业务辅助记录
	private static int TOTAL_TASK_NUM = 0;	// 加入任务队列的总任务数
	private static int TOTAL_ADD_TIME = 0; 	// 任务队列添加任务的次数
	
	/**
	 * 数据入队
	 * @param netIndex
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午2:21:04
	 */
	public static boolean inQueue(NetIndex netIndex){
		if(queue.size() > QueueIdxConst.QUE_LEN){
			return false;
		}
		queue.offer(netIndex);
		TOTAL_TASK_NUM++;
		return true;
	}
	
	/**
	 * 数据出队
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午2:21:18
	 */
	public static NetIndex outQueue(){
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
	
	/**
	 * 记录往任务队列中增加任务的次数
	 * @author zhangzechen
	 * @date 2014-6-11 下午12:01:55
	 */
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
		int QUE_LIMIT = 100;
	}
}
