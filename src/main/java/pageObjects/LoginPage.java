package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By uname=By.id("user_email");
	private By pwd=By.id("user_password");
	private By button=By.cssSelector("[name='commit']");
	private By forgtpwd=By.linkText("Forgot Password?");
	private By creatacct=By.linkText("Create an Account");
	private By errormsg=By.cssSelector("[class='alert alert-danger']");
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement username()
	{
	return	driver.findElement(uname);
	}
	
	public WebElement password()
	{
	return	driver.findElement(pwd);
	}
	
	
	public WebElement submit()
	{
		return driver.findElement(button);
	}

	
	public WebElement forgotpassword()
	{
		return driver.findElement(forgtpwd);
	}
	
	public WebElement createaccount() 
	{
		return driver.findElement(creatacct);
	}
	
	public WebElement validationmessage() 
	{
		return driver.findElement(errormsg);
	}
	
}
