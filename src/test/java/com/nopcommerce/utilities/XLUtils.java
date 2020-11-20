package com.nopcommerce.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell col;
	
	//open excel file for reading
	public static void setExcelFile(String xlfile, String xlsheet) throws Exception {
		
		try {
			
			FileInputStream ExcelFile = new FileInputStream(xlfile);
			//create workbook
			wb = new XSSFWorkbook(ExcelFile);
			ws = wb.getSheet(xlsheet);
		}catch(Exception e) {
			throw(e);
		}
	}
	
	//count number of Rows
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int no_of_rows = ws.getLastRowNum();
		wb.close();
		fi.close();
		
		return no_of_rows;
	}
	
	//count number of columns
	public static int getColumnCount(String xlfile, String xlsheet, int row_num) throws Exception {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(row_num);
		int no_of_column = row.getLastCellNum();
		wb.close();
		fi.close();
		
		return no_of_column;
		
	}
	
	//read cell values
	public static String getColumnData(String xlfile, String xlsheet, int row_num, int col_num) throws Exception{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(row_num);
		col = row.getCell(col_num);
		String data;
		
		try {
			
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(col);
			
			return cellData;
		}catch(Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		
		return data;
	}
	
	//set Column Value
	public static void setColumnValue(String xlfile, String xlsheet, int row_num, int col_num, String col_val) throws Exception{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(row_num);
		col = row.createCell(col_num);
		col.setCellValue(col_val);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
}
