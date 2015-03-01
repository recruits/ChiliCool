package com.zzc.convertsql2xls;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

public class FileInput {
	private boolean isInit = false;
	private String filePath;
	private BufferedReader reader;
	private InputStream inputStream;

	public FileInput(String filePath) throws FileNotFoundException, UnsupportedEncodingException{
		this(filePath, "");
	}
	public FileInput(String filePath, String charSet) throws FileNotFoundException, UnsupportedEncodingException {
		try {
			this.filePath = filePath;
			if(StringUtils.isNotEmpty(charSet)){
				isInit = true;
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charSet));
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
	}

	public String getFileEncod(){
		return getFileEncod("");
	}
	public String getFileEncod(String filePathNew) {
		byte[] head = new byte[3];
		String code = ConstTools.FileEncod.GB2312;
		try {
			if(StringUtils.isNotEmpty(filePathNew)){
				inputStream = new FileInputStream(filePathNew);
			} else {
				inputStream = new FileInputStream(filePath);
			}
			inputStream.read(head);

			if (head[0] == -1 && head[1] == -2){
				code = ConstTools.FileEncod.UFT16;
			}
			if (head[0] == -2 && head[1] == -1){
				code = ConstTools.FileEncod.UNICODE;
			}
			if (head[0] == -17 && head[1] == -69 && head[2] == -65){
				code = ConstTools.FileEncod.UTF8;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return code;
	}
	
	public String getOneLine() throws IOException {
		try {
			if(reader == null){
				isInit = true;
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), getFileEncod()));
			}
			
			return reader.readLine();
		} catch (IOException e) {
			throw e;
		}
	}

	public void dispose() throws IOException {
		try {
			if(isInit){
				reader.close();
			}
		} catch (IOException e) {
			throw e;
		}
	}
}
