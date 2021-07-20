package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;


public class Base {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String email=readconfig.getEmail();
	public String password=readconfig.getPassword();
	
	public String country=readconfig.getcountry();
	public String name=readconfig.getname();
	public String mobilenumber=readconfig.getmobilenumber();
	public String zipcode=readconfig.getzipcode();
	public String address=readconfig.getaddress();
	public String city=readconfig.getcity();
	public String state=readconfig.getstate();
	public String deliverytype=readconfig.getdeliverytype();
	public String payment=readconfig.getPayment();
	
	public static WebDriver driver;
	
	public static org.apache.log4j.Logger Logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String browser)
	{
		
		Logger = LogManager.getLogger("ProjectOne");
		PropertyConfigurator.configure("Log4j.properties");
	
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver =new ChromeDriver();		
			driver.manage().window().maximize();
			
		}
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown()
	{
//		driver.quit();
	}
	
	
	public void captureScreenPass(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname+"_PASS"+".png");
		FileUtils.copyFile(source,  target);;
		System.out.println("Screenshot taken_captureScreenPass");

	}
	
	public void captureScreenFail(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname+"_PASS"+".png");
		FileUtils.copyFile(source,  target);;
		System.out.println("Screenshot taken_captureScreenFail");
 
	}
	
	
	
	

}
