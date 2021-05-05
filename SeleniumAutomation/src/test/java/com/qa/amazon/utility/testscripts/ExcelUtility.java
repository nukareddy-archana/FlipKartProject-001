package com.qa.amazon.utility.testscripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	public static FileInputStream fileLoc;
	public static XSSFWorkbook wBook;
	public static XSSFSheet wSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	//get row count
	
	public static int getRowCount(String xFile,String xSheet) throws IOException
	{
		
		fileLoc=new FileInputStream(xFile);
		wBook=new XSSFWorkbook(fileLoc);
		wSheet=wBook.getSheet(xSheet);
		
		int rowCount=wSheet.getLastRowNum();
		wBook.close();
		
		return rowCount;
		
	}
	
	//get the cell count of each row
	public static int getCellCount(String xFile,String xSheet,int rowNum) throws IOException
	{
		
		fileLoc=new FileInputStream(xFile);
		wBook=new XSSFWorkbook(fileLoc);
		wSheet=wBook.getSheet(xSheet);
		
		row=wSheet.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		
		
		wBook.close();
		fileLoc.close(); 
		return cellCount;
		
	}
	
	public static String getCellData(String xFile,String xSheet,int rowNum,int colNum) throws IOException
	{
		fileLoc=new FileInputStream(xFile);
		wBook=new XSSFWorkbook(fileLoc);
		wSheet=wBook.getSheet(xSheet);
		
		
		row=wSheet.getRow(rowNum);
		cell=row.getCell(colNum);
		DataFormatter formatter=new DataFormatter();
		
		String cellData= formatter.formatCellValue(cell);
		
		wBook.close();
		fileLoc.close();
		
		return cellData;
	}

}
