
package com.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ReadExcel
{
	
	//This class will have all the methods to deal with Excel

	
	public static String[][] readData(String workbook, String sheet)
	{
		    String[][] data = null;
		    try {
		        FileInputStream fis = new FileInputStream(GlobalConstant.readFilePath +workbook);
		        		
				@SuppressWarnings("resource")
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				
				for (int i = 0; i < wb.getNumberOfSheets(); i++)
				{
				    String sheetName = wb.getSheetName(i);
				    System.out.println("Sheet Name: " + sheetName);
				    }
				
		        XSSFSheet sh = wb.getSheet(sheet);
		       
		        if (sh == null) {
		            throw new IllegalArgumentException("Sheet '" + sheet + "' not found in the workbook.");
		        }

		        int totalrows = sh.getPhysicalNumberOfRows();
		        int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
		        data = new String[totalrows - 1][totalColumns];

		       
		        for (int i = 1; i < totalrows; i++) 
		        {
		            for (int j = 0; j < totalColumns; j++)
		            {
		                XSSFCell cell = sh.getRow(i).getCell(j);
		                if (cell != null)
		                {
		                    if (cell.getCellType() == CellType.NUMERIC)
		                    {
		                        // If the cell type is numeric, convert it to text
		                        data[i - 1][j] = NumberToTextConverter.toText(cell.getNumericCellValue());
		                    }
		                    else 
		                    {
		                        // Check if the column is "Is Active"
		                        if (sh.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("Is Active"))
		                        {
		                            data[i - 1][j] = cell.getStringCellValue(); // For dropdown value, just use the string value
		                        } 
		                        else 
		                        {
		                            data[i - 1][j] = cell.getStringCellValue();
		                        }
		                    }
		                } 
		                else 
		                {
		                    data[i - 1][j] = ""; // Set an empty string for null cells
		                }
		            }
		        }
		    }
		       
		     catch (IOException e) 
		    {
		    	 System.err.println("While Uploading File: "+e);
		       // e.printStackTrace();
		    }
		   

		    return data;
	}
}

	


 