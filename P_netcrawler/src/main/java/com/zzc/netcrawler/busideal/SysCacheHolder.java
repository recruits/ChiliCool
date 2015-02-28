package com.zzc.netcrawler.busideal;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 系统缓存数据管理. <br>
 * 	主要缓存net_url数据集.
 * 	全量缓存
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午1:59:28 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class SysCacheHolder {
	private final static Logger log = Logger.getLogger(SysCacheHolder.class);
	private static CacheManager cacheManager;
	
	
	/**
	 * 初始化缓存管理
	 * @author zhangzechen
	 * @date 2014-6-10 下午1:59:17
	 */
	public static void init(){
		cacheManager = CacheManager.create();
		
		log.info("CACHE INFO	: start to create net-url cache ...");
		cacheManager.addCache(CacheConst.CACHE_NET_URL);
		log.info("CACHE INFO	: finished create cache !");
	}
	
	/**
	 * 从缓存中查找指定的内容[netUrl]是否存在
	 * @param netUrl
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午1:57:45
	 */
	public static boolean existNetUrlInCache(String netUrl){
		if(null == cacheManager){
			init();
		}
		Cache cache = cacheManager.getCache(CacheConst.CACHE_NET_URL);
		Element element = cache.get(netUrl);
		if(null != element){
			String value = (String) element.getObjectValue();
			if(StringUtils.isNotEmpty(value) && value.equals(CacheConst.CACHE_NET_URL_VALUE)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 向缓存中写入指定的内容[netUrl]
	 * @param netUrl
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午1:58:09
	 */
	public static boolean putNetUrlToCache(String netUrl){
		if(null == cacheManager){
			init();
		}
		Cache cache = cacheManager.getCache(CacheConst.CACHE_NET_URL);
		cache.put(new Element(netUrl, CacheConst.CACHE_NET_URL_VALUE));
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
	
	public interface CacheConst{
		String CACHE_NET_URL = "net_url";
		
		String CACHE_NET_URL_VALUE = "1";
		
		int CACHE_SIZE = 20000; 
	}
}
