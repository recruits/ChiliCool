package com.zzc.convertsql2xls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zzc.convertsql2xls.bean.TableString;

public class DataLoader {
	private FileInput fileReader;
	private List<TableString> tabStrList = new ArrayList<TableString>();
	
	public DataLoader(String filePath) throws FileNotFoundException{
		try {
			this.fileReader = new FileInput(filePath);
		} catch (FileNotFoundException e) {
			throw e;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用SQL的关键字(动作)，进行数据分析
	 * @return
	 */
	public List<TableString> loadData(){
		// 创建动作上下文，保证在处理下一行的时候，知道与哪个动作关联
		Map<String, Object> context = new HashMap<String, Object>();
		context.put(LoaderConst.CURRENT_STEP, ActiveStep.UNVALIDKEY);
		
		String oneLine;
		try {
			// 数据逐行处理
			while((oneLine = fileReader.getOneLine()) != null){
				if(StringUtils.isNotEmpty(oneLine)){
					if(!dealOneLine(StringUtils.trim(oneLine.toUpperCase()), context)){
						break;
					}
				}
			}
			
			// 补充最后一张表
			if (context.get(LoaderConst.TABLE_STRING) != null
					&& StringUtils.isNotEmpty(((TableString) context
							.get(LoaderConst.TABLE_STRING)).getTableStr())) {
				tabStrList.add((TableString) context.get(LoaderConst.TABLE_STRING));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fileReader.dispose();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 数据预处理(二次加工)，目前只处理了comment部分
		reDealData();
		
		return tabStrList;
	}
	
	private boolean dealOneLine(String oneLine, Map<String, Object> context){
		boolean result = true;
		
		// 非法数据过滤
		if(isContentValid(oneLine)){
			ActiveStep activeStep = getOneLineType(oneLine);
			
			switch(activeStep){
				case IF:
					context.put(LoaderConst.CURRENT_STEP, ActiveStep.IF);
					
					break;
				case CREATETABLE:
					if(context.get(LoaderConst.TABLE_STRING) != null && StringUtils.isNotEmpty(((TableString) context.get(LoaderConst.TABLE_STRING)).getTableStr())){
						tabStrList.add((TableString) context.get(LoaderConst.TABLE_STRING));
					}
					
					context.put(LoaderConst.TABLE_STRING, new TableString());
					context.put(LoaderConst.CURRENT_STEP, ActiveStep.CREATETABLE);
					((TableString) context.get(LoaderConst.TABLE_STRING)).setTableStr(oneLine);
					
					break;
				case COMMENT:
					context.put(LoaderConst.CURRENT_STEP, ActiveStep.COMMENT);
					((TableString) context.get(LoaderConst.TABLE_STRING)).getCommentStr().add(oneLine);
					
					break;
				case TRUNCATE:
					context.put(LoaderConst.CURRENT_STEP, ActiveStep.TRUNCATE);
					
					break;
				case INSERT:
					context.put(LoaderConst.CURRENT_STEP, ActiveStep.INSERT);
					
					break;
				case UNVALIDKEY:
					// 根据具体的动作， 判断当前应该进行如何处理
					context.put(
							LoaderConst.TABLE_STRING,
							dealByActiveStepAndStatus(
									(ActiveStep) context.get(LoaderConst.CURRENT_STEP),
									(TableString) context.get(LoaderConst.TABLE_STRING), oneLine));

					break;
				default :
					
			}
		}
		
		return result;
	}
	
	/**
	 * 非法处理定义，目前只定义了以下数据：注释行数据
	 * @param oneLine
	 * @return
	 */
	private boolean isContentValid(String oneLine){
		boolean checkResult = true;
		
		String[] unValidStartStr = {"/*"};
		for(String prefix : unValidStartStr){
			if(oneLine.startsWith(prefix)){
				checkResult = false;
				break;
			}
		}
		
		return checkResult;
	}
	
	/**
	 * 根据关键字识别当前行动作
	 * @param oneLine
	 * @return
	 */
	private ActiveStep getOneLineType(String oneLine){
		for(ActiveStep key: ActiveStep.values()){
			if(oneLine.replaceAll(ConstTools.StrConst.SPACE_MULTI, ConstTools.StrConst.SPACE_NULL).contains(key.name())){
				return key;
			}
		}
		return ActiveStep.UNVALIDKEY;
	}
	
	/**
	 * 关键字范围内，其它内容处理
	 * @param activeStep
	 * @param tabStr
	 * @param oneLine
	 * @return
	 */
	private TableString dealByActiveStepAndStatus(ActiveStep activeStep, TableString tabStr, String oneLine){
		switch(activeStep){
			case IF:
				// 预留处理内容
				
				break;
			case CREATETABLE:
				if(oneLine.contains("CONSTRAINT")){
					tabStr.getConstraStr().add(oneLine);
				} else if(!oneLine.startsWith(ConstTools.SplitConst.SP_BRA_LE) && !oneLine.startsWith(ConstTools.SplitConst.SP_BRA_RI)){
					tabStr.getColumnsStr().add(oneLine);
				}
				
				break;
			case COMMENT:
				tabStr.getCommentStr().add(oneLine);
				
				break;
			case TRUNCATE:
				// 预留处理内容
				
				break;
			case INSERT:
				// 预留处理内容
				
				break;
			case UNVALIDKEY:
	
				break;
			default :
		}
		
		return tabStr;
	}
	
	/**
	 * 加载后的数据，预处理
	 */
	private void reDealData(){
		if(null != tabStrList || tabStrList.size() > 0){
			
			for(TableString tabStr : tabStrList){
				List<String> commData = tabStr.getCommentStr();	
				if(null != commData && commData.size() > 0){
					// 再次处理comment内容
					List<String> comments = new ArrayList<String>();
					
					String comment = "";
					for(String comm : commData){
						if(StringUtils.isEmpty(comm) || comm.trim().equals(ConstTools.SplitConst.SP_NEW_LINE)){
							continue;
						}
						
						if(comm.startsWith(ActiveStep.COMMENT.name())){
							if(StringUtils.isNotEmpty(comment)){
								comments.add(comment);
								comment = "";
							} 
						} 
						
						comment += comm + ConstTools.SplitConst.SP_NEW_LINE;
						
					}
					if(StringUtils.isNotEmpty(comment)){
						comments.add(comment);
					}
					
					tabStr.setCommentStr(comments);
				}
			}
			 
		}
	}
}

enum ActiveStep{
	IF, CREATETABLE, COMMENT, TRUNCATE, INSERT, UNVALIDKEY;
}
enum ActiveFlag{
	BEGIN, STOP, UNDEAL;
}
interface LoaderConst{
	String CURRENT_STEP = "currStep"; 
	String TABLE_STRING = "tabStr";
}