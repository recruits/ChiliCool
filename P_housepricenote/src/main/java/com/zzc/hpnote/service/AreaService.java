package com.zzc.hpnote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzc.hpnote.dao.AreaMapper;
import com.zzc.hpnote.domain.Area;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 下午3:52:22 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class AreaService implements IAreaService {
	@Autowired
	private AreaMapper areaDao;
	
	/**
	 *
	 * @param record
	 * @return 
	 * @author zhangzechen
	 * @date 2014-5-17 下午3:52:22
	 */
	@Override
	public int addArea(Area record) {
		return areaDao.insert(record);
	}
}
