package com.chilicool.fang_data;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * 
 * @author zhangzechen@cttic.cn
 * @date 2014-10-7 上午11:01:07 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class Tester {
	public static void main(String[] args) {
		PageController controller = new PageController();
		try {
			controller.getAllDataFromWebPage();
			controller.parseAllDataFromFile();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------> every_day data :");
		List<PageData> showDayDatas = controller.getAllFormatData_day();
		for(PageData currData : showDayDatas){
			System.out.println("[" + currData.getDate() + ",网签 " + currData.getCont() + " 套]");
		}
		
		System.out.println("--------------------> every_month data :");
		List<PageData> showMonthDatas = controller.getAllFormatData_month(showDayDatas);
		for(PageData currData : showMonthDatas){
			System.out.println("[" + currData.getDate() + ",网签 " + currData.getCont() + " 套]");
		}
		
		System.out.println("--------------------> every_season data :");
		List<PageData> showSeasonDatas = controller.getAllFormatData_season(showMonthDatas);
		for(PageData currData : showSeasonDatas){
			System.out.println("[" + currData.getDate() + ",网签 " + currData.getCont() + " 套]");
		}
		
		System.out.println("--------------------> every_year data :");
		List<PageData> showYearDatas = controller.getAllFormatData_year(showSeasonDatas);
		for(PageData currData : showYearDatas){
			System.out.println("[" + currData.getDate() + ",网签 " + currData.getCont() + " 套]");
		}
	}
}
