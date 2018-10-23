package com.admin.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.admin.base.TestBase;

public class ReadExcel extends TestBase
{
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public ReadExcel(String filepath, int sheetNumber)
	{
		try 
		{
			fis =new FileInputStream(filepath);
			wb = new XSSFWorkbook(fis);
			sheet=wb.getSheetAt(sheetNumber);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
	/*public String readData (int rowNum, int colNum)
	{
		row = sheet.getRow(rowNum);
		cell= row.getCell(colNum);
		String data;
		
		data = cell.getStringCellValue();
		
			
	*/	}
		
	