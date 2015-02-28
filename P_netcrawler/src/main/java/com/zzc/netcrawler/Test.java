package com.zzc.netcrawler;

import java.io.IOException;
import java.net.MalformedURLException;

import com.zzc.netcrawler.service.PageHolderUrl;

public class Test {
	public static void main(String[] args) {
		
//		String pageContent = "<meta name=\"keywords\" content=\"hello\" /><meta name=\"description\" content=\"\" />" ;
//		
//		Pattern labelReg = Pattern.compile("<meta +name=\"keywords\" +content=\"(.+?)\"");
//		Matcher labels = labelReg.matcher(pageContent);
//		while (labels.find()) {
//			String out = labels.group(1);
//			if(out.replaceAll(" ", "").equals("\"/><metaname=")){
//				out = "not found";
//			}
//			System.out.println(out);
//		}
		
		
		String url = "http://jipiao.dv37.com/";
		try {
			PageHolderUrl page = new PageHolderUrl(url);
			
			System.out.println(page.getPageTitle());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
