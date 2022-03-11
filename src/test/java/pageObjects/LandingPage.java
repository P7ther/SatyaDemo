package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
		
	By Search = By.xpath("//input[@type='search']");
    By ProductName = By.cssSelector("h4.product-name");
    By TopDeal=By.linkText("Top Deals");
    By increment =By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");
	
    public void searchItem(String name) 
    {
    	driver.findElement(Search).sendKeys(name);
    }

    public void getSearchText() 
    {
    	driver.findElement(Search).getText();
    }

    public String getProductName() 
    {
    	return driver.findElement(ProductName).getText();

    }
    
    public void Increment(int quantity ) 
    {
      int i = quantity-1;
      while(i>0) 
      {
    	  driver.findElement(increment).click();
    	  i--;
      }
    }
    
    public void AddToCart() 
    {
    	driver.findElement(addToCart).click();
    }
    
    public void selectTopDeal() 
    {
    	driver.findElement(TopDeal).click();
    }

    public String getTitleLandingPage() 
    {
    	return driver.getTitle();
    }
}
