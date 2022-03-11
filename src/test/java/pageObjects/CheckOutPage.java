package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage 
{
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By CartBag=By.cssSelector("[alt='Cart']");
	By CheckOutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");	
	By promoBtn =By.cssSelector(".promoBtn");
	By PlaceOrder=By.xpath("//button[contains(text(),'Place Order')]");	

	public void CheckOutItems() 
	{
		driver.findElement(CartBag).click();
		driver.findElement(CheckOutButton).click();
	}
	public boolean VerifyPromoBtn() 
	{
		return driver.findElement(promoBtn).isDisplayed();
	}

	public boolean VerifyPlaceOrder() 
	{
		return driver.findElement(PlaceOrder).isDisplayed();
	}

}
