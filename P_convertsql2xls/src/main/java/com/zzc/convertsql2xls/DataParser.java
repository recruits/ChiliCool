package com.zzc.convertsql2xls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.zzc.convertsql2xls.bean.ColumnObj;
import com.zzc.convertsql2xls.bean.TableObj;
import com.zzc.convertsql2xls.bean.TableString;


public class DataParser {
	private TableString tabStr;
	
	public DataParser(TableString tabStr){
		this.tabStr = tabStr;
	}
	
	public TableObj getTableObj(){
		TableObj tabObj = null;
		if(isTabStrValid()){
			// 1. create tabObj
			tabObj = createTableObj();
			
			// 2. get tabObj.name & tabObj.nameCn
			Map<String, String> names = getTabObjName();
			tabObj.setName(names.get(ParserConst.TAB_NAME));
			tabObj.setNameCn(names.get(ParserConst.TAB_NAME_CN));
			
			// 3. get tabObj.columns
			tabObj.setColumns(getCols());
			
		}
		return tabObj;
	}
	
	private TableObj createTableObj(){
		return new TableObj();
	}
	
	private boolean isTabStrValid(){
		return null != tabStr ;
	}
	
	private Map<String, String> getTabObjName(){
		Map<String, String> nameMap = new HashMap<String, String>();
		
		if(StringUtils.isNotEmpty(tabStr.getTableStr())){
			String[] spStr = tabStr.getTableStr().replaceAll(ConstTools.StrConst.SPACE_MULTI, ConstTools.StrConst.SPACE_SINGLE).split(ConstTools.StrConst.SPACE_SINGLE);
			nameMap.put(ParserConst.TAB_NAME, spStr[2]);
			nameMap.put(ParserConst.TAB_NAME_CN, spStr[3]);
		}
		
		return nameMap;
	}
	
	private List<ColumnObj> getCols(){
		List<ColumnObj> cols = parseColumn();
		
		if(null != cols && cols.size() > 0){
			parseContraint(cols);
		
			parseComment(cols);
		}
		
		return cols;
	}
	
	private List<ColumnObj> parseColumn(){
		List<ColumnObj> colmunList = new ArrayList<ColumnObj>();
		
		List<String> columns = tabStr.getColumnsStr();
		if(null != columns && columns.size() > 0){
			for(String colStr : columns){
				ColumnObj colObj = new ColumnObj();
				
				if(StringUtils.isNotEmpty(colStr)){
					String[] colArry = colStr.replace(ConstTools.SplitConst.SP_COMMA, ConstTools.StrConst.SPACE_NULL).replaceAll(ConstTools.StrConst.SPACE_MULTI, ConstTools.StrConst.SPACE_SINGLE).split(ConstTools.StrConst.SPACE_SINGLE);
					
					if(colArry.length > 2 && colArry[2].equals(ParserConst.STR_NOT) && colArry[3].equals(ParserConst.STR_NULL)){
						colObj.setIsNotNull(ColDefVal.Y.name());
						colObj.setNameCn(colArry[4]);
					} else if(colArry.length > 2 && colArry[2].equals(ParserConst.STR_NULL)){
						colObj.setNameCn(colArry[3]);
					} else {
						colObj.setNameCn(colArry[2]);
					}
					
					colObj.setName(colArry[0].replace(ConstTools.SplitConst.SP_QUOT_DOUB, ConstTools.StrConst.SPACE_NULL));
					colObj.setType(colArry[1]);
					
					colmunList.add(colObj);
				}
			}
		}
		
		return colmunList;
	}
	
	private void parseContraint(List<ColumnObj> cols){
		List<String> contra = tabStr.getConstraStr();
		
		if(null != contra && contra.size() > 0){
			for(String conStr : contra){
				if(StringUtils.isNotEmpty(conStr)){
					if(conStr.replace(ConstTools.StrConst.SPACE_SINGLE, ConstTools.StrConst.SPACE_NULL).contains(ParserConst.STR_PRIMARYKEY)){
						String[] colArry = conStr.substring(conStr.indexOf(ConstTools.SplitConst.SP_BRA_LE) + 1, conStr.indexOf(ConstTools.SplitConst.SP_BRA_RI)).split(ConstTools.SplitConst.SP_COMMA); 
						for(String colCode : colArry){
							for(ColumnObj colObj : cols){
								if(colCode.trim().equals(colObj.getName())){
									colObj.setIsPK(ColDefVal.Y.name());
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void parseComment(List<ColumnObj> cols){
		List<String> comment = tabStr.getCommentStr();
		
		if(null != comment && comment.size() > 0){
			for(String commStr : comment){
				if(StringUtils.isNotEmpty(commStr)){
					String[] comms = commStr.split(ConstTools.SplitConst.SP_NEW_LINE);
					
					String colName = "";
					String comCont = "";
					for(int i=0; i<comms.length; i++){
						if(StringUtils.isEmpty(comms[i])){
							continue;
						}
						
						if( i == 0 ){
							if(StringUtils.isNotEmpty(comms[i])){
								String temp = comms[i];
								colName = temp.substring(temp.indexOf(ConstTools.SplitConst.SP_DOT)+1).split(ConstTools.StrConst.SPACE_SINGLE)[0];
							}
						} else if(comms[i].startsWith(ConstTools.SplitConst.SP_QUOT_SING)){
							if(comms[i].endsWith(ConstTools.SplitConst.SP_COMB_QSS)){
								comCont += comms[i].length() > 2 ? comms[i].substring(1, comms[i].length() - 2) : "";
							} else {
								comCont += comms[i].substring(1) + ConstTools.SplitConst.SP_NEW_LINE;
							}
						} else if(comms[i].endsWith(ConstTools.SplitConst.SP_COMB_QSS)){
							comCont += comms[i].substring(0, comms[i].length()-2);
						} else {
							comCont += comms[i] + ConstTools.SplitConst.SP_NEW_LINE;
						}
					}
					
					for(ColumnObj colObj : cols){
						if(colName.equals(colObj.getName())){
							colObj.setNote(comCont);
						}
					}
				}
			}
		}
	}
}

enum ColDefVal{
	N, Y;
}
interface ParserConst{
	String STR_NOT = "NOT";
	String STR_NULL = "NULL";
	String STR_PRIMARYKEY = "PRIMARYKEY";
	String TAB_NAME = "name";
	String TAB_NAME_CN = "nameCn";
}