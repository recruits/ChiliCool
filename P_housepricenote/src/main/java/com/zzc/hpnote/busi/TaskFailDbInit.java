package com.zzc.hpnote.busi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzc.hpnote.dao.TaskFailDbMapper;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-26 下午7:20:43 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@Service
public class TaskFailDbInit {
	@Autowired
	private TaskFailDbMapper taskFailDbDao;
}
