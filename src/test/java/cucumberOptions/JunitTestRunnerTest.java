	package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//We Can generate some Reports
//Html,xml,json,junit,extent
//tags="@PlaceOrder",

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
    glue="finalChecking", monochrome=true,   
    plugin= {"html:target/cucumber.html","html:target/cucumber.json",
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class JunitTestRunnerTest 
{


}
