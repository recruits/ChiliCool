package com.zzc.convertsql2xls.bean;

import java.util.ArrayList;
import java.util.List;

public class TableString {
	private String tableStr;
	private List<String> columnsStr = new ArrayList<String>();
	private List<String> constraStr = new ArrayList<String>();
	private List<String> commentStr = new ArrayList<String>();
	public String getTableStr() {
		return tableStr;
	}
	public void setTableStr(String tableStr) {
		this.tableStr = tableStr;
	}
	public List<String> getColumnsStr() {
		return columnsStr;
	}
	public void setColumnsStr(List<String> columnsStr) {
		this.columnsStr = columnsStr;
	}
	public List<String> getConstraStr() {
		return constraStr;
	}
	public void setConstraStr(List<String> constraStr) {
		this.constraStr = constraStr;
	}
	public List<String> getCommentStr() {
		return commentStr;
	}
	public void setCommentStr(List<String> commentStr) {
		this.commentStr = commentStr;
	}
}
