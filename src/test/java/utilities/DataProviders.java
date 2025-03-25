package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
/*	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
				if(j==3)
				{
				logindata[i-1][j]= xlutil.setCellData("Sheet1",i, j);
				}
			}
			
		}
	return logindata;//returning two dimension array
				
	}
*/	
	//DataProvider 2
//	 @DataProvider(name = "loginData")
//	    public Object[][] getData() throws IOException {
//		 String path=".\\testData\\ReadAndWriteData.xlsx";
//	        FileInputStream fis = new FileInputStream(path);
//	        Workbook workbook = new XSSFWorkbook(fis);
//	        Sheet sheet = workbook.getSheet("Sheet1");
//
//	        int rowCount = sheet.getLastRowNum();
//	        Object[][] data = new Object[rowCount][4];
//
//	        for (int i = 1; i <= rowCount; i++) {
//	            Row row = sheet.getRow(i);
//	            data[i - 1][0] = row.getCell(0).getStringCellValue();  // Username
//	            data[i - 1][1] = row.getCell(1).getStringCellValue();  // Password
//	            data[i - 1][2] = row.getCell(2).getStringCellValue();  // Expected Result
//	            data[i - 1][3] = i;  // Row number (to update results)
//	        }
//
//	        workbook.close();
//	        fis.close();
//	        return data;
//	    }
}

	//DataProvider 3
	
	//DataProvider 4
	 
	 

