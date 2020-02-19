package EndtoEndwebtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AcadamyHomePage;
import pageObjects.HomepageAfterLogin;
import pageObjects.LoginPage;
import resources.browserInitialization;

public class HomePageTest extends browserInitialization{
	public static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =InitializeBrowser();

	}
	
	@Test(dataProvider="getData")
	public void QaclickHomepage(String Username,String Password) throws IOException 
	{
	

		driver.get(prop.getProperty("url"));
		log.info("Home page displayed");
		
		log.info("Message displayed-");
		
		
		// two ways to call the objects from other classes
		//1) Use inheritance by extend class like what is done above
		//2) create an object to that class and invoke the methods of it like what's done below. we have create an object a for AcadamyHomePage class and invoked its methods
		AcadamyHomePage a= new AcadamyHomePage(driver);
		a.login().click();
		log.info("Login page displayed");
		
		LoginPage l=new LoginPage(driver);
				l.username().sendKeys(Username);
		l.password().sendKeys(Password);
		
		log.info("Username and password entered");
		l.submit().click();
		
		log.info("Submit button clicked");
		
		HomepageAfterLogin ha=new HomepageAfterLogin(driver);
		
		Assert.assertTrue(ha.mycources().isDisplayed());
		
		//l.createaccount().click();
		
		//Validating if the username and password error message is displayed or not to pass or fail the test case
		//Assert.assertEquals(l.validationmessage().getText(), "Invalid email or password.");

		//Or use Asset true condition it will check if the error message is displayed or not. this will not compare the expected vs actual
	
		
		//Assert.assertTrue(l.validationmessage().isDisplayed());
	//	driver.close();
		//log.info("Browser closed sucessfully");
		
		//returning the driver as the driver is initilized for each test case at the top
	//	driver=null;
			
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Rows indicate how many data sets does this test runs for  -- we provide value 3 so it will run for 3 sets of test data , index 0 holds first set of data, index 1 holds 2nd set of data and so on
		//Coloumn indicates how many values should it pass for each test case -- We provided value=2 as we have only username and password to pass where 0 holds username and 1 holds password
		
		Object[][] data=new Object[2][2];
		
		data[0][0]="sharu777@gmail.com";
		data[0][1]="rakshash";
		
		data[1][0]="shar@tt.com";
		data[1][1]="pass1234";
		/*
		data[2][0]="karu@tt.com";
		data[2][1]="junio123";
		*/
		return data;	
		
		
	}
	
	
}
