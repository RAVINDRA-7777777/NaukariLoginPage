package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import TestBase.BaseClass;
import pageObjects.LoginDetails;
import pageObjects.UpdateProfile;
import pageObjects.HomePagee;

public class TC002LoginWebPage extends BaseClass {
	
	@Test
	public void Login() throws InterruptedException
	{
		logger.info("***** Starting TC002_LoginWebPagestarts  ****");
		logger.debug("This is a debug log message");
		try {
		HomePagee hp=new HomePagee(driver);
		hp.LoginBtn();
		
		LoginDetails ld=new LoginDetails(driver);
		ld.UserName2();
		ld.Password2();
		ld.HomepageSubmit();
		logger.info("***** Login WebPage Successful  ****");
		 // Validate successful login

       UpdateProfile up=new UpdateProfile(driver);
		up.EditProfile();
		up.EditIcon();
		up.UpdateName2(); 
		
		up.saveBtn();
		logger.info("***** Updated details successfully  ****");
		

	       try {
	            Thread.sleep(5000); // Wait for page to load
	            String confmsg=ld.getConfirmationMsg();
	    		Assert.assertEquals(confmsg, "Ravindra Babu Kota");
	            System.out.println("Login successful!");
	            
	        } catch (Exception e) {
	            Assert.fail("Login failed! Exception: " + e.getMessage());
	        }
			ld.ProfileIcon();
			ld.Logout();
			
		}catch(Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}
	     finally
	     {
	    	 logger.info("***** Finished TC002_LoginWebPageTest   ****");
	     }
	      
	}
	

}
