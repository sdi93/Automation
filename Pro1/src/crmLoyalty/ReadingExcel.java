package crmLoyalty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	public static List<String>  readfile(String filepath, String filename, String sheetname) throws IOException
	{
		List<String> list = new ArrayList<String>();
	    File file = new File(filepath+ "/"+filename);
	    FileInputStream fis = new FileInputStream(file);

	    // for creating .xlsx workbook
	    Workbook wb = new XSSFWorkbook(fis);

	    // for reading the sheet by its name
	    Sheet sh = wb.getSheet(sheetname);

	    //find the total rows in sheet

	    int rowcount = sh.getLastRowNum()-sh.getFirstRowNum();

	    // create a loop to create 

	    for(int i=1;i<rowcount+1;i++)
	    {
	        Row row= sh.getRow(i);

	        // create a loop to print cell values

	        for(int j=0;j<row.getLastCellNum();j++)
	        {
	            Cell cell= row.getCell(j);
	            switch (cell.getCellType()) {
	            case Cell.CELL_TYPE_STRING:
	                    System.out.print(row.getCell(j).getStringCellValue() + " ");
	                    list.add(row.getCell(j).getStringCellValue());
	                    break;

	            case Cell.CELL_TYPE_NUMERIC:
	                    System.out.print(row.getCell(j).getNumericCellValue() + " ");
	                    String s = String.valueOf(row.getCell(j).getNumericCellValue());
	                    
	                  
	                    list.add(s);
	                    break;
	            }
	            System.out.print(row.getCell(j).getStringCellValue()+"||");

	        }


	    System.out.println();
	    }


	   
	System.out.println("ArrayList Size is : " + list.size());
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
	return list;

}
}
