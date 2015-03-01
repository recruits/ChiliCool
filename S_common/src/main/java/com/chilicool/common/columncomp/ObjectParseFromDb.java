package com.chilicool.common.columncomp;

import java.util.List;

public class ObjectParseFromDb extends ObjectParse{
	private static final String fileName = "C:\\Users\\zhangzechen\\Desktop\\dtwork\\db_columns_compare\\DB_COLUMNS.txt";
	
	public List<TableObject> parseFile(){
		return super.runDealer(ObjectParseFromDb.fileName, false);
	}
}
