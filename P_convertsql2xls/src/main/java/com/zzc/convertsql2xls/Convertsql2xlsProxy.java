package com.zzc.convertsql2xls;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class Convertsql2xlsProxy {
	private static DataConver dataConver;
	private static Convertsql2xlsApp pageConver;
	
	private static void initInstance(Convertsql2xlsApp inPageConver, String inFilePath){
		pageConver = inPageConver;
		dataConver = new DataConver(inFilePath);
	}
	
	public static void startConvert(Convertsql2xlsApp inPageConver, String inFilePath){
		initInstance(inPageConver, inFilePath);
		
		dataConver.startConver();
	}
	
	public static void refreshShowMsg(String showMsg){
		if(null != pageConver){
			pageConver.getText_1().append(getFormatString(showMsg));
		} else {
			// 初始化异常
		}
	}
	
	private static String getFormatString(String showMsg){
		StringBuilder rstStr = new StringBuilder();
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
	    String ctime = formatter.format((new Date()).getTime()); 
		
		Formatter format = new Formatter();
		format.format("   %13s %s", ctime,showMsg);
		rstStr.append(format.toString()).append(ConstTools.SplitConst.SP_NEW_LINE);
		format.close();
		
		return rstStr.toString();
	}
	
	public static String getUseingMeghod(){
		StringBuilder builder = new StringBuilder();
		builder.append("1.SQL文件:" + ConstTools.SplitConst.SP_NEW_LINE);
		builder.append("    支持打开方式选择单个文件" + ConstTools.SplitConst.SP_NEW_LINE);
		builder.append("    支持输入文件夹" + ConstTools.SplitConst.SP_NEW_LINE);
		builder.append("2.功能说明：" + ConstTools.SplitConst.SP_NEW_LINE);
		builder.append("    通过PowerDesigner把物理模型导出为crebas.sql" + ConstTools.SplitConst.SP_NEW_LINE);
		builder.append("    选中crebas.sql，或者输入它所在的目录" + ConstTools.SplitConst.SP_NEW_LINE);
		builder.append("    使用转换功能转换成固定格式的excel文件" + ConstTools.SplitConst.SP_NEW_LINE);
		builder.append("");
		return builder.toString();
	}
}