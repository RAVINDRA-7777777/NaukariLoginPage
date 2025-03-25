package testCases;

import org.testng.annotations.Test;

import utilities.DataProviders;
import org.testng.Assert;
import TestBase.BaseClass;
import pageObjects.LoginDetails;
import pageObjects.HomePagee;

public class TC001LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void Login(String email, String password, String exp) throws InterruptedException
	{	
		
		
		
		logger.info("***** Starting TC001_LoginDDT  ****");
		logger.debug("This is a debug log message");
		try {
		HomePagee hp=new HomePagee(driver);
		hp.LoginBtn();
		
		LoginDetails ld=new LoginDetails(driver);

		
//		ld.setUserName1(p.getProperty("email"));
//		ld.setPassword1(p.getProperty("password"));
		
		ld.setUserName1(email);
		ld.setPassword1(password);
		ld.HomepageSubmit();
		logger.info("***** Login WebPage Successful  ****");
		 // Validate successful login
//
//       UpdateProfile up=new UpdateProfile(driver);
//		up.EditProfile();
//		up.EditIcon();
//		up.UpdateName1(); 
//		
//		up.saveBtn();
//		logger.info("***** Updated details successfully  ****");
//		
//

	            Thread.sleep(3000); // Wait for page to load
	           boolean confmsg=ld.isMyAccountPageExists();   
	           System.out.println("Login successful!");
	            
			
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(confmsg==true)
				{
					ld.ProfileIcon();
					ld.Logout();
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
				{
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}
	     finally
	     {
	    	 logger.info("***** Finished TC001_LoginDDT   ****");
	     }
	      
	}
	

}
