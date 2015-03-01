package com.chilicool.fang_data;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * 
 * @author zhangzechen@cttic.cn
 * @date 2014-10-7 下午12:25:23 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class PageController {
	private final PageHelper pageHelper = new PageHelper();
	private final String webPageDataFileName = "/pagedata/pagedata.dat";
	private final String parseDataFileName = "/pagedata/monthdata.dat";

	// 从网上获取所有数据
	public void getAllDataFromWebPage() throws MalformedURLException,
			IOException {
		int webPageIdx = 1;
		List<PageData> pageDatas = new ArrayList<PageData>();
		// 1. 读出所有页面的数据
		while (webPageIdx < 100) {
			String webUrl = MessageFormat.format(pageHelper.getWebUrl(),
					webPageIdx + "");
			System.out.println("-----> start to deal webUrl:" + webUrl);
			List<PageData> tempDatas = pageHelper.dealWebPage(webUrl);
			if (!CollectionUtils.isEmpty(tempDatas)) {
				pageDatas.addAll(tempDatas);
			}
			webPageIdx = webPageIdx + 1;
		}
		// 2. 检查文件是否存在，不存在创建；已存在，清空数据
		FileDealer.clearFileContent(pageHelper.getAbsoluteFilePath(webPageDataFileName));
		FileDealer.clearFileContent(pageHelper.getAbsoluteFilePath(parseDataFileName));
		
		// 3. 数据保存入文件
		FileDealer.appendObject(
				pageHelper.getAbsoluteFilePath(webPageDataFileName), pageDatas);
	}

	// 解析网上的所有数据，生成2014-09-08/555格式数据
	public void parseAllDataFromFile() {
		System.out.println("-----> start to parse allData...");
		// 1. 从文件中读出所有数据
		List<PageData> pageDatas = FileDealer.readObjects(pageHelper
				.getAbsoluteFilePath(webPageDataFileName));
		System.out.println("-----> got allData, size is: " + pageDatas.size());
		// 2. 解析所有数据
		List<PageData> dstPageDatas = new ArrayList<PageData>();
		for (PageData currPageData : pageDatas) {
			// 创建对象
			PageData destPageData = new PageData();

			// 取出数据
			String content = currPageData.getCont();
			String date = currPageData.getDate();

			// 取出日期
			String reYear = date.substring(0, 4);
			String reMonth = date.substring(5, 7);
			String reDay = date.substring(8, 10);

			// 网页关键字
			Pattern keyWordsReg = Pattern
					.compile("([0-9]{1,2})月([0-9]{1,2})日[网签约]{2}([0-9]{1,5})套\\s{0,5}([增加减少]{2}[0-9]{1,5}套)?");
			Matcher keyWords = keyWordsReg.matcher(content);
			if (keyWords.find()) {
				String keyMonth = keyWords.group(1);
				String keyDay = keyWords.group(2);
				String keyCnt = keyWords.group(3);

				if (!StringUtils.isEmpty(keyCnt)) {
					if (StringUtils.isEmpty(keyMonth)) {
						keyMonth = reMonth;
					}
					if (StringUtils.isEmpty(keyDay)) {
						keyDay = reDay;
					}

					keyMonth = Integer.valueOf(keyMonth) < 10
							? "0" + keyMonth
							: keyMonth;
					keyDay = Integer.valueOf(keyDay) < 10
							? "0" + keyDay
							: keyDay;

					destPageData
							.setDate(reYear + "-" + keyMonth + "-" + keyDay);
					destPageData.setCont(keyCnt);

					dstPageDatas.add(destPageData);
					continue;
				}
			}

			// 网页关键字
			Pattern keyWordsReg2 = Pattern
					.compile("([0-9]{1,2})[月\\.]([0-9]{1,2})\\D+([0-9]{1,5})套");
			Matcher keyWords2 = keyWordsReg2.matcher(content);
			if (keyWords2.find()) {
				String keyMonth = keyWords2.group(1);
				String keyDay = keyWords2.group(2);
				String keyCnt = keyWords2.group(3);

				if (!StringUtils.isEmpty(keyCnt)) {
					if (StringUtils.isEmpty(keyMonth)) {
						keyMonth = reMonth;
					}
					if (StringUtils.isEmpty(keyDay)) {
						keyDay = reDay;
					}

					keyMonth = Integer.valueOf(keyMonth) < 10
							? "0" + keyMonth
							: keyMonth;
					keyDay = Integer.valueOf(keyDay) < 10
							? "0" + keyDay
							: keyDay;

					destPageData
							.setDate(reYear + "-" + keyMonth + "-" + keyDay);
					destPageData.setCont(keyCnt);

					dstPageDatas.add(destPageData);
					continue;
				}
			}

			// 网页关键字
			Pattern keyWordsReg3 = Pattern
					.compile("([0-9]{1,2})日\\D+([0-9]{1,5})套");
			Matcher keyWords3 = keyWordsReg3.matcher(content);
			if (keyWords3.find()) {
				String keyDay = keyWords3.group(1);
				String keyCnt = keyWords3.group(2);

				if (!StringUtils.isEmpty(keyCnt)) {
					if (StringUtils.isEmpty(keyDay)) {
						keyDay = reDay;
					}

					keyDay = Integer.valueOf(keyDay) < 10
							? "0" + keyDay
							: keyDay;

					destPageData.setDate(reYear + "-" + reMonth + "-" + keyDay);
					destPageData.setCont(keyCnt);

					dstPageDatas.add(destPageData);
					continue;
				}
			}

			Pattern keyWordsReg4 = Pattern.compile("昨日网签([0-9]{1,5})套");
			Matcher keyWords4 = keyWordsReg4.matcher(content);
			if (keyWords4.find()) {
				String keyCnt = keyWords4.group(1);

				if (!StringUtils.isEmpty(keyCnt)) {
					int currMonth = Integer.valueOf(reMonth) - 1;
					destPageData.setDate(reYear + "-"
							+ (currMonth < 10 ? "0" + currMonth : currMonth)
							+ "-" + reDay);
					destPageData.setCont(keyCnt);

					dstPageDatas.add(destPageData);
				}
			}
		}
		// 3.数据保存入文件
		FileDealer
				.appendObject(
						pageHelper.getAbsoluteFilePath(parseDataFileName),
						dstPageDatas);
		System.out.println("-----> save data successful, size is : "
				+ dstPageDatas.size());
	}

	// 读出所有格式化数据
	public List<PageData> getAllFormatData_day() {
		return FileDealer.readObjects(pageHelper
				.getAbsoluteFilePath(parseDataFileName));
	}

	// 生成月报表数据
	public List<PageData> getAllFormatData_month(List<PageData> inData) {
		List<PageData> rstPageData = new ArrayList<PageData>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (PageData currData : inData) {
			String date = currData.getDate();
			String cnt = currData.getCont();
			Integer cntInt = Integer.valueOf(cnt);

			// 取出日期
			String currMonth = date.substring(0, 7);
			Integer currCnt = map.get(currMonth);
			if (null == currCnt) {
				map.put(currMonth, cntInt);
			} else {
				map.put(currMonth, (currCnt + cntInt));
			}
		}
		Set<String> keySet = map.keySet();
		List<String> keyList = new ArrayList<String>(keySet);
		Collections.sort(keyList);
		for (String currKey : keyList) {
			if (null != currKey) {
				PageData currPageData = new PageData(map.get(currKey)
						.toString(), currKey);
				rstPageData.add(currPageData);
			}
		}
		return rstPageData;
	}

	// 生成季报表数据
	public List<PageData> getAllFormatData_season(List<PageData> inData) {
		List<PageData> rstPageData = new ArrayList<PageData>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (PageData currData : inData) {
			String date = currData.getDate();
			String cnt = currData.getCont();
			Integer cntInt = Integer.valueOf(cnt);

			// 取出日期
			String currYear = date.substring(0, 4);
			String currMonth = date.substring(5, 7);
			Integer currSeason = 1;
			switch (Integer.valueOf(currMonth)) {
				case 1 :
				case 2 :
				case 3 :
					String currSeasonStr1 = currYear + "-0" + currSeason;
					Integer currCnt1 = map.get(currSeasonStr1);
					if (null == currCnt1) {
						map.put(currSeasonStr1, cntInt);
					} else {
						map.put(currSeasonStr1, (currCnt1 + cntInt));
					}
					break;
				case 4 :
				case 5 :
				case 6 :
					currSeason = 2;
					String currSeasonStr2 = currYear + "-0" + currSeason;
					Integer currCnt2 = map.get(currSeasonStr2);
					if (null == currCnt2) {
						map.put(currSeasonStr2, cntInt);
					} else {
						map.put(currSeasonStr2, (currCnt2 + cntInt));
					}
					break;
				case 7 :
				case 8 :
				case 9 :
					currSeason = 3;
					String currSeasonStr3 = currYear + "-0" + currSeason;
					Integer currCnt3 = map.get(currSeasonStr3);
					if (null == currCnt3) {
						map.put(currSeasonStr3, cntInt);
					} else {
						map.put(currSeasonStr3, (currCnt3 + cntInt));
					}
					break;
				case 10 :
				case 11 :
				case 12 :
					currSeason = 4;
					String currSeasonStr4 = currYear + "-0" + currSeason;
					Integer currCnt4 = map.get(currSeasonStr4);
					if (null == currCnt4) {
						map.put(currSeasonStr4, cntInt);
					} else {
						map.put(currSeasonStr4, (currCnt4 + cntInt));
					}
					break;
			}
		}
		Set<String> keySet = map.keySet();
		List<String> keyList = new ArrayList<String>(keySet);
		Collections.sort(keyList);
		for (String currKey : keyList) {
			if (null != currKey) {
				PageData currPageData = new PageData(map.get(currKey).toString(), currKey);
				rstPageData.add(currPageData);
			}
		}
		return rstPageData;
	}

	// 生成年报表数据
	public List<PageData> getAllFormatData_year(List<PageData> inData) {
		List<PageData> rstPageData = new ArrayList<PageData>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (PageData currData : inData) {
			String date = currData.getDate();
			String cnt = currData.getCont();
			Integer cntInt = Integer.valueOf(cnt);

			// 取出日期
			String currYear = date.substring(0, 4);
			Integer currCnt = map.get(currYear);
			if (null == currCnt) {
				map.put(currYear, cntInt);
			} else {
				map.put(currYear, (currCnt + cntInt));
			}
		}
		Set<String> keySet = map.keySet();
		List<String> keyList = new ArrayList<String>(keySet);
		Collections.sort(keyList);
		for (String currKey : keyList) {
			if (null != currKey) {
				PageData currPageData = new PageData(map.get(currKey).toString(), currKey);
				rstPageData.add(currPageData);
			}
		}
		return rstPageData;
	}
}
