package com.zzc.netcrawler.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import com.zzc.netcrawler.domain.NetInfo;

public class PageHolderUrl extends PageHolder{
	private NetInfo netInfo;
	public PageHolderUrl(String pageUrl) throws MalformedURLException, IOException {
		super(pageUrl);
	}
	public NetInfo getNetInfo() {
		buildNetInfo();
		return netInfo;
	}
	private void buildNetInfo(){
		if(null == netInfo){
			netInfo = new NetInfo();
		}
		
		Date currTime = new Date();
		netInfo.setCreateTime(currTime);
		netInfo.setEncode(getPageEncoding());
		netInfo.setNetDesc(getPageDescription());
		netInfo.setNetKeys(getPageLabel());
		netInfo.setNetTitle(getPageTitle());
		netInfo.setResCode(getPageRespCode());
		netInfo.setParseTime((int)getTotTime());
	}
}
