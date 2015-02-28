package com.zzc.convertsql2xls.bean;

import java.util.List;

public class TableObj {
	private String name;
	private String nameCn;
	private List<ColumnObj> columns;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}
	public List<ColumnObj> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnObj> columns) {
		this.columns = columns;
	}
}
