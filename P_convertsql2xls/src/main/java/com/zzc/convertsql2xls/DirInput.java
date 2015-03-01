package com.zzc.convertsql2xls;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class DirInput {
	private File file;
	
	public DirInput(String filePath){
		this.file = new File(filePath);
	}
	
	public List<String> getAllFilePath(){
		return getAllFilePath("");
	}
	
	public List<String> getAllFilePath(String sufixMatch){
		List<String> filePathList = new ArrayList<String>();
		
		if(file.exists()){
			for(File loopFile : getFileFromDir()){
				String absolutePath = loopFile.getAbsolutePath();
				
				if(StringUtils.isEmpty(sufixMatch)){
					filePathList.add(absolutePath);
				} else if(absolutePath.endsWith(sufixMatch)){
					filePathList.add(absolutePath);
				}
			}
		}
		
		return filePathList;
	}
	
	public List<File> getFileFromDir(){
		return getFileFromDir(file);
	}
	public List<File> getFileFromDir(File filePath){
		List<File> files = new ArrayList<File>();
		
		if(filePath.isDirectory()){
			File[] curFiles = filePath.listFiles();
			for(File curFile : curFiles){
				if(curFile.isDirectory()){
					files.addAll(getFileFromDir(curFile.getAbsoluteFile()));
				} else {
					files.add(curFile);
				}
			}
		} else {
			files.add(filePath);
		}

		return files;
	}
}
