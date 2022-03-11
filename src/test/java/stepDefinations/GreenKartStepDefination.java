package stepDefinations;


import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GreenKartStepDefination {

	public WebDriver driver;
	public String LandingPageproductName;
	public String offerPageProdctName;


	@Given("^User is on GreenCart Landing Page$")
	public void user_is_on_greencart_landing_page() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("User Searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws InterruptedException
	{
		//input[@placeholder='Search for Vegetables and Fruits']
		System.out.println(shortName);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(4000);
		LandingPageproductName =driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
	    System.out.println(LandingPageproductName +"is extract from Homepage");
	}

	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName)

	{
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1= s1.iterator();
		String parentWindow= i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	
		offerPageProdctName=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		
		System.out.println(offerPageProdctName);

	}
	@And("^Valiate product name in offers page matches with Landing Page$")
     public void Valiate_product_name_in_offers_page_matches_with_Landing_Page() 
	{
		Assert.assertEquals(offerPageProdctName, LandingPageproductName);
		System.out.println("It's Working Perfectly");
	}
}
