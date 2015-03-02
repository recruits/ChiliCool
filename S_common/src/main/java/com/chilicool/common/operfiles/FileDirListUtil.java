package com.chilicool.common.operfiles;

import java.io.File;
import java.text.MessageFormat;

/**
 * 生成数据库脚本. <br>
 * 类详细说明.
 * @author zhangzc.zzc@gmail.com
 * @date 2015年3月2日 下午2:49:40 <br>
 * Copyright: Copyright (c) 2015 ChiliCool
 */
public class FileDirListUtil {
	private final String showMsgHead = "prompt 数据库初始化脚本导入\nprompt -------------------------------------\n";
	private final String showMsgModel = "prompt 导入{0}\nprompt\n@@{1}\nprompt\nprompt -------------------------------------\n";
	private final String fileDirectory = "D:\\svnresource\\moto\\Waterway\\00-DOCUMENT\\07-割接\\01-数据迁移\\02-数据初始化";
	
	public String[] listFiles(){
		return new File(fileDirectory).list();
	}
	
	public void buildFileName(){
		StringBuffer sBuffer = new StringBuffer(showMsgHead);
		for(String currFileName : listFiles()){
			if(currFileName.indexOf("00") != -1){
				continue;
			}
			sBuffer.append(MessageFormat.format(showMsgModel, currFileName, currFileName));
		}
		System.out.println(sBuffer.toString());
	}
	
	public static void main(String[] args) {
		new FileDirListUtil().buildFileName();
	}
}
