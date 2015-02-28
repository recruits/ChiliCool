package com.zzc.hpnote.busi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zzc.hpnote.dao.TaskConfMapper;
import com.zzc.hpnote.dao.TaskFailDbMapper;
import com.zzc.hpnote.dao.TaskMgrMapper;
import com.zzc.hpnote.domain.BaseInfo;
import com.zzc.hpnote.domain.InfoModel;
import com.zzc.hpnote.domain.PriceInfo;
import com.zzc.hpnote.domain.TaskConf;
import com.zzc.hpnote.domain.TaskFailDb;
import com.zzc.hpnote.domain.TaskFailDbExample;
import com.zzc.hpnote.domain.TaskMgr;
import com.zzc.hpnote.domain.TaskMgrExample;

/**
 * 流程控制任务. <br>
 * 	顺序执行一个完整的流程.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 下午2:56:51 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class ProcessControlTask implements Runnable{
	private final static Logger log = Logger.getLogger(ProcessControlTask.class);
	// 未获取到任务退出的阀值
	private int MAX_NULL_CONF = 10;
	private TaskMgr currThreadInfo;
	private TaskMgrExample currThreadExample;
	
	@Resource
	private TaskMgrMapper taskMgrDao;
	@Resource
	private TaskConfMapper taskConfDao;
	@Resource
	private TaskFailDbMapper taskFailDbDao;
	
	public void doTask(){
		log.info("THREAD-TASK	: ready to run ...");
		// 1. 注册线程信息
		taskMgrDao.insert(createThreadInfo());
		log.info("THREAD-TASK	: 1. reg task-thread info[" + currThreadInfo.toString() + "]");
		
		// 2. 获取任务信息
		List<Integer> taskIdList = createTaskInfo();
		log.info("THREAD-TASK	: 2. get task info list, task number[" + taskIdList.size() + "]");
		if(MAX_NULL_CONF == 0){
			Thread.yield();
		}
		if(taskIdList.size() == 0){
			MAX_NULL_CONF--;
		}
		
		// 3. 执行准备工作
		updateThreadInfo(ENUM_TASK_STAE.EXE.name());
		log.info("THREAD-TASK	: 3. update task-thread info[" + currThreadInfo.toString() + "]");
		
		// 4. 创建任务数据[根据任务集，循环创建]
		List<String> urlList = buildUrlListByTaskId(taskIdList);
		log.info("THREAD-TASK	: 4. get task info list, task number[" + urlList.size() + "]");
		
		// 5. 执行业务流程
		/**
		 	5.1  获取房源编号、价格信息[从url中获取]
		 	5.2  获取房源编号[从cache中获取]。
				如果存在，获取价格信息[从cache中获取]
					如果存在，与url数据比较是否相等。若不相等，则发送价格信息消息到队列中[变更业务]；若相等，则跳转第4步。
					如果不存在，则发送价格信息到队列中[增加业务]。
				如果不存在，获取基本信息[从url中获取]；然后发送基本信息、价格信息消息到队列中[增加业务]。然后跳转第4步。
		**/
		Integer begTime = (int) System.currentTimeMillis();
		log.info("THREAD-TASK	: 5.1 start to deal task on[" + begTime + "]");
		startDealTask(urlList);
		Integer endTime = (int) System.currentTimeMillis();
		log.info("THREAD-TASK	: 5.2 finished deal task on[" + endTime + "]");
		log.info("THREAD-TASK	: 5.3 finished deal task, used total time[" + (endTime - begTime) + "]");
		
		// 6. 任务集执行完成，更新线程状态，完成本次线程任务；然后重新执行第1步。
		currThreadInfo.setExecMil(endTime - begTime);
		updateThreadInfo(ENUM_TASK_STAE.END.name());
		log.info("THREAD-TASK	: 6. reg task-thread info[" + currThreadInfo.toString() + "]");
	}
	
	public TaskMgr createThreadInfo(){
		Date currTime = new Date();
		String userName = System.getProperty("user.name");
		Random rand = new Random(47 + System.currentTimeMillis());
		
		TaskMgr taskInfo = new TaskMgr();
		taskInfo.settId(Thread.currentThread().getId() + "_" + currTime.getTime() + "_" + rand.nextInt(1000)); 
		taskInfo.settState(ENUM_TASK_STAE.REG.name());
		taskInfo.settStateTime(currTime);
		taskInfo.setUser(userName);
		taskInfo.setRegTime(currTime);
		
		currThreadInfo = taskInfo;
		currThreadExample = new TaskMgrExample();
		TaskMgrExample.Criteria criteria = currThreadExample.createCriteria();
		criteria.andTIdEqualTo(currThreadInfo.gettId());
		
		return taskInfo;
	}
	public void updateThreadInfo(String tState){
		Date currTime = new Date();
		currThreadInfo.settState(tState);
		currThreadInfo.settStateTime(currTime);
		taskMgrDao.updateByExample(currThreadInfo, currThreadExample);
	}
	private enum ENUM_TASK_STAE{
		REG,EXE,END,FAL;
	}
	
	public List<Integer> createTaskInfo(){
		List<Integer> taskIdList = new ArrayList<Integer>();
		// 1. 先从失败任务列表取出失败任务
		List<TaskFailDb> taskFailDbs = taskFailDbDao.selectByExample(null);
		if(!CollectionUtils.isEmpty(taskFailDbs)){
			int taskFailDbSize = taskFailDbs.size();
			int loop = 0;
			while(loop < taskFailDbSize){
				TaskFailDb taskDb = taskFailDbs.get(loop++);
				taskIdList.addAll(buildTaskIdListFromFailDb(taskDb));
				if(taskIdList.size() > 0){
					TaskFailDbExample example = new TaskFailDbExample();
					TaskFailDbExample.Criteria criteria = example.createCriteria();
					criteria.andBegTaskNumEqualTo(taskDb.getBegTaskNum());
					criteria.andEndTaskNumEqualTo(taskDb.getEndTaskNum());
					criteria.andCreateTimeEqualTo(taskDb.getCreateTime());
					taskFailDbDao.deleteByExample(example);
					 
					currThreadInfo.setBegTaskId(taskDb.getBegTaskNum().toString());
					currThreadInfo.setEndTaskId(taskDb.getEndTaskNum().toString());
					currThreadInfo.setTaskNum((taskDb.getEndTaskNum() - taskDb.getBegTaskNum()));
					return taskIdList;
				}
			}
		}
		// 2. 再从任务配置表中取出任务
		List<TaskConf> taskConfs = taskConfDao.selectByExample(null);
		if(!CollectionUtils.isEmpty(taskConfs)){
			TaskConf taskConf = taskConfs.get(0);
			taskIdList.addAll(buildTaskIdListFromConf(taskConf));
			if(taskIdList.size() > 0){
				taskConf.setTaskBegNum(taskConf.getTaskSegNum() + taskConf.getTaskBegNum());
				taskConf.setTaskSegNum(taskConf.getTaskSegNum());
				taskConf.setVersion(new Date());
				taskConfDao.updateByPrimaryKey(taskConf);
				
				currThreadInfo.setBegTaskId(taskConf.getTaskBegNum().toString());
				currThreadInfo.setEndTaskId(String.valueOf((taskConf.getTaskSegNum() + taskConf.getTaskBegNum())));
				currThreadInfo.setTaskNum((taskConf.getTaskSegNum()));
				return taskIdList;
			}
		}
		
		return taskIdList;
	}
	public List<Integer> buildTaskIdListFromFailDb(TaskFailDb taskDb){
		Integer begId = taskDb.getBegTaskNum();
		Integer endId = taskDb.getEndTaskNum();
		
		List<Integer> taskIdList = new ArrayList<Integer>();
		for(;begId<endId; begId ++){
			taskIdList.add(begId);
		}
		
		return taskIdList;
	}
	public List<Integer> buildTaskIdListFromConf(TaskConf taskConf){
		Integer begId = taskConf.getTaskBegNum();
		Integer segNum = taskConf.getTaskSegNum();
		
		List<Integer> taskIdList = new ArrayList<Integer>();
		for(int loop=0;loop<segNum; loop ++){
			taskIdList.add(begId++);
		}
		
		return taskIdList;
	}
	
	public List<String> buildUrlListByTaskId(List<Integer> taskIdList){
		List<String> urlList = new ArrayList<String>();
		String urlTemplate = "http://esf.soufun.com/chushou/3_{0}.htm";
		for(Integer taskId : taskIdList){
			urlList.add(MessageFormat.format(urlTemplate, taskId.toString()));
		}
		return urlList;
	}

	public void startDealTask(List<String> urlList){
		int loopCnt = 0;
		for(String url : urlList){
			log.info("THREAD-TASK	: 5.1-" + loopCnt + " start to deal the [" + loopCnt + "] url,url is-" + url + "");
			InfoModel infoModel = new InfoModel();
			try {
				PageHolderForHPNote holder = new PageHolderForHPNote(url);
				String urlHpId = holder.getHpId();
				if(StringUtils.isEmpty(urlHpId)){
					log.info("THREAD-TASK	: 5.1-" + loopCnt + " parse url failed, hpId not found !");
					continue;
				}
				
				BaseInfo urlBaseInfo = holder.getBaseInfo();
				if(null == urlBaseInfo){
					log.info("THREAD-TASK	: 5.1-" + loopCnt + " parse url failed, current url is not real hp-info !");
					continue;
				}
				
				PriceInfo urlPriceInfo = holder.getPriceInfo();
				if(null == urlPriceInfo || StringUtils.isEmpty(urlPriceInfo.gethId())){
					log.info("THREAD-TASK	: 5.1-" + loopCnt + " parse url failed, didn't get price info !");
					continue;
				}
				log.info("THREAD-TASK	: 5.1-" + loopCnt + " parse url successful ...");
				infoModel.sethId(urlHpId);
				
				if(SystemCache.existHPIdInCache(urlHpId)){
					log.info("THREAD-TASK	: 5.1-" + loopCnt + " urlHpId-" + urlHpId + " was in cache ...");
					PriceInfo cachePriceInfo = SystemCache.existPriceInfoInCache(urlHpId);
					if(null != cachePriceInfo){
						log.info("THREAD-TASK	: 5.1-" + loopCnt + " price info was in cache ...");
						if(!cachePriceInfo.equals(urlPriceInfo)){
							log.info("THREAD-TASK	: 5.1-" + loopCnt + " price info wasn't existed !");
							infoModel.setType(InfoModel.OperType.ADD);
							infoModel.setPriceInfo(urlPriceInfo);
						} 
					} else {
						log.info("THREAD-TASK	: 5.1-" + loopCnt + " price info wasn't in cache ...");
						infoModel.setType(InfoModel.OperType.ADD);
						infoModel.setPriceInfo(urlPriceInfo);
					}
				} else {
					log.info("THREAD-TASK	: 5.1-" + loopCnt + " urlHpId-" + urlHpId + " wasn't in cache, start to insert data ...");
					infoModel.setType(InfoModel.OperType.ADD);
					infoModel.setBaseInfo(urlBaseInfo);
					infoModel.setPriceInfo(urlPriceInfo);
				}
				
				log.info("THREAD-TASK	: 5.1-" + loopCnt++ + " finished deal the [" + loopCnt + "] url !");
				QueueManager.inQueue(infoModel);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @author zhangzechen
	 * @date 2014-5-17 下午5:21:31
	 */
	@Override
	public void run() {
		log.info("THREAD-TASK	: start to run task ...");
		int loopCnt = 0;
		while(true){
			log.info("THREAD-TASK	: start to deal the [" + loopCnt + "] time ...");
			doTask();
			log.info("THREAD-TASK	: finished deal the [" + loopCnt++ + "] time !");
		}
	}
}
