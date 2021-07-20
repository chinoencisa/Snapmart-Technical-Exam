package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC_LoginTest extends Base
{

	@Test
	public void UserLogin() throws InterruptedException 
	{
		LoginPage lp=new LoginPage (driver);
		
		lp.dismissBTN.click();
		lp.mewantitBTN.click();
		lp.accountBTN.click();
		lp.loginNavBar.click();
		assertTrue(lp.loginTXT.isDisplayed(),"loginTXT field is NOT displayed");
		Logger.info("LoginTXT is displayed");
		
		lp.emailTXT.sendKeys(email);
		lp.passwordTXT.sendKeys(password);
		lp.loginBTN.click();Thread.sleep(2000);
	}
	
	
	
}
