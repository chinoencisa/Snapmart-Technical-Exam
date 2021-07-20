package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourBasketPage {

WebDriver ldriver;
	
	public YourBasketPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//h1")
	public WebElement yourbasketname;
	
	@FindBy(xpath="//mat-cell[@class=\"mat-cell cdk-cell cdk-column-price mat-column-price ng-star-inserted\"]")
	public WebElement price;
	
	@FindBy(xpath="//mat-cell[@class=\"mat-cell cdk-cell content-align cdk-column-quantity mat-column-quantity ng-star-inserted\"]/span")
	public WebElement quantity;
	
	@FindBy(xpath="//button[@id=\"checkoutButton\"]")
	public WebElement checkoutBTN;
	
	
}
