package testCases;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePagee;
import pageObjects.LoginDetails;

import java.io.*;

public class TC003ExcelLoginTest extends BaseClass{

    //String excelFilePath = "TestData.xlsx";
    String excelFilePath=".\\testData\\ReadAndWriteData.xlsx";

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedResult, int rowNum) {


    	logger.info("***** Starting TC001_LoginDDT  ****");
		logger.debug("This is a debug log message");
		try {
		HomePagee hp=new HomePagee(driver);
		hp.LoginBtn();
		
		LoginDetails ld=new LoginDetails(driver);
		
		ld.setUserName1(username);
		ld.setPassword1(password);
		ld.HomepageSubmit();
		logger.info("***** Login WebPage Successful  ****");

        // Capture login success or failure message
        String actualResult = "";
        try {
        	WebElement successMsg = driver.findElement(By.xpath="//a[@class='nI-gNb-header__logo nI-gNb-company-logo']//img[@alt='Naukri Logo']");
            actualResult = successMsg.getText();
        } catch (Exception e) {
            actualResult = "Login Failed";
        }

        // Validate and store result
        boolean status = actualResult.equals(expectedResult);
        String testStatus = status ? "PASS" : "FAIL";

        // Write results back to Excel
        writeResultToExcel(rowNum, actualResult, testStatus);

        // Validate test
        Assert.assertEquals(actualResult, expectedResult);

     
    }catch(Exception e) {
		logger.error("Test failed: " + e.getMessage());
		Assert.fail("Test failed: " + e.getMessage());
	}
     finally
     {
    	 logger.info("***** Finished TC001_LoginDDT   ****");
     }
		
    }		
		
    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][4];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue();  // Username
            data[i - 1][1] = row.getCell(1).getStringCellValue();  // Password
            data[i - 1][2] = row.getCell(2).getStringCellValue();  // Expected Result
            data[i - 1][3] = i;  // Row number (to update results)
        }

        workbook.close();
        fis.close();
        return data;
    }

    public void writeResultToExcel(int rowNum, String actualResult, String status) {
        try {
            FileInputStream fis = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            fis.close();

            // Write the actual result and test status
            Row row = sheet.getRow(rowNum);
            row.createCell(3).setCellValue(actualResult);
            row.createCell(4).setCellValue(status);

            FileOutputStream fos = new FileOutputStream(excelFilePath);
            workbook.write(fos);
            fos.close();
            workbook.close();

            System.out.println("Updated Excel: Row " + rowNum + " with " + actualResult + " - " + status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
