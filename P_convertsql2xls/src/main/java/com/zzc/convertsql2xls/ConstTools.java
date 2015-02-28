package com.zzc.convertsql2xls;

public class ConstTools {
	public static interface StrConst{
		String SPACE_NULL = "";
		String SPACE_SINGLE = " ";
		String SPACE_MULTI = "( )+";
	}
	
	public static interface SplitConst{
		String SP_DOT = ".";
		String SP_COMMA = ",";
		String SP_SEMIC = ";";
		String SP_BRA_LE = "(";
		String SP_BRA_RI = ")";
		String SP_NEW_LINE = System.getProperty("line.separator");
		String SP_QUOT_SING = "\'";
		String SP_QUOT_DOUB = "\"";
		String SP_COMB_QSS = "\';";
	}
	
	public static interface FileSuffix{
		String SUF_SQL = ".sql";
		String SUF_XLS = ".xls";
	}
	
	public static interface FileEncod{
		String GB18030 = "GB18030";
		String GB2312 = "GB2312";
		String GBK = "GBK";
		String UTF8 = "UTF-8";
		String UFT16 = "UTF-16";
		String UNICODE = "UNICODE";
	}
}
