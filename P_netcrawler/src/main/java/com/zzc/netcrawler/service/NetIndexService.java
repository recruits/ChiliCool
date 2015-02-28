package com.zzc.netcrawler.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzc.netcrawler.dao.NetIndexMapper;
import com.zzc.netcrawler.domain.NetIndex;
import com.zzc.netcrawler.domain.NetIndexExample;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-6-10 下午3:49:39 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class NetIndexService {
	@Resource
	private NetIndexMapper netIdxDao;
	/**
	 * 获取指定状态的索引数据
	 * @param stsIds
	 * @return 
	 * @author zhangzechen
	 * @date 2014-6-10 下午3:08:18
	 */
	public List<NetIndex> getNetIdxList(List<Integer> stsIds, Integer limitNum){
		NetIndexExample example = new NetIndexExample();
		NetIndexExample.Criteria criteria = example.createCriteria();
		criteria.andStsIdIn(stsIds);
		if(null != limitNum && limitNum > 0){
			example.setLimitClause(limitNum);
		}
		return netIdxDao.selectByExample(example);
	}
}
