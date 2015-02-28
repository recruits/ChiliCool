package com.chilicool.fang_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作文件：写入，读取. <br>
 * .
 * 
 * @author zhangzechen@cttic.cn
 * @date 2014-10-7 上午10:51:21 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class FileDealer {
	// 清空文件内容
	public static void clearFileContent(String fileName){
		try {
			System.out.println("start to clear file...");
			FileOutputStream currfile = new FileOutputStream(fileName);
			currfile.write(new String("").getBytes());
			currfile.close();
			System.out.println("clear file successful!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 追加写入文件
	public static void appendData(String fileName, String content) {
		try {
			System.out.println("start to write file...");
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
			randomFile.close();
			System.out.println("write file successful!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 写入文件[对象列表]
	public static void appendObject(String fileName, Object obj) {
		try {
			System.out.println("start to write file...");
			System.out.println("file name :" + fileName);
			FileOutputStream outStream = new FileOutputStream(fileName, true);
			ObjectOutputStream outObj = new ObjectOutputStream(outStream);
			outObj.writeObject(obj);
			outObj.flush();
			outObj.close();
			outStream.close();
			System.out.println("write file successful!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 读出文件[对象列表]
	@SuppressWarnings("unchecked")
	public static List<PageData> readObjects(String fileName) {
		List<PageData> pageDatas = new ArrayList<PageData>();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileName));
//			PageData currPageData = (PageData) in.readObject();
//			pageDatas.add(currPageData);
//			
//			PageData currPageData2 = (PageData) in.readObject();
//			pageDatas.add(currPageData2);
			pageDatas = (List<PageData>) in.readObject();
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageDatas;
	}

}
