package MyStorePageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CustomersDataConfig {
    
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public static int rowCount;
	public CustomersDataConfig(String excelPath) {
		
		    try {
				File src = new File(excelPath);

				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
				//sheet = wb.getSheetAt(0);
			  rowCount = sheet.getLastRowNum();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
		
	}
	
	  public String getCustomers(int row,int column) {
		  sheet = wb.getSheetAt(0);
		  DataFormatter formatter = new DataFormatter();
		 // String customer = sheet.getRow(row).getCell(column).getStringCellValue();
		 // DataFormatter formatter = new DataFormatter();
		  String val = formatter.formatCellValue(sheet.getRow(row).getCell(column));	 
		  return val;
	  }
}
