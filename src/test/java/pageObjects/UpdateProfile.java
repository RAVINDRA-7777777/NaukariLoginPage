package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateProfile extends BasePage {
	
	public UpdateProfile(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='view-profile-wrapper']")
	WebElement btnprofile;
	
	@FindBy(xpath="//em[@class='icon edit ']")
	WebElement btnEditIcon;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement txtName;
	
	@FindBy(id="saveBasicDetailsBtn")WebElement save;
	
	
	
	public void EditProfile()
	{
		btnprofile.click();
	}
	
	public void EditIcon() throws InterruptedException
	{
		btnEditIcon.click();
		Thread.sleep(1000);
	}
	
	public void UpdateName1()
	{
		txtName.click();
		txtName.clear();
		txtName.sendKeys("Ravindra Babu Kota");
	}
	public void UpdateName2()
	{
		txtName.click();
		txtName.clear();
		txtName.sendKeys("Ravindra Babu Kota");//Nikhil Teja Thammishetti
	}
	public void saveBtn() throws InterruptedException
	{
		save.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class=\"nI-gNb-header__logo nI-gNb-company-logo\"]//img[@href=\"https://www.naukri.com\"]")).click();
	
	}

	
		
	
	
	
}
