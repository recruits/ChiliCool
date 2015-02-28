package com.zzc.netcrawler.busideal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zzc.netcrawler.dao.NetIndexMapper;
import com.zzc.netcrawler.domain.NetIndex;
import com.zzc.netcrawler.service.NetIndexService;

/**
 * 系统缓存辅助处理类. <br>
 * 	加载数据放入缓存.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午3:35:59 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SysCacheHelper {
	private final Logger log = Logger.getLogger(SysCacheHelper.class);
	@Resource
	private NetIndexMapper netIdxDao;
	@Resource
	private NetIndexService netIdxService;
	/**
	 * 初始化缓存管理
	 * @author zhangzechen
	 * @date 2014-6-10 下午3:48:30
	 */
	public void init(){
		SysCacheHolder.init();
	}
	
	/**
	 * 初始化缓存数据
	 * @author zhangzechen
	 * @date 2014-6-10 下午3:55:38
	 */
	public void initCacheData(){
		log.info("CACHE INFO	: start to put net-url into cache ...");
		long begTime = System.currentTimeMillis();
		List<Integer> stsIds = new ArrayList<Integer>();
		stsIds.add(ConstBusiCode.NetSts.STS_ADD);
		List<NetIndex> netIdxs = netIdxService.getNetIdxList(stsIds, SysCacheHolder.CacheConst.CACHE_SIZE);
		for(NetIndex netIdx : netIdxs){
			SysCacheHolder.putNetUrlToCache(netIdx.getNetUrl());
		}
		long endTime = System.currentTimeMillis();
		log.info("CACHE INFO	: finished put net-url into cache, total records[" + netIdxs.size() + "], total time[" +(endTime - begTime)+ "]");
	}
}
