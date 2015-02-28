package com.zzc.convertsql2xls;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.zzc.convertsql2xls.bean.TableObj;
import com.zzc.convertsql2xls.bean.TableString;

public class DataConver {
	private DirInput dirInput;
	private DataLoader dataLoader;
	private FileCreaterNew fileCreater;
	
	public DataConver(String inFilePath){
		dirInput = new DirInput(inFilePath);
	}
	
	public void startConver(){
		// 取出SQL文件列表
		List<String> inFilePathList = dirInput.getAllFilePath(ConstTools.FileSuffix.SUF_SQL);
		
		// 逐个文件处理
		for(String inFileName : inFilePathList){
			singleFileDealer(inFileName);
		}
	}
	
	/**
	 * 单个文件处理
	 * @param inFileName
	 */
	private void singleFileDealer(String inFileName){
		try {
			// 1.加载指定文件的数据
			Convertsql2xlsProxy.refreshShowMsg("inFileName: " + inFileName);
			System.out.println("===== inFileName: " + inFileName);
			dataLoader = new DataLoader(inFileName);
			List<TableString> tabStrList = dataLoader.loadData();
			
			// 2.数据转换
			List<TableObj> tabObjList = new ArrayList<TableObj>();
			for(TableString tabStr : tabStrList){
				DataParser tabParser = new DataParser(tabStr);
				
				tabObjList.add(tabParser.getTableObj());
			}
			
			// 3.数据输出
			String outFileName = getOutFileName(inFileName);
			Convertsql2xlsProxy.refreshShowMsg("outFileName: " + outFileName);
			System.out.println("===== outFileName: " + outFileName);
			fileCreater = new FileCreaterNew(outFileName);
			//fileCreater.saveData(tabObjList);
			fileCreater.saveDataToSheet(tabObjList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getOutFileName(String inFileName){
		return inFileName.substring(0, inFileName.lastIndexOf(ConstTools.SplitConst.SP_DOT)) + ConstTools.FileSuffix.SUF_XLS;
	}
}
