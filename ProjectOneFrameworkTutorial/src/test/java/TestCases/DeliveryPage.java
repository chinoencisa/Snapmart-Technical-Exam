package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryPage {
	WebDriver ldriver;
	
	public DeliveryPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class=\"addressCont ng-star-inserted\"]//div[1]")
	public WebElement verNameTXT;
	@FindBy(xpath="//div[@class=\"addressCont ng-star-inserted\"]//div[2]")
	public WebElement verfullAddress;
	@FindBy(xpath="//div[@class=\"addressCont ng-star-inserted\"]//div[3]")
	public WebElement verCountry;
	@FindBy(xpath="//div[@class=\"addressCont ng-star-inserted\"]//div[4]")
	public WebElement verPhoneNumber;
	
	@FindBy(xpath="//mat-row[1]//mat-radio-button[@class=\"mat-radio-button mat-accent\"]")
	public WebElement oneDayDeliveryRadioBTN;
	
	@FindBy(xpath="//span[contains(text(),\"Continue\")]")
	public WebElement continueBTN;
}
