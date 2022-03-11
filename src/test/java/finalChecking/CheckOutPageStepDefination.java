package finalChecking;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefination 
{
	public WebDriver driver;
	TestContextSetup testContextSetup;
	public  CheckOutPage checkoutpage;
	

	public CheckOutPageStepDefination(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
		this.checkoutpage=testContextSetup.pageobjectmanager.getCheckoutPage();	
		
	}
	
	@Then("Varify user has ability to enter promo code and place the order")
	public void varify_user_has_ability_to_enter_promo_code_and_place_the_order() 
	{
		//checkoutpage=testContextSetup.pageobjectmanager.getCheckoutPage();	
		Assert.assertTrue(checkoutpage.VerifyPromoBtn());
		Assert.assertTrue(checkoutpage.VerifyPlaceOrder());
		
	}
	 @Then("^User proceeds to Checkout and Validate the (.+) items in checkout page$")
	    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException 
	 {
	      
		 checkoutpage.CheckOutItems();
		 Thread.sleep(3000);
		 //Assertion to extract name from screen and Compair wth Name String
	 }

	
	

}
