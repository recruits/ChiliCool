package com.zzc.hpnote.busi;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.zzc.hpnote.domain.InfoModel;

/**
 * 消息队列管理. <br>
 * 	提供一个队列，用来保存待入库、待更新的数据.
 *  提供两个队列操作方法，入队、出队。
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 上午11:14:02 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class QueueManager {
	private static Queue<InfoModel> queue = new ConcurrentLinkedQueue<InfoModel>();
	/**
	 * 数据对象入队
	 * @param infoModel
	 * @return 
	 * @author zhangzechen
	 * @date 2014-5-17 上午11:18:35
	 */
	public static boolean inQueue(InfoModel infoModel){
		// 队列只存放20000条数据
		if(queue.size() > 20000){
			return false;
		}
		queue.offer(infoModel);
		return true;
	}
	/**
	 * 数据对象出队
	 * @return 
	 * @author zhangzechen
	 * @date 2014-5-17 上午11:18:47
	 */
	public static InfoModel outQueue(){
		if(queue.isEmpty()){
			return null;
		}
		return queue.poll();
	}
}
