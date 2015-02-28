package com.zzc.hpnote.domain;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-17 上午11:14:40 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class InfoModel {
	private OperType type;
	private String hId;
	private BaseInfo baseInfo;
	private PriceInfo priceInfo;
	public String gethId() {
		return hId;
	}
	public void sethId(String hId) {
		this.hId = hId;
	}
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	public PriceInfo getPriceInfo() {
		return priceInfo;
	}
	public void setPriceInfo(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}
	public OperType getType() {
		return type;
	}
	public void setType(OperType type) {
		this.type = type;
	}
	public static enum OperType{
		ADD(1),MOD(2);
		
		private int key;
		private OperType(int key){
			this.key = key;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
	}
}


