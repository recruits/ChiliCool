package com.zzc.hpnote.busi;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.zzc.hpnote.domain.PriceInfo;

/**
 * 系统缓存数据管理. <br>
 * 	主要缓存hpid、priceinfo两个数据集.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 上午11:49:21 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class SystemCache {
	private final static Logger log = Logger.getLogger(SystemCache.class);
	private static CacheManager cacheManager;
	
	/**
	 * 初始化缓存管理
	 * @author zhangzechen
	 * @date 2014-5-17 下午2:03:40
	 */
	public static void init(){
		cacheManager = CacheManager.create();
		
		log.info("CACHE INFO	: start to create hp-id cache ...");
		cacheManager.addCache(CacheConstName.CACHE_HPID);
		log.info("CACHE INFO	: start to create price-info cache ...");
		cacheManager.addCache(CacheConstName.CACHE_PRICE_INFO);
		log.info("CACHE INFO	: finished create cache !");
	}
	
	/**
	 * 从缓存中查找指定的内容[hpid]是否存在
	 * @param hpId
	 * @return 
	 * @author zhangzechen
	 * @date 2014-5-17 下午2:03:52
	 */
	public static boolean existHPIdInCache(String hpId){
		if(null == cacheManager){
			init();
		}
		Cache cache = cacheManager.getCache(CacheConstName.CACHE_HPID);
		Element element = cache.get(hpId);
		if(null != element){
			String value = (String) element.getObjectValue();
			if(StringUtils.isNotEmpty(value) && value.equals(CacheConstName.CACHE_HPID_VALUE)){
				return false;
			}
		}
		return false;
	}
	/**
	 * 从缓存中查找指定的内容[priceinfo]是否存在
	 * @param hpId
	 * @return 
	 * @author zhangzechen
	 * @date 2014-5-17 下午2:08:12
	 */
	public static PriceInfo existPriceInfoInCache(String hpId){
		if(null == cacheManager){
			init();
		}
		Cache cache = cacheManager.getCache(CacheConstName.CACHE_PRICE_INFO);
		Element element = cache.get(hpId);
		if(null != element){
			PriceInfo value = (PriceInfo) element.getObjectValue();
			if(value != null){
				return value;
			}
		}
		return null;
	}
	
	/**
	 * 向缓存中写入指定的内容[hpid]
	 * @param hpId
	 * @return 
	 * @author zhangzechen
	 * @date 2014-5-17 下午2:12:29
	 */
	public static boolean putHPIdToCache(String hpId){
		if(null == cacheManager){
			init();
		}
		Cache cache = cacheManager.getCache(CacheConstName.CACHE_HPID);
		cache.put(new Element(hpId, CacheConstName.CACHE_HPID_VALUE));
		return true;
	}
	
	/**
	 * 向缓存中写入指定的内容[priceinfo]
	 * @param priceInfo
	 * @return 
	 * @author zhangzechen
	 * @date 2014-5-17 下午2:14:26
	 */
	public static boolean putPriceInfoToCache(PriceInfo priceInfo){
		if(null == cacheManager){
			init();
		}
		Cache cache = cacheManager.getCache(CacheConstName.CACHE_PRICE_INFO);
		cache.put(new Element(priceInfo.gethId(), priceInfo));
		return true;
	}
	
	/**
	 * 缓存关闭
	 * @author zhangzechen
	 * @date 2014-5-17 下午2:16:44
	 */
	public static void closeCache(){
		if(null != cacheManager){
			cacheManager.removalAll();
			
			CacheManager.getInstance().shutdown();
		}
	}
	
	public interface CacheConstName{
		String CACHE_HPID = "cache_id";
		String CACHE_PRICE_INFO = "cache_price_info";
		
		String CACHE_HPID_VALUE = "1";
	}
}
