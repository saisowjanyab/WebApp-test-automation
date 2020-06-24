package com.encodedrive;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.encode.*;

public class maintest {

public static void main (String[] args) throws Exception  {
try
{
	Func temp=new Func();
		
		String excelFilePath = "cs.xlsx";
	       FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	        
	       Workbook workbook = new XSSFWorkbook(inputStream);
	       Sheet sheet  = workbook.getSheetAt(0); // Get Your Sheet.

	       for (Row row : sheet) { // For each Row.
	           Cell cell = row.getCell(0);
	           System.out.println(cell.getStringCellValue());
	           if((cell.getStringCellValue()).equals("LOGIN_TEST"))
	        	   
	           {   
	        	   temp.setUp();
	        	   temp.logiout(row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue());
	               temp.tearDown();
	             
	           }
	           else if((cell.getStringCellValue()).equals("TOURBOOKING_TEST"))
	           {    temp.setUp();
	              
	        	   temp.testSss();
	        	   temp.tearDown();
	        	  
	           }
	           else if((cell.getStringCellValue()).equals("OFFER_TEST"))
	           {
	        	   temp.setUp();
	        	   temp.offersTest(row.getCell(1).getStringCellValue());
	        	   temp.tearDown();
	           }
	           
	       }
	    workbook.close();
}
	        
catch (Exception e)
{
	    }
finally {
	Func temp=new Func();
	   temp.setUp();
       temp.viewReport();
}
}

}


