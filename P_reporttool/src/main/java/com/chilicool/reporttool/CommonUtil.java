package com.chilicool.reporttool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {

	public static String getFileDir(String filePath) {
		if (StringUtils.isNotEmpty(filePath)) {
			return filePath.substring(0, filePath.lastIndexOf("/"));
		}
		return "";
	}

	public static String readFileContent(String filePath) {
		if (StringUtils.isEmpty(filePath)) {
			return "";
		}
		File file = new File(filePath);
		BufferedReader reader = null;

		StringBuffer templateFileContent = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
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

	public static void writeFileContent(String filePath, String fileCont) {
		if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(fileCont)) {
			return;
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

	public static Properties getProperties() {
		if (null == prop) {
			try {
				InputStream inputStream = new CommonUtil().getClass()
						.getClassLoader()
						.getResourceAsStream("printTemplate.properties");
				prop = new Properties();
				prop.load(inputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return prop;
	}
	
	public static void logInfo(String msg){
		logInfo("", msg);
	}
	public static void logInfo(String type, String msg){
		if(StringUtils.isEmpty(type)){
			System.out.println("========== " + msg);
		} else if("info".equals(type.toLowerCase())){
			System.out.println("---------- " + msg);
		} else if("error".equals(type.toLowerCase())){
			System.out.println("---------- error : " + msg);
		}
	}

	private static Properties prop = null;
	public static final String templateFilePath = "templateFilePath";
	public static final String javaBeanPath = "javaBeanPath";
	public static final String javaBeanPackage = "javaBeanPackage";
	public static final String serviceBeanPath = "serviceBeanPath";
	public static final String serviceBeanPackage = "serviceBeanPackage";
	public static final String templateName = "templateName";
	public static final String templatePath = "templatePath";
	public static final String templateGroup = "templateGroup";
	public static final String busiType = "busiType";
	public static final String ignoreDbData = "ignoreDbData";
	
	public static final String ERROR = "error";
	public static final String DB_SERVICE_NAME = "cn.cttic.wtms.common.tool.report.DbDataService";
}
