package satyacheckings;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDefination {
	
//	public String LandingPageproductName;
	public String offerPageProdctName;
	TestContextSetup testContextSetup;

	
	public OfferPageStepDefination(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}
	
	
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException

	{
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1=testContextSetup.driver.getWindowHandles();
		Iterator<String> i1= s1.iterator();
		String parentWindow= i1.next();
		String childWindow = i1.next();
		testContextSetup.driver.switchTo().window(childWindow);
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(3000);
		testContextSetup.offerPageProdctName=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println("landige page name :"+offerPageProdctName);

	}
	@And("^Valiate product name in offers page matches with Landing Page$")
     public void Valiate_product_name_in_offers_page_matches_with_Landing_Page() 
	{
		//Assert.assertEquals(offerPageProdctName, LandingPageproductName);
		Assert.assertEquals(offerPageProdctName,testContextSetup.LandingPageproductName);
		System.out.println("It's Working Perfectly");
	}
		
	
	

}
