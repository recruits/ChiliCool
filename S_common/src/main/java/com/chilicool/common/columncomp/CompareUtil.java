package com.chilicool.common.columncomp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;


public class CompareUtil {
	private ObjectParse pdmParser = new ObjectParseFromPdm();
	private ObjectParse dbParser = new ObjectParseFromDb();
	
	public void startCompare(){
		List<TableObject> pdmTabs = pdmParser.parseFile();
		List<TableObject> dbTabs = dbParser.parseFile();
		
		// 生成表名、对象的MAP集合
		Map<String, TableObject> pdmTabMap = pdmParser.buildTabNameFromList(pdmTabs);
		Map<String, TableObject> dbTabMap = dbParser.buildTabNameFromList(dbTabs);
		// 取出表名集合
		Set<String> pdmTabNames = pdmTabMap.keySet();
		Set<String> dbTabNames = dbTabMap.keySet();
		// 保存共有表集合
		List<String> commTabNames = new ArrayList<String>();
		
		// 输出DB存在，PDM不存在的表数据
		StringBuffer sBuffer = new StringBuffer("--------------------------------------------------------------------------------------------------------------------------\n");
		sBuffer.append("-----数据库中共有 " + pdmTabs.size() + " 张表,PDM中共有 " + dbTabs.size() + "张表\n");
		
		StringBuffer tmpBuffer = new StringBuffer();
		for(String tabName : dbTabNames){
			if(pdmTabNames.contains(tabName)){
				commTabNames.add(tabName);
			} else {
				tmpBuffer.append(tabName).append(",");
			}
		}
		if(StringUtils.isNotEmpty(tmpBuffer.toString())){
			sBuffer.append("-----数据库中存在，PDM中不存在的表结构:\n\t[").append(StringUtils.removeEnd(tmpBuffer.toString(), ",")).append("]\n");
			tmpBuffer = new StringBuffer();
		}
		
		// 输出PDM存在，DB不存在的表数据
		for(String tabName : pdmTabNames){
			if(!dbTabNames.contains(tabName)){
				tmpBuffer.append(tabName).append(",");
			}
		}
		if(StringUtils.isNotEmpty(tmpBuffer.toString())){
			sBuffer.append("-----数据库中不存在，PDM中存在的表结构:\n\t[").append(StringUtils.removeEnd(tmpBuffer.toString(), ",")).append("]\n");
			tmpBuffer = new StringBuffer();
		}
		
		// 输出DB表结构与PDM表结构不一致的数据【表存在，结构不一致】
		StringBuffer sameBuffer = new StringBuffer();
		int sameCnt = 0;
		Collections.sort(commTabNames);
		for(String currTabName : commTabNames){
			TableObject dbTab = dbTabMap.get(currTabName);
			TableObject pdmTab = pdmTabMap.get(currTabName);
			
			String colCompare = buildDifference(dbTab, pdmTab);
			if(colCompare.indexOf("=") != -1){
				tmpBuffer.append(colCompare);
			} else {
				sameBuffer.append(currTabName).append(",");
				sameCnt ++;
			}
		}
		// "-----表结构完全一致:\n\t["
		if(StringUtils.isNotEmpty(tmpBuffer.toString())){
			sBuffer.append("-----表结构不一致内容:\n").append(tmpBuffer.toString()).append("\n");
		}
		if(StringUtils.isNotEmpty(sameBuffer.toString())){
			sBuffer.append("-----表结构完全一致:" + sameCnt + " 个\n\t[").append(StringUtils.removeEnd(sameBuffer.toString(), ",")).append("]\n");
		}
		
		System.out.println(sBuffer.toString());
	}
	
	public String buildDifference(TableObject dbTab, TableObject pdmTab){
		// ("++++++++++++++++++++++++++++++++++++++++++++++++++" + dbTab.getTableName() + "++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		StringBuffer sBuffer = new StringBuffer("\t").append(String.format("%1$20s %2$-24s %1$s", "++++++++++++++++++++++++++++++++++++++++", dbTab.getTableName())).append("\n");
		// 取出字段列表、字段集合
		HashMap<String, ColumnObject> dbColMap = dbTab.getColumnMap();
		HashMap<String, ColumnObject> pdmColMap = pdmTab.getColumnMap();
		
		Set<String> dbColNames = dbColMap.keySet();
		Set<String> pdmColNames = pdmColMap.keySet();
		
		List<String> commColNames = new ArrayList<String>();
		
		// DB中存在，PDM不存在的字段  =====数据库中存在，pdm中不存在的字段:\n\t\t[
		StringBuffer tmpBuffer = new StringBuffer();
		for(String colName : dbColNames){
			if(pdmColNames.contains(colName)){
				commColNames.add(colName);
			} else {
				tmpBuffer.append(colName).append("--").append(dbColMap.get(colName).getColType()).append(",");
			}
		}
		if(StringUtils.isNotEmpty(tmpBuffer.toString())){
			sBuffer.append("\t").append(String.format("%1$10s %2$-18s %1$s", "=====", "数据库中存在，pdm中不存在的字段:")).append("\n");
			sBuffer.append("\t\t[").append(StringUtils.removeEnd(tmpBuffer.toString(), ",")).append("]\n");
			tmpBuffer = new StringBuffer();
		}

		// DB中不耻辱在，PDM中存在的字段
		for(String colName : pdmColNames){
			if(!dbColNames.contains(colName)){
				tmpBuffer.append(colName).append("--").append(pdmColMap.get(colName).getColType()).append(",");
			}
		}
		if(StringUtils.isNotEmpty(tmpBuffer.toString())){
			sBuffer.append("\t").append(String.format("%1$10s %2$-18s %1$s", "=====", "数据库中不存在，pdm中存在的字段:")).append("\n");
			sBuffer.append("\t\t[").append(StringUtils.removeEnd(tmpBuffer.toString(), ",")).append("]\n");
			tmpBuffer = new StringBuffer();
		}
		// DB与PDM不一致的字段类型【表存在，结构不一致】
		for(String colName : commColNames){
			ColumnObject dbColObj = dbColMap.get(colName);
			ColumnObject pdmColObj = pdmColMap.get(colName);
			if(!dbColObj.equals(pdmColObj)){
				tmpBuffer.append(String.format("%1$30s %2$15s %3$30s %4$15s ", dbColObj.getColName(), dbColObj.getColType(), pdmColObj.getColName(), pdmColObj.getColType())).append("\n");
			}
		}
		if(StringUtils.isNotEmpty(tmpBuffer.toString())){
			sBuffer.append("\t").append(String.format("%1$10s %2$-18s %1$s", "=====", "数据库与pdm中类型不一致的字段:")).append("\n");
			sBuffer.append("\t\t").append(String.format("%1$20s %2$40s", "DB","PDM")).append("\n");
			sBuffer.append(tmpBuffer.toString()).append("\n");
		}
		return sBuffer.toString();
	}
	
	public static void main(String[] args) {
		CompareUtil compareUtil = new CompareUtil();
		compareUtil.startCompare();
	}
}
