package com.fishbowl.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
	
	public static List<String> readExcelList(String filePath, String fileName, String sheetName) throws IOException
	{
		List<String> list = new ArrayList<String>();
	
		File file = new File(filePath + "/" + fileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook testWorkbook = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
	
		if (fileExtensionName.equals(".xlsx")) 
		{
			testWorkbook = new XSSFWorkbook(inputStream);
		}

		else if (fileExtensionName.equals(".xls"))
		{
			testWorkbook = new HSSFWorkbook(inputStream);
		}

		Sheet testSheet = testWorkbook.getSheet(sheetName);

		int rowCount = testSheet.getLastRowNum() - testSheet.getFirstRowNum();

		for (int excelrow = 1; excelrow < rowCount + 1; excelrow++)
		{
			Row row = testSheet.getRow(excelrow);
			int numtype=Cell.CELL_TYPE_NUMERIC;
			 int stringtype=Cell.CELL_TYPE_STRING;
			 
			for (int excelcol = 0; excelcol < row.getLastCellNum(); excelcol++)
			{
					String cellvalue = null ;
					Cell cell= row.getCell(excelcol);
				 	int celltype = cell.getCellType();
				 	if (celltype == stringtype)
				 	{
				 		cellvalue=cell.getStringCellValue();
				 		System.out.println(cellvalue);
					}
				 	else if (celltype==numtype)
				 	{
					    Double val_dbl=cell.getNumericCellValue();
					    Integer  val_int=val_dbl.intValue();
					    cellvalue=String.valueOf(val_int);    
					}
				
				list.add(cellvalue);
			}
		}
		System.out.println("ArrayList Size is : " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		 inputStream.close();
		return list;

	}
	
	public static void writeExcel(String filePath, String fileName, String sheetName, int rowNum,int colNum,String value) throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		File file = new File(filePath + "/" + fileName);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook testWorkbook =  null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			testWorkbook = new XSSFWorkbook(inputStream);
		}

		else if (fileExtensionName.equals(".xls")) {

			testWorkbook = new HSSFWorkbook(inputStream);
		}

		Sheet worksheet = testWorkbook.getSheet(sheetName);
		           
         Cell cell = null; // declare a Cell object
         
         cell = worksheet.getRow(rowNum).getCell(colNum);   // Access the second cell in second row to update the value
           
         cell.setCellValue(value);  // Get current cell value value and overwrite the value
           
         inputStream.close(); //Close the InputStream
          
         FileOutputStream output_file =new FileOutputStream(file);  //Open FileOutputStream to write updates
           
         testWorkbook.write(output_file); //write changes
           
         output_file.close();  //close the stream    


	}
	
}
