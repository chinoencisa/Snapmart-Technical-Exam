package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
WebDriver ldriver;
	
	public ProductsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//div[contains(text(),\"All Products\")]")
	public WebElement allProductsTXT;
	
	@FindBy(xpath="//div[contains(text(),\" 20th Anniversary Celebration Ticket \")]/../parent::div/following-sibling::div/button")
	public WebElement ITanniversary;
	
	@FindBy(xpath="//div[contains(text(),\" 20th Anniversary Celebration Ticket \")]/following-sibling::div/span")
	public WebElement ITanniversaryPrice;
	
	@FindBy(xpath="//div[contains(text(),\"Apple Juice\")]/../parent::div/following-sibling::div/button")
	public WebElement ITapplejuice;
	
	@FindBy(xpath="//div[contains(text(),\"Apple Pomace\")]/../parent::div/following-sibling::div/button")
	public WebElement ITapplepomace;
	
	@FindBy(xpath="//div[contains(text(),\"Banana Juice\")]/../parent::div/following-sibling::div/button")
	public WebElement ITbananajuice;
	
	@FindBy(xpath="//div[contains(text(),\"Best\")]/../parent::div/following-sibling::div/button")
	public WebElement ITbestjuice;
	
	@FindBy(xpath="//div[contains(text(),\"Carrot\")]/../parent::div/following-sibling::div/button")
	public WebElement ITcarrot;

	@FindBy(xpath="//div[contains(text(),\"Eggfruit\")]/../parent::div/following-sibling::div/button")
	public WebElement ITeggfruit;
	
	@FindBy(xpath="//div[contains(text(),\"Press\")]/../parent::div/following-sibling::div/button")
	public WebElement ITfruitpress;

	@FindBy(xpath="//span[contains(text(),\"Your\")]")
	public WebElement ITyourbasket;
	
	
	

}
