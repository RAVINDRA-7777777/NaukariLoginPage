package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginDetails extends BasePage {
	
	public LoginDetails(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[@class='nI-gNb-header__logo nI-gNb-company-logo']//img[@alt='Naukri Logo']")
	WebElement msgConfirmation;
	
	@FindBy(xpath = "//div[@class=\"name-wrapper\"]")
	WebElement msgConfirmation1;
	
	
	@FindBy(xpath="//img[@alt='naukri user profile img']")
	WebElement btnPrfIcon;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement btnLgout;
	
	
	public void setUserName1(String email)
	{
		txtUserName.sendKeys(email);
	}
	public void setPassword1(String pwd)
	{
		txtPassword.sendKeys(pwd);
			
	}
	public void UserName2()
	{
		txtUserName.sendKeys("kotaravindrababu87@gmail.com");//nikhilteja856@gmail.com
	}
	public void Password2()
	{
		txtPassword.sendKeys("Qwerty@0143");//nikhil123
			
	}
	public void HomepageSubmit()
	{
		btnSubmit.click();
	}
	
	
	
	public WebElement successMsg()   // MyAccount Page heading display status
	{
		return msgConfirmation;
	}
	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgConfirmation.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation1.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
	
	public void ProfileIcon()
	{
		btnPrfIcon.click();
	}
	
	public void Logout()
	{
		btnLgout.click();
	}
}
