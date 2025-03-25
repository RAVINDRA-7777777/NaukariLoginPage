package TestBase;

import java.time.Duration;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver();break;
		default: System.out.println("No matching browser..");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
//		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		   // Close the browser
        if (driver != null) {
            driver.quit();
        }
	}
}