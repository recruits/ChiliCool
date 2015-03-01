package com.chilicool.common.columncomp;

import java.util.List;

public class ObjectParseFromPdm extends ObjectParse{
	private static final String fileName = "C:\\Users\\zhangzechen\\Desktop\\dtwork\\db_columns_compare\\PDM_COLUMNS.txt";
	
	public List<TableObject> parseFile(){
		return super.runDealer(ObjectParseFromPdm.fileName, true);
	}
}
