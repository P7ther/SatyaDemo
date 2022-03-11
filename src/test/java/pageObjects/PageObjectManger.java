package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManger 
{
	public WebDriver driver;
	public OffersPage offerspage;
	public LandingPage landingpage;
	public CheckOutPage checkoutpage;
	
	public PageObjectManger(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPage getLandingPage() 
	{
		
		landingpage= new LandingPage(driver);
		return landingpage;
	}
	
	public OffersPage OffersPage() 
	{
		
		offerspage = new OffersPage(driver);
		return offerspage; 
		
	}
   
	public CheckOutPage getCheckoutPage() 
	{
		checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}
}
