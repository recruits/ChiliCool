package com.chilicool.common.columncomp;

import java.util.HashMap;
import java.util.List;

public class TableObject {
	private String tableName;
	private int colNum;
	private List<ColumnObject> columns;
	private HashMap<String, ColumnObject> columnMap;
	private HashMap<String, ColumnObject> sortColumnMap;
	public TableObject() {
		super();
	}
	public TableObject(String tableName) {
		super();
		this.tableName = tableName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getColNum() {
		return colNum;
	}
	public void setColNum(int colNum) {
		this.colNum = colNum;
	}
	public List<ColumnObject> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnObject> columns) {
		this.columns = columns;
	}
	public HashMap<String, ColumnObject> getColumnMap() {
		return columnMap;
	}
	public void setColumnMap(HashMap<String, ColumnObject> columnMap) {
		this.columnMap = columnMap;
	}
	public HashMap<String, ColumnObject> getSortColumnMap() {
		return sortColumnMap;
	}
	public void setSortColumnMap(HashMap<String, ColumnObject> sortColumnMap) {
		this.sortColumnMap = sortColumnMap;
	}

}
