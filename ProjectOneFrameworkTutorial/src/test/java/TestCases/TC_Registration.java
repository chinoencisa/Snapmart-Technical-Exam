package TestCases;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.RegistrationPage;

public class TC_Registration extends Base
{
	
	@Test
	public void UserRegistration() throws InterruptedException
	{
		
		LoginPage lp=new LoginPage (driver);
		RegistrationPage rp=new RegistrationPage (driver);
		
		
		lp.dismissBTN.click();
		lp.mewantitBTN.click();
		lp.accountBTN.click();
		lp.loginNavBar.click();
		assertTrue(lp.loginTXT.isDisplayed(),"loginTXT field is NOT displayed");
		Logger.info("LoginTXT is displayed");
		lp.notyetacustomerTXT.click();
		
		System.out.println("User will be directed to User Registration Page.");
		
		assertTrue(rp.registerBTN.getAttribute("disabled").contains("true"),"registerbutton should be disabled");
		Logger.info("Register BTN is Disabled");
		rp.emailTXT.sendKeys(email);
		rp.passwordTXT.sendKeys(password);
		rp.repeatpasswordTXT.sendKeys(password);
//		rp.securityquestionDD.click();Thread.sleep(2000);
		rp.securityQuestion.sendKeys("Your eldest siblings middle name?");Thread.sleep(2000);
		rp.securityAnswer.sendKeys("Test Purposes");
		rp.registerBTN.click();
		
	}

}
