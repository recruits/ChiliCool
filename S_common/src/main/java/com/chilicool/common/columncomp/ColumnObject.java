package com.chilicool.common.columncomp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ColumnObject {
	private String colName;
	private String colType;
	public ColumnObject() {
		super();
	}
	public ColumnObject(String colName, String colType) {
		super();
		this.colName = colName;
		this.colType = colType;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ColumnObject) {
			ColumnObject outColumn = (ColumnObject) obj;
			
			String dbLength = "", pdmLength = "";
			if(!this.colType.equals("DATE")){
				Pattern encodReg = Pattern.compile("\\(([0-9]+)\\)");
				Matcher encod = encodReg.matcher(this.colType);
				while (encod.find()) {
					dbLength = encod.group(1);
				}
				
				Matcher encod1 = encodReg.matcher(this.colType);
				while (encod1.find()) {
					pdmLength = encod1.group(1);
				}
			}

			return this.colName.equals(outColumn.getColName())
					&& (this.colType.equals(outColumn.getColType()) || (StringUtils.isNotEmpty(dbLength)
							&& StringUtils.isNotEmpty(pdmLength) ? Integer.valueOf(dbLength) <= Integer.valueOf(pdmLength) : false));
		} else {
			return false;
		}
	}
}
