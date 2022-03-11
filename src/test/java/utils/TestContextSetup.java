package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManger;

public class TestContextSetup {
	
	public WebDriver driver;
	public String LandingPageproductName;
	public String offerPageProdctName;
	public PageObjectManger pageobjectmanager;
	public TestBase testbase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException 
	{
		testbase = new TestBase();
		pageobjectmanager=new PageObjectManger(testbase.WebDriverManager());
		genericUtils = new GenericUtils(testbase.WebDriverManager());
	}


}
