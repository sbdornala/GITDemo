package Cucumbertestrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features="src/test/java/features/Login.feature",
				features="src/test/java/features/registration.feature",
		glue="stepDefinations"
		
		)
//when we commnet @runwith option above and and extend AbstractTestNGCucumberTests we can run the xml file as TESTNGSuite if we want to run the test cases 
//with testrunner then uncomment the @runwith option and remove the extends AbstractTestNGCucumberTests
public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}
