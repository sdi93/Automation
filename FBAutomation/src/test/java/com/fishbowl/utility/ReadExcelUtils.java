package com.fishbowl.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcelUtils {
	
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	
	public static void setExcelFile(String path, String SheetName) throws Exception
	{
		File f = new File(path);
		FileInputStream ExcelFile = new FileInputStream(f);
		
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
	}
	
	// get the row counts
	public static int rowCount(int sheetIndex)
	{
		int row = ExcelWBook.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
	
	//Read the data from the cell
	public static String getCellData(int RowNum, int ColNum)
	{
		String cellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
		return cellData;
	}
	
}
