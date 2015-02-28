package com.chilicool.fang_data;

import java.io.Serializable;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-10-7 上午10:53:56 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class PageData implements Serializable{
	private static final long serialVersionUID = 1148149465983913131L;
	private String cont;
	private String date;
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public PageData() {
		super();
	}
	public PageData(String cont, String date) {
		super();
		this.cont = cont;
		this.date = date;
	}
	@Override
	public String toString() {
		return "PageData [cont=" + cont + ", date=" + date + "]";
	}
}
