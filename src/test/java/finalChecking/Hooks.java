package finalChecking;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks 
{
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
		
	}
	
	
	@After
	public void AfterScenario() throws IOException 
	{
		//driver.quite();
		//The Driver class present in WebdriverManager() in TestBase class
		//If we want to call those method we need to creat test base object and then we have to call that method
		//But we already creat testbase object in Testcontextsetup class,so we can call the drive like this. 
		testContextSetup.testbase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException 
	{
		WebDriver driver =testContextSetup.testbase.WebDriverManager();
		if(scenario.isFailed()) 
		{
			//Screenshort Code
			File Sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//	byte[] fileContent= FileUtils.readFileToByteArray(Sourcepath);
		//	scenario.attach(fileContent, "image/png", "Image");
			
		}
	}
	
	
	
	
	
	
	
	
	

}
