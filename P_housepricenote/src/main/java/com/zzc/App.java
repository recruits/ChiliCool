package com.zzc;

import java.io.IOException;
import java.net.MalformedURLException;

import com.zzc.hpnote.busi.PageHolderForHPNote;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		String pageUrl = "http://esf.soufun.com/chushou/3_181040202.htm";
		try {
			PageHolderForHPNote holder = new PageHolderForHPNote(pageUrl);
			System.out.println(holder.getPageContent());
			System.out.println("------------------");
			System.out.println(holder.getHpId());
			System.out.println("------------------");
			System.out.println(holder.getBaseInfo());
			System.out.println("------------------");
			System.out.println(holder.getPriceInfo());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
