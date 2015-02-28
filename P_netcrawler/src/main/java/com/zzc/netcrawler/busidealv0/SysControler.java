package com.zzc.netcrawler.busidealv0;

import org.apache.log4j.Logger;

public class SysControler {
	private static Logger log = Logger.getLogger(SysControler.class);
	
	private boolean init(){
		DataHolderProxy.startLogger();
		
		return DataHolderProxy.initDataHolder();
	}
	
	public void start(){
		log.info(ConstHolder.StrTool.LOG_PREFIX + "System is starting to run ...");
		log.info(ConstHolder.StrTool.LOG_PREFIX + "start to init sys-params ...");
		if(init()){
			log.info(ConstHolder.StrTool.LOG_PREFIX + "sys-params initialize successful!");
			new SysRunner().start(ConstHolder.TNumber.T_LIMIT_NBR);
		} else {
			log.info(ConstHolder.StrTool.LOG_PREFIX + "sys-params initialize failed!");
			log.info(ConstHolder.StrTool.LOG_PREFIX + "System has stopped!");
		}
	}
	
	public static void main(String[] args) {
		new SysControler().start();
	}
}
