package com.chilicool.common.columncomp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

public abstract class ObjectParse {
	public Map<String, TableObject> buildTabNameFromList(List<TableObject> tabList){
		Map<String, TableObject> tabNameMap = new HashMap<String, TableObject>();
		if(CollectionUtils.isNotEmpty(tabList)){
			for(TableObject currTab : tabList){
				tabNameMap.put(currTab.getTableName(), currTab);
			}
		}
		return tabNameMap;
	}
	
	public List<TableObject> parseFile() {
		return null;
	}

	public List<String> readLinesFromFile(String fileName) {
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(
					fileName)));
			while (reader.ready()) {
				lines.add(reader.readLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public List<TableObject> runDealer(String fileName, boolean pdmFlag){
		List<TableObject> rstObjects = new ArrayList<TableObject>();
		List<String> allLines = readLinesFromFile(fileName);
		TableObject currTabObject = null;
		String currTabName = "";
		for(String currLine : allLines){
			String[] items = currLine.split("~");
			if(!currTabName.equals(items[0])){
				currTabName = items[0];
				currTabObject = new TableObject(currTabName);
				
				rstObjects.add(currTabObject);
			} 
			
//			System.out.println("\t\tcontent from pdm: " + pdmFlag + ", curr tab name :" + currTabName + ", item length is :" + items.length);
			ColumnObject currColObject = new ColumnObject(items[1].trim(),pdmFlag ? items[3].trim() : items[2].trim());
			if(CollectionUtils.isEmpty(currTabObject.getColumns())){
				currTabObject.setColumns(new ArrayList<ColumnObject>());
				currTabObject.setColumnMap(new LinkedHashMap<String, ColumnObject>());
				currTabObject.setSortColumnMap(new LinkedHashMap<String, ColumnObject>());
			}
			
			currTabObject.getColumns().add(currColObject);
			currTabObject.getColumnMap().put(items[1].trim(), currColObject);
			
		}
		return rstObjects;
	}
}
