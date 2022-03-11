package finalChecking;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPage1 {
	
	public WebDriver driver;
	public String LandingPageproductName;
	public String offerPageProdctName;
	TestContextSetup testContextSetup;
	LandingPage landingpage;
	

	public LandingPage1(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	    this.landingpage =testContextSetup.pageobjectmanager.getLandingPage();
		
	}
	
	@Given("^User is on GreenCart Landing Page$")
	public void user_is_on_greencart_landing_page() 
	{
		//testContextSetup.testbase.WebDriverManager();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver\\chromedriver.exe");
		//testContextSetup.driver = new ChromeDriver(); 
		//testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	
	 Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User Searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws InterruptedException 
	{
		//System.out.println(shortName);
		//landingpage = new LandingPage(testContextSetup.driver);
		//landingpage.searchItem(shortName);
		//Thread.sleep(4000);	
		//LandingPageproductName=landingpage.getProductName().split("-")[0].trim();
		// System.out.println(LandingPageproductName +" :is extract from Homepage");

	    
	    System.out.println(shortName);
	   // LandingPage landingpage =testContextSetup.pageobjectmanager.getLandingPage();
		landingpage.searchItem(shortName);
		Thread.sleep(4000);	
		testContextSetup.LandingPageproductName=landingpage.getProductName().split("-")[0].trim();
	    System.out.println(	testContextSetup.LandingPageproductName +": is extract from Homepage");
	}

	
	@When("Added {string} items of the selected product to cart")
    public void added_something_items_of_the_selected_product_to_cart(String quantity)
	{
		landingpage.Increment(Integer.parseInt(quantity));
		landingpage.AddToCart();
    }

}
