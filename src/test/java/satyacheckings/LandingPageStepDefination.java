	package satyacheckings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefination {
	
	
	public WebDriver driver;
	public String LandingPageproductName;
	public String offerPageProdctName;
	TestContextSetup testContextSetup;
	

	public LandingPageStepDefination(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
		
	}
	
	@Given("^User is on GreenCart Landing Page$")
	public void user_is_on_greencart_landing_page() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver\\chromedriver.exe");
		testContextSetup.driver = new ChromeDriver(); 
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");		
	}

	@When("User Searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws InterruptedException 
	{
		//input[@placeholder='Search for Vegetables and Fruits']
		System.out.println(shortName);
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(4000);	
		//LandingPageproductName =testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		testContextSetup.LandingPageproductName=testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	    System.out.println(LandingPageproductName +"is extract from Homepage");
	}


}
