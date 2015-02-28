package com.zzc.hpnote.busi;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zzc.hpnote.dao.BaseInfoMapper;
import com.zzc.hpnote.dao.PriceInfoMapper;
import com.zzc.hpnote.domain.PriceInfo;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-28 上午9:38:34 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class SystemCacheHelper {
	private final static Logger log = Logger.getLogger(SystemCacheHelper.class);
	@Resource
	private BaseInfoMapper baseInfoDao;
	@Resource
	private PriceInfoMapper priceInfoDao;
	
	public void init(){
		log.info("CACHE INFO	: start to put data-hpid in cache ...");
		List<String> hpIdList = baseInfoDao.selectAllHid();
		for(String hpId : hpIdList){
			SystemCache.putHPIdToCache(hpId);
		}
		log.info("CACHE INFO	: finished put data-hpid in cache, total data [" + hpIdList.size() + "]");
		log.info("CACHE INFO	: start to put data-priceinfo in cache ...");
		List<PriceInfo> priceInfoList = priceInfoDao.selectByExample(null);
		for(PriceInfo priceInfo : priceInfoList){
			SystemCache.putPriceInfoToCache(priceInfo);
		}
		log.info("CACHE INFO	: finished put data-priceinfo in cache, total data [" + priceInfoList.size() + "]");
	}
}
