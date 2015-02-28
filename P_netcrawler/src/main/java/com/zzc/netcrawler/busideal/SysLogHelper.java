package com.zzc.netcrawler.busideal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzc.netcrawler.dao.NetIndexMapper;
import com.zzc.netcrawler.dao.NetLogMapper;
import com.zzc.netcrawler.dao.NetQueueLogMapper;
import com.zzc.netcrawler.domain.NetIndexModel;
import com.zzc.netcrawler.domain.NetLog;
import com.zzc.netcrawler.domain.NetLogExample;
import com.zzc.netcrawler.domain.NetQueueLog;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-11 下午12:10:02 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SysLogHelper {
	@Resource
	private NetQueueLogMapper netQueLogDao;
	@Resource
	private NetLogMapper netLogDao;
	@Resource
	private NetIndexMapper netIdxDao;
	
	public void startConsume(){
		final int fixMin = ConstBusiCode.QueHelperUtil.T_SLEEP_TIME_MIN;
		Calendar cTime = buildSchedul(fixMin);
        
        // 启动定时器  
        Timer logTimer = new Timer();  
        TimerTask logTask = new TimerTask() {  
            @Override
			public void run() { 
            	Date currTime = new Date();
            	// 记录队列日志
            	NetQueueLog netTaskLog = buildNetTaskLog(currTime);
            	netQueLogDao.insert(netTaskLog);
            	
            	NetQueueLog netIdxLog = buildNetIdxLog(currTime);
            	netQueLogDao.insert(netIdxLog);
            	
            	NetQueueLog netIdxNewLog = buildNetIdxNewLog(currTime);
            	netQueLogDao.insert(netIdxNewLog);
            	
            	NetQueueLog netInfoLog = buildNetInfoLog(currTime);
            	netQueLogDao.insert(netInfoLog);
            	
            	// 记录索引表数据状态统计日志
            	// 取出上一次保存的数据
            	NetLogExample example = new NetLogExample();
            	example.setOrderByClause("log_id desc");
            	example.setLimitClause(1);
            	List<NetLog> netLogs = netLogDao.selectByExample(example);
            	// 取出状态统计
            	List<NetIndexModel> netIdxs = netIdxDao.selectGroupBySts();
            	NetLog netLog = buildNetLog(currTime, netIdxs, netLogs);
            	netLogDao.insert(netLog);
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
	
	public NetQueueLog buildNetTaskLog(Date currTime){
		NetQueueLog netInfoLog = new NetQueueLog();
		netInfoLog.setCreateTime(currTime);
		netInfoLog.setConsNum(SysQueueTaskHolder.getOperQueAddTime());
		netInfoLog.setConsTime(0);
		netInfoLog.setQueLen(SysQueueTaskHolder.getOperQueTotNum());
		netInfoLog.setQueSize(SysQueueTaskHolder.QueueIdxConst.QUE_LEN);
		netInfoLog.setQueCurrLen(SysQueueTaskHolder.getQueueSize());
		netInfoLog.setQueType(ConstBusiCode.QueLogType.NET_TASK);
		return netInfoLog;
	}
	
	public NetQueueLog buildNetIdxLog(Date currTime){
		NetQueueLog netInfoLog = new NetQueueLog();
		netInfoLog.setCreateTime(currTime);
		netInfoLog.setConsNum(SysQueueIdxHolder.getOperQueAddTime());
		netInfoLog.setConsTime(0);
		netInfoLog.setQueLen(SysQueueIdxHolder.getOperQueTotNum());
		netInfoLog.setQueSize(SysQueueIdxHolder.QueueIdxConst.QUE_LEN);
		netInfoLog.setQueCurrLen(SysQueueIdxHolder.getQueueSize());
		netInfoLog.setQueType(ConstBusiCode.QueLogType.NET_IDX);
		return netInfoLog;
	}
	
	public NetQueueLog buildNetIdxNewLog(Date currTime){
		NetQueueLog netInfoLog = new NetQueueLog();
		netInfoLog.setCreateTime(currTime);
		netInfoLog.setConsNum(SysQueueIdxNewHolder.getOperQueAddTime());
		netInfoLog.setConsTime(0);
		netInfoLog.setQueLen(SysQueueIdxNewHolder.getOperQueTotNum());
		netInfoLog.setQueSize(SysQueueIdxNewHolder.QueueIdxConst.QUE_LEN);
		netInfoLog.setQueCurrLen(SysQueueIdxNewHolder.getQueueSize());
		netInfoLog.setQueType(ConstBusiCode.QueLogType.NET_IDX_NEW);
		return netInfoLog;
	}
	
	public NetQueueLog buildNetInfoLog(Date currTime){
		NetQueueLog netInfoLog = new NetQueueLog();
		netInfoLog.setCreateTime(currTime);
		netInfoLog.setConsNum(SysQueueInfoHolder.getOperQueAddTime());
		netInfoLog.setConsTime(0);
		netInfoLog.setQueLen(SysQueueInfoHolder.getOperQueTotNum());
		netInfoLog.setQueSize(SysQueueInfoHolder.QueueIdxConst.QUE_LEN);
		netInfoLog.setQueCurrLen(SysQueueInfoHolder.getQueueSize());
		netInfoLog.setQueType(ConstBusiCode.QueLogType.NET_INFO);
		return netInfoLog;
	}
	
	public NetLog buildNetLog(Date currTime, List<NetIndexModel> netIdxs, List<NetLog> netLogs){
		NetLog netLog = new NetLog();
		
		int totNum = 0;
		int totNumOld = 0;
		int sts10 = 0;
		int sts10Old = 0;
		int sts11 = 0;
		int sts11Old = 0;
		int sts12 = 0;
		int sts12Old = 0;
		int sts13 = 0;
		int sts13Old = 0;
		int sts21 = 0;
		int sts21Old = 0;
		if(null != netLogs && netLogs.size() > 0){
			NetLog netLogOld= netLogs.get(0);
			totNumOld = netLogOld.getTotalNum();
			sts10Old = netLogOld.getSts10();
			sts11Old = netLogOld.getSts11();
			sts12Old = netLogOld.getSts12();
			sts13Old = netLogOld.getSts13();
			sts21Old = netLogOld.getSts21();
		}
		
		if(null != netIdxs && netLogs.size() > 0){
			for(NetIndexModel netIdxModel : netIdxs){
				if(null != netIdxModel){
					int cnt = netIdxModel.getStsCnt();
					totNum += cnt;
					
					switch(netIdxModel.getStsId()){
						case ConstBusiCode.NetSts.STS_INIT :
							sts10 = cnt;
							break;
						case ConstBusiCode.NetSts.STS_ADD :
							sts11 = cnt;
							break;
						case ConstBusiCode.NetSts.STS_DEAL :
							sts12 = cnt;
							break;
						case ConstBusiCode.NetSts.STS_DONE :
							sts13 = cnt;
							break;
						case ConstBusiCode.NetSts.STS_EXEC :
							sts21 = cnt;
							break;
					}
				}
			}
		}
		
		netLog.setCreateTime(currTime);
		netLog.setTotalNum(totNum);
		int totNumAppd = totNum-totNumOld;
		netLog.setTotalNumAppd(totNumAppd>0?totNumAppd:0);
		netLog.setSts10(sts10);
		netLog.setSts11(sts11);
		netLog.setSts12(sts12);
		netLog.setSts13(sts13);
		netLog.setSts21(sts21);
		int sts10Appd = sts10-sts10Old;
		int sts11Appd = sts11-sts11Old;
		int sts12Appd = sts12-sts12Old;
		int sts13Appd = sts13-sts13Old;
		int sts21Appd = sts21-sts21Old;
		netLog.setSts10Appd(sts10Appd>0?sts10Appd:0);
		netLog.setSts11Appd(sts11Appd>0?sts11Appd:0);
		netLog.setSts12Appd(sts12Appd>0?sts12Appd:0);
		netLog.setSts13Appd(sts13Appd>0?sts13Appd:0);
		netLog.setSts21Appd(sts21Appd>0?sts21Appd:0);
		
		netLog.setTimeSeg(ConstBusiCode.QueHelperUtil.T_SLEEP_TIME_MIN);
		netLog.setTimeUnit(ConstBusiCode.TimeUnit.TIME_MIN);
		return netLog;
	}
}
