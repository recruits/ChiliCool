package com.zzc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzc.hpnote.domain.Area;
import com.zzc.hpnote.service.AreaService;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 下午2:46:52 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:/spring-config.xml"}) 
public class JUnitTest {
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testAddAreaInfo(){
		Area area = new Area();
		area.setAreaCode("010");
		area.setAreaName("北京");
		area.setParentAreaCode("0");
		area.setRegionCode("");
		area.setRegionName("");
		area.setParentRegionCode("");
		
		areaService.addArea(area);
	}
}
