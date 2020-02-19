package stepDefinations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import cucumber.api.junit.Cucumber;
import pageObjects.AcadamyHomePage;
import pageObjects.HomepageAfterLogin;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.browserInitialization;



import org.junit.runner.RunWith;

import org.testng.Assert;

@RunWith(Cucumber.class)
public class stepDefination extends browserInitialization{
	    @Given("^user is on \"([^\"]*)\" page$")
    public void user_is_on_something_page(String arg1) throws Throwable {
    driver =InitializeBrowser();
    driver.get(arg1);
	AcadamyHomePage a= new AcadamyHomePage(driver);
    a.login().click();
        }

	    @When("^member enter (.+) password (.+) credentials$")
	    public void member_enter_password_credentials(String username, String password) throws Throwable {
	    	LoginPage l=new LoginPage(driver);
			l.username().sendKeys(username);
			l.password().sendKeys(password);
			l.submit().click();
	    
	    }
    
    @Then("^member is logged in sucessfully$")
    public void member_is_logged_in_sucessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	HomepageAfterLogin ha=new HomepageAfterLogin(driver);
		
		Assert.assertTrue(ha.mycources().isDisplayed());
driver.quit();
      
    }
    
    @Given("^user is on \"([^\"]*)\" page and click on registration link$")
    public void user_is_on_something_page_and_click_on_registration_link(String strArg1) throws Throwable {
    	  driver =InitializeBrowser();
    	    driver.get(strArg1);
    	    AcadamyHomePage ah=new AcadamyHomePage(driver);
    		ah.register().click();  
    	    }

    @When("^member enter username (.+) email  (.+)  password (.+) confirm password (.+) credentials and click submit$")
    public void member_enter_username_email_password_confirm_password_credentials_and_click_submit(String username, String emailaddress, String password, String confirmpassword) throws Throwable {
    	RegistrationPage r=new RegistrationPage(driver);
    	
    	r.Fullname().sendKeys(username);
       	
    	r.Username().sendKeys(emailaddress);
    	
       	r.Password().sendKeys(password);
    	
      	r.CnfrmPassword().sendKeys(confirmpassword);
    	
 
    }

    @Then("^member is registerred sucessfully$")
    public void member_is_registerred_sucessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	RegistrationPage r=new RegistrationPage(driver);
    	//r.IamNotRobot().click();
    	r.AcceptTC().click();
  	driver.quit();
    }
   
}