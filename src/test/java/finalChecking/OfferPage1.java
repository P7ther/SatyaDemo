package finalChecking;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManger;
import utils.TestContextSetup;

public class OfferPage1 
{
    public String LandingPageproductName;
	public String offerPageProdctName;
	TestContextSetup testContextSetup;
	public OffersPage offerspage;
	public LandingPage landingpage;
	PageObjectManger pageobjectmanager;
	
    //single responcibility	 Principal
	//loosly coupled
	//Factory Design Pattern
	
	public OfferPage1(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}
	
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException

	{
		switchToOffers(); 
		//offerspage = new OffersPage(testContextSetup.driver);
		OffersPage  offerspage = testContextSetup.pageobjectmanager.OffersPage();
		offerspage.searchItem(shortName);
		Thread.sleep(3000);
		offerPageProdctName=offerspage.getProductName();
		
		System.out.println("landing page name :"+offerPageProdctName);
    }
	
	public void switchToOffers() 
	{
		//if switched to offer page->skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase(""))
		
		//The Top deals details are availabe in Landing page that's why we creat the objct of landing page
		
		//after creation of PageObjectManger
		//pageobjectmanager = new PageObjectManger(testContextSetup.driver);
		//landingpage=pageobjectmanager.getLandingPage();
		
		//LandingPage landingpage = testContextSetup.pageobjectmanager.getLandingPage();
		
		//Before Creation of PageObjectManger
	    //landingpage =new LandingPage(testContextSetup.driver);
		//landingpage.selectTopDeal();
		
		//Set<String> s1 =testContextSetup.driver.getWindowHandles();
		//Iterator<String>i1=s1.iterator();
		//String parentWindow =i1.next();
		//String childWindow =i1.next();
		//testContextSetup.driver.switchTo().window(childWindow);
		
		//pageobjectmanager = new PageObjectManger(testContextSetup.driver);
		
		LandingPage landingpage = testContextSetup.pageobjectmanager.getLandingPage();
 		landingpage.selectTopDeal();
 		
		//Set<String> s1 =testContextSetup.driver.getWindowHandles();
		//Iterator<String>i1=s1.iterator();
		//String parentWindow =i1.next();
		//String childWindow =i1.next();
		//testContextSetup.driver.switchTo().window(childWindow);
 		testContextSetup.genericUtils.SwitchWindowToChild();
		
	}
	
	@And("^Valiate product name in offers page matches with Landing Page$")
     public void Valiate_product_name_in_offers_page_matches_with_Landing_Page() 
	{
		Assert.assertEquals(offerPageProdctName,testContextSetup.LandingPageproductName);
		System.out.println("It's Working Perfectly");
	}
		
	
	

}
