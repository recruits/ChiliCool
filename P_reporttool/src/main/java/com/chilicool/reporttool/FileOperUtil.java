package com.chilicool.reporttool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class FileOperUtil {
	public static String getFileDir(String filePath){
		if(StringUtils.isNotEmpty(filePath)){
			return filePath.substring(0, filePath.lastIndexOf("/"));
		}
		return "";
	}
	
	public static String readFileContent(String filePath){
		if(StringUtils.isEmpty(filePath)){
			return "";
		}
		File file = new File(filePath);
		BufferedReader reader = null;
		
		StringBuffer templateFileContent = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while(line != null){
				templateFileContent.append(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return templateFileContent.toString();
	}
	
	public static void writeFileContent(String filePath, String fileCont){
		if(StringUtils.isEmpty(filePath) || StringUtils.isEmpty(fileCont)){
			return ;
		}
		
		File file = new File(filePath);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(fileCont);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
