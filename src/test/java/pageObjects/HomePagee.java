package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagee extends BasePage{
	
	public HomePagee(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//a[@id='login_Layer']")
	WebElement btnLogin;
	
	
	
	public void LoginBtn()
	{
		btnLogin.click();
	}
	
	
	
	
	
}
