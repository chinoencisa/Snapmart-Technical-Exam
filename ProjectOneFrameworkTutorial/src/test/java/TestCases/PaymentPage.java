package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	WebDriver ldriver;
	
	public PaymentPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//mat-expansion-panel-header[@id=\"mat-expansion-panel-header-0\"]")
	public WebElement paymentCard;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Name\")]/parent::label/parent::span/parent::div/input")
	public WebElement paymentCardNameTXT;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Card\")]/parent::label/parent::span/parent::div/input")
	public WebElement paymentCardNumberTXT;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Expiry Month\")]/parent::label/parent::span/../select")
	public WebElement paymentCardMonth;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Expiry Year\")]/parent::label/parent::span/../select")
	public WebElement paymentCardYear;
	
	@FindBy(xpath="//button[@id=\"submitButton\"]")
	public WebElement paymentSubmitBTN;
	
	@FindBy(xpath="//mat-row[1]//mat-radio-button[@class=\"mat-radio-button mat-accent\"]")
	public WebElement paymentCardRadioBTN;
	
	@FindBy(xpath="//span[contains(text(),\"Continue\")]")
	public WebElement paymentContinueBTN;
	
	@FindBy(xpath="//span[contains(text(),\"Place your order and pay\")]")
	public WebElement placeorderBTN;
	
	@FindBy(xpath="//h1")
	public WebElement ordersummaryTitle;
	
	@FindBy(xpath="//mat-row[1]/mat-cell[1]")
	public WebElement OSproductname;

	@FindBy(xpath="//mat-row[1]/mat-cell[2]")
	public WebElement OSproductprice;

	@FindBy(xpath="//mat-row[1]/mat-cell[3]")
	public WebElement OSproductquantity;
	
	@FindBy(xpath="//mat-row[1]/mat-cell[4]")
	public WebElement OSproductPricing;
	
	@FindBy(xpath="//mat-footer-row//mat-footer-cell[4]//tr[4]/td")
	public WebElement OSproductTotalPrice;
	
}
