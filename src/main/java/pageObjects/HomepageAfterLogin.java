package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepageAfterLogin {
	
	public WebDriver driver;
	
	private By course=By.linkText("My Courses");
	
	
	
	public HomepageAfterLogin(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	
	public WebElement mycources()
	{
		return driver.findElement(course);
	}
	

}
