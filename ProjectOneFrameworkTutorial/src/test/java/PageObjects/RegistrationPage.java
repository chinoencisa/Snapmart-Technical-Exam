package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver ldriver;
	
	public RegistrationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	
	@FindBy(xpath="//input[@id=\"emailControl\"]")
	public WebElement emailTXT;
	
	@FindBy(xpath="//input[@id=\"passwordControl\"]")
	public WebElement passwordTXT;
	
	@FindBy(xpath="//input[@id=\"repeatPasswordControl\"]")
	public WebElement repeatpasswordTXT;
	
	@FindBy(xpath="//input[@id=\"securityAnswerControl\"]")
	public WebElement securityquestionDD;
	
	@FindBy(xpath="//mat-select[@id=\"mat-select-2\"]")
	public WebElement securityQuestion;
	
	@FindBy(xpath="//input[@id=\"securityAnswerControl\"]")
	public WebElement securityAnswer;

	@FindBy(xpath="//button[@id=\"registerButton\"]")
	public WebElement registerBTN;
	

}
