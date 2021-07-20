package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	WebDriver ldriver;
	
		public AddressPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//span[contains(text(),\"Add New Address\")]")
		public WebElement addNewAddressBTN;
		
		@FindBy(xpath="//mat-label[contains(text(),\"Country\")]/parent::label/parent::span/parent::div/input")
		public WebElement countryTXT;
		
		@FindBy(xpath="//mat-label[contains(text(),\"Name\")]/parent::label/parent::span/parent::div/input")
		public WebElement nameTXT;
		
		@FindBy(xpath="//mat-label[contains(text(),\"Mobile Number\")]/parent::label/parent::span/parent::div/input")
		public WebElement mobilenumberTXT;
		
		@FindBy(xpath="//mat-label[contains(text(),\"ZIP Code\")]/parent::label/parent::span/parent::div/input")
		public WebElement zipcodeTXT;
		
		@FindBy(xpath="//mat-label[contains(text(),\"Address\")]/parent::label/parent::span/parent::div/textarea")
		public WebElement addressTXT;
		
		@FindBy(xpath="//mat-label[contains(text(),\"City\")]/parent::label/parent::span/parent::div/input")
		public WebElement cityTXT;
		
		@FindBy(xpath="//mat-label[contains(text(),\"State\")]/parent::label/parent::span/parent::div/input")
		public WebElement stateTXT;
		
		@FindBy(xpath="//button[@id=\"submitButton\"]")
		public WebElement submitBTN;
		
		@FindBy(xpath="//mat-radio-button[@class=\"mat-radio-button mat-accent\"]")
		public WebElement radioBTN;
		
		@FindBy(xpath="//span[contains(text(),\"Continue\")]")
		public WebElement continueBTN;
		
		
		
		
		
}
