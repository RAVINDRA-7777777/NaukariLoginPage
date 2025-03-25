package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;
import TestBase.BaseClass;
import pageObjects.HomePagee;
import pageObjects.LoginDetails;

public class TC003WriteDataToExcel extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)

	public void Login(String email, String password, String exp) throws InterruptedException{
		

		logger.info("***** Starting TC003WriteDataToExcel ****");
		logger.debug("This is a debug log message");
		try {
			
			HomePagee hp=new HomePagee(driver);
			hp.LoginBtn();
			
			LoginDetails ld=new LoginDetails(driver);
			ld.setUserName1(email);
			ld.setPassword1(password);
			ld.HomepageSubmit();
			logger.info("***** Login WebPage Successful  ****");
			Thread.sleep(3000); // Wait for page to load
	        boolean confmsg=ld.isMyAccountPageExists();   
	          
	        
	        if(exp.equalsIgnoreCase("Valid"))
			{
				if(confmsg==true)
				{
					
					ld.ProfileIcon();
					ld.Logout();
					String loginMessage = "Login successful!";
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(confmsg==true)
				{	
					ld.ProfileIcon();
					ld.Logout();
					
					Assert.assertTrue(false);
				}
				else
				{	String loginMessage = "Login Unsuccessful!";
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}
	     finally
	     {
	    	 logger.info("***** Finished TC003WriteDataToExcel ****");
	     }		
		
	}
}
