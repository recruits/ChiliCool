package com.zzc.convertsql2xls;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang3.StringUtils;

import com.zzc.convertsql2xls.bean.ColumnObj;
import com.zzc.convertsql2xls.bean.TableObj;

public class FileCreater {
	private String[] colTitle = { "字段名称", "中文名称", "字段类型", "主键", "必填", "规格化标识", "备注" };
	private String fileName;

	public FileCreater(String fileName) {
		this.fileName = fileName;
	}

	public void saveData(List<TableObj> tabObjList) {
		if (null == tabObjList || tabObjList.size() == 0) {
			return;
		}

		try {
			WritableWorkbook book = createWorkBook();
			if (null != book) {
				createBookSheet(book, "data", 0, tabObjList);
			}
			
			book.write();
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private WritableWorkbook createWorkBook() {
		try {
			File excelFile = new File(fileName);
			if (excelFile.exists()) {
				excelFile.delete();
			}
			return Workbook.createWorkbook(excelFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void createBookSheet(WritableWorkbook book, String sheetName,
			int index, List<TableObj> tabObjList) {
		WritableSheet sheet = book.createSheet(sheetName, index);

		try {
			setColWidth(sheet);
			
			WritableCellFormat tabFormat = new WritableCellFormat(getTabHeadFont());
			tabFormat.setAlignment(Alignment.LEFT);

			WritableCellFormat colHeadFormat = new WritableCellFormat(getColHeadFont());
			colHeadFormat.setAlignment(Alignment.CENTRE);
			colHeadFormat.setBackground(Colour.GRAY_50);
			colHeadFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

			WritableCellFormat colBodyFormat = new WritableCellFormat(getColBodyFont());
			colBodyFormat.setAlignment(Alignment.LEFT);
			colBodyFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			colBodyFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			colBodyFormat.setWrap(true);

			createCellInfo(tabObjList, sheet, tabFormat, colHeadFormat, colBodyFormat);
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}
	
	private void setColWidth(WritableSheet sheet) {
		sheet.setColumnView(0, 15);
		sheet.setColumnView(1, 15);
		sheet.setColumnView(2, 13);
		sheet.setColumnView(3, 5);
		sheet.setColumnView(4, 5);
		sheet.setColumnView(5, 5);
		sheet.setColumnView(6, 35);
	}

	private void createCellInfo(List<TableObj> tabObjList, WritableSheet sheet,
			WritableCellFormat... formats) {
		int rowCnt = 0;
		int colCnt = 0;

		try {
			for (TableObj tabObj : tabObjList) {
				// 写入TABLE信息
				Label tabName = new Label(colCnt++, rowCnt, tabObj.getName(), formats[0]);
				Label tabNameCn = new Label(colCnt, rowCnt, tabObj.getNameCn(), formats[0]);
				sheet.addCell(tabName);
				sheet.addCell(tabNameCn);

				// 计数单元格重新初始化
				colCnt = 0;
				rowCnt++;
				
				// 写入字段标题
				for(String str : colTitle){
					Label colTitle = new Label(colCnt++, rowCnt, str, formats[1]);
					sheet.addCell(colTitle);
				}
				
				// 计数单元格重新初始化
				colCnt = 0;
				rowCnt++;
				
				// 写入字段内容
				for(ColumnObj column : tabObj.getColumns()){
					Label colName = new Label(colCnt++, rowCnt, column.getName(), formats[2]);
					sheet.addCell(colName);
					
					Label colNameCn = new Label(colCnt++, rowCnt, column.getNameCn(), formats[2]);
					sheet.addCell(colNameCn);
					
					Label type = new Label(colCnt++, rowCnt, column.getType(), formats[2]);
					sheet.addCell(type);
					
					Label isPK = new Label(colCnt++, rowCnt, StringUtils.isEmpty(column.getIsPK()) ? "" : column.getIsPK(), formats[2]);
					sheet.addCell(isPK);
					
					Label isNotNull = new Label(colCnt++, rowCnt, StringUtils.isEmpty(column.getIsNotNull()) ? "" : column.getIsNotNull(), formats[2]);
					sheet.addCell(isNotNull);
					
					Label spec = new Label(colCnt++, rowCnt, "", formats[2]);
					sheet.addCell(spec);
					
					Label note = new Label(colCnt++, rowCnt, StringUtils.isEmpty(column.getNote()) ? "" : column.getNote(), formats[2]);
					sheet.addCell(note);
					
					// 计数单元格重新初始化
					colCnt = 0;
					rowCnt++;
				}
			}
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	private WritableFont getTabHeadFont() {
		return new WritableFont(WritableFont.createFont("宋体"),// 字体
				11, // 字号
				WritableFont.BOLD, // 粗体
				false, // 斜体
				UnderlineStyle.NO_UNDERLINE, // 下划线
				Colour.BLACK, // 字体颜色
				ScriptStyle.NORMAL_SCRIPT);
	}

	private WritableFont getColHeadFont() {
		return new WritableFont(WritableFont.createFont("宋体"),// 字体
				9, // 字号
				WritableFont.BOLD, // 粗体
				false, // 斜体
				UnderlineStyle.NO_UNDERLINE, // 下划线
				Colour.BLACK, // 字体颜色
				ScriptStyle.NORMAL_SCRIPT);
	}

	private WritableFont getColBodyFont() {
		return new WritableFont(WritableFont.createFont("宋体"),// 字体
				9, // 字号
				WritableFont.NO_BOLD, // 粗体
				false, // 斜体
				UnderlineStyle.NO_UNDERLINE, // 下划线
				Colour.BLACK, // 字体颜色
				ScriptStyle.NORMAL_SCRIPT);
	}
}
