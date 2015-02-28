package com.zzc.netcrawler.busideal;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午2:51:31 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class ConstBusiCode {
	public interface NetSts{
		int STS_INIT = 10;
		int STS_ADD = 11;
		int STS_DEAL = 12;
		int STS_DONE = 13;
		int STS_EXEC = 21;
	}
	
	public interface QueLogType{
		int NET_TASK = 1;
		int NET_IDX = 2;
		int NET_IDX_NEW = 3;
		int NET_INFO = 4;
	}
	
	public interface QueHelperUtil{
		int T_SLEEP_TIME = 2000;
		
		int T_SLEEP_TIME_MIN = 2;
	}
	
	public interface TimeUnit{
		int TIME_SEC = 1;
		int TIME_MIN = 2;
		int TIME_HOR = 3;
		int TIME_DAY = 4;
		int TIME_MON = 5;
		int TIME_YEA = 6;
	}
}
