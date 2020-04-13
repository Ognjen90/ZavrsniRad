package MyStorePageObject;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class RegisterCustomers {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

		CustomersDataConfig customers = new CustomersDataConfig("C:\\Users\\user\\Desktop\\Customers.xlsx");
		System.out.println(customers.getCustomers( 1, 13));
//		File src = new File("C:\\Users\\user\\Desktop\\Customers.xlsx");
//		
//		FileInputStream fis = new FileInputStream(src);
//		
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheetAt(0);
////		String customer1 = sheet.getRow(1).getCell(0).getStringCellValue() + " "+sheet.getRow(1).getCell(1).getStringCellValue();
////		System.out.println(customer1);
//		int rowCount = sheet.getLastRowNum();
//		System.out.println("total row is" + rowCount);
//		for(int i = 0;i<rowCount;i++) {
//			sheet.getRow(i).getCell(0).getStringCellValue();
//		}
		//wb.close();
		
	}

}
