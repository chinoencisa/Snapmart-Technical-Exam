package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import PageObjects.YourBasketPage;

public class TC_CreateOrder extends Base 
{
	public static String price;
	
	@Test
	public void LoginTest() throws InterruptedException, IOException 
	{
		
		ProductsPage PP=new ProductsPage (driver);
		LoginPage lp=new LoginPage (driver);
		
		lp.dismissBTN.click();
		lp.mewantitBTN.click();
		lp.accountBTN.click();
		lp.loginNavBar.click();
		assertTrue(lp.loginTXT.isDisplayed(),"loginTXT field is NOT displayed");
		System.out.println("LoginTXT is displayed");
		
		lp.emailTXT.sendKeys(email);
		lp.passwordTXT.sendKeys(password);
		lp.loginBTN.click();Thread.sleep(2000);
		
		if(PP.allProductsTXT.isDisplayed()) {
			captureScreenPass(driver,"LoginTest");
			System.out.println("LoginTest is passed");
		}else {
			captureScreenFail(driver,"LoginTest");
			System.out.println("LoginTest is failed");
		}
		
		
	}
	

	@Test (dependsOnMethods ="LoginTest")
	public void SelectProduct() throws InterruptedException, IOException 
	{
		
		ProductsPage PP=new ProductsPage (driver);
		YourBasketPage YB=new YourBasketPage(driver);
			
		price = PP.ITanniversaryPrice.getAttribute("innerText");
		System.out.println(price);
		
		PP.ITanniversary.click();Thread.sleep(1000);
		PP.ITyourbasket.click();Thread.sleep(1000);
		System.out.println("Your Basket Page is displayed");Thread.sleep(2000);
			
		
		assertTrue(YB.quantity.isDisplayed(),"quantity field is missing");
		assertTrue(YB.price.isDisplayed(),"price field is missing");
		
		System.out.println((YB.quantity.getAttribute("innerText")));
		System.out.println((YB.price.getAttribute("innerText")));	

		assertTrue(YB.quantity.getAttribute("innerText").equals("1"),"quantity is incorrect");
		assertTrue(YB.price.getAttribute("innerText").equals(price),"price is incorrect");
		
		if(YB.price.getAttribute("innerText").equals(price)) {
			captureScreenPass(driver,"SelectProduct");
			System.out.println("SelectProduct is passed");
		}else {
			captureScreenFail(driver,"SelectProduct");
			System.out.println("SelectProduct is failed");
		}
		
		YB.checkoutBTN.click();

	}
	
	
	@Test (dependsOnMethods ="SelectProduct")
	public void Address() throws InterruptedException, IOException 
	{
		AddressPage AP=new AddressPage (driver);
		DeliveryPage DP=new DeliveryPage (driver);
		PaymentPage PayP=new PaymentPage (driver);
		
		AP.addNewAddressBTN.click();Thread.sleep(2000);
		AP.countryTXT.sendKeys(country);
		AP.nameTXT.sendKeys(name);
		AP.mobilenumberTXT.sendKeys(mobilenumber);
		AP.zipcodeTXT.sendKeys(zipcode);
		AP.addressTXT.sendKeys(address);
		AP.cityTXT.sendKeys(city);
		AP.stateTXT.sendKeys(state);
		AP.submitBTN.click();Thread.sleep(2000);
		AP.radioBTN.click();
		AP.continueBTN.click();Thread.sleep(2000);
		
		
		assertTrue(DP.verNameTXT.getAttribute("innerText").equals(name),"verNameTXT is incorrect");
		assertTrue(DP.verfullAddress.getAttribute("innerText").equals(address + ", " + city + ", " + state + ", " + zipcode),"verfullAddress is incorrect");
		assertTrue(DP.verCountry.getAttribute("innerText").equals(country),"verCountry is incorrect");
		assertTrue(DP.verPhoneNumber.getAttribute("innerText").equals("Phone Number " + mobilenumber),"verPhoneNumber is incorrect");
		System.out.println("Assertions are passed");
		
		
		if (deliverytype.equals("1")) {
			DP.oneDayDeliveryRadioBTN.click();
		}
	
		DP.continueBTN.click();Thread.sleep(2000);
		
		if(PayP.paymentCard.isDisplayed()) {
			captureScreenPass(driver,"Address");
			System.out.println("Address is passed");
		}else {
			captureScreenFail(driver,"Address");
			System.out.println("Address is failed");
		}
	
	}
	
	@Test (dependsOnMethods ="Address")
	public void Payment() throws InterruptedException, IOException 
	{
		PaymentPage PayP=new PaymentPage (driver);
		
		PayP.paymentCard.click();Thread.sleep(2000);
		PayP.paymentCardNameTXT.sendKeys(name);
		PayP.paymentCardNumberTXT.sendKeys("1234567890123456");
		PayP.paymentCardMonth.sendKeys("3");
		PayP.paymentCardYear.sendKeys("2080");
		PayP.paymentSubmitBTN.click(); Thread.sleep(2000);
		PayP.paymentCardRadioBTN.click();
		PayP.paymentContinueBTN.click();Thread.sleep(2000);
		
		PayP.placeorderBTN.click();Thread.sleep(2000);
		
		
		System.out.println((PayP.ordersummaryTitle.getAttribute("innerText")));
		System.out.println((PayP.OSproductname.getAttribute("innerText")));
		System.out.println((PayP.OSproductprice.getAttribute("innerText")));
		System.out.println((PayP.OSproductquantity.getAttribute("innerText")));
		
		
		assertTrue(PayP.ordersummaryTitle.getAttribute("innerText").equals("Thank you for your purchase!"),"ordersummaryTitle is incorrect");
		assertTrue(PayP.OSproductname.getAttribute("innerText").equals("20th Anniversary Celebration Ticket"),"OSproductname is incorrect");
		assertTrue(PayP.OSproductprice.getAttribute("innerText").equals(price),"OSproductprice is incorrect");
		assertTrue(PayP.OSproductquantity.getAttribute("innerText").equals("1"),"OSproductquantity is incorrect");
		assertTrue(PayP.OSproductPricing.getAttribute("innerText").equals(price),"OSproductquantity is incorrect");
		
	}

}
 