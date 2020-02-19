package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	
	public WebDriver driver;
	
	//  Declaring methods as public and variables as private is a programming technique to achieve encaplusation. We have defined the variables private here 
	//but there methonds are defined public below (i.e.public WebElement Fullname() which is public methot but its variable private By name=By.id("user_name"); is defined private)
	
	
	private By name=By.id("user_name");
	private By uname=By.id("user_email");
	private By passwd=By.id("user_password");
	private By cnfrmpwd=By.id("user_password_confirmation");
	private By chkbox=By.cssSelector("#recaptcha-anchor");
	private By terms=By.cssSelector("#user_agreed_to_terms");
	//private By button=By.cssSelector("[class='btn btn-primary btn-md signup-button']");
		
	
	
	public RegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Fullname()
	{
	return	driver.findElement(name);
	}
	
	public WebElement Username()
	{
	return driver.findElement(uname);	
		
	}
	
	public WebElement Password()
	{
		return driver.findElement(passwd);
		
	}
	
	public WebElement CnfrmPassword()
	{
		return driver.findElement(cnfrmpwd);
	}
	
	public WebElement IamNotRobot()
	{
		return driver.findElement(chkbox);
	}

	
	public WebElement AcceptTC()
	{
		return driver.findElement(terms);
	}
}
