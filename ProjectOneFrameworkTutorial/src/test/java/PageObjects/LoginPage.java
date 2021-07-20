package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),\"Dismiss\")]")
	public WebElement dismissBTN;
	
	@FindBy(xpath="//a[contains(text(),\"Me want it\")]")
	public WebElement mewantitBTN;
	
	@FindBy(xpath="//button[@id=\"navbarAccount\"]")
	public WebElement accountBTN;
	
	@FindBy(xpath="//button[@id=\"navbarLoginButton\"]")
	public WebElement loginNavBar;
	
	@FindBy(xpath="//h1[contains(text(),\"Login\")]")
	public WebElement loginTXT;
	
	@FindBy(xpath="//a[contains(text(),\"Not yet a customer\")]")
	public WebElement notyetacustomerTXT;
	
	@FindBy(xpath="//input[@id=\"email\"]")
	public WebElement emailTXT;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	public WebElement passwordTXT;
	
	@FindBy(xpath="//button[@id=\"loginButton\"]")
	public WebElement loginBTN;
	
	

}
