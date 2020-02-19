package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AcadamyHomePage {

	
	public WebDriver driver;
	
	
	private By sigin=By.linkText("Login");
	
	private By regi=By.linkText("Register");
	
	private By course=By.cssSelector("[class='text-center'] h2");
	
	private By allcourse=By.cssSelector("[class*='video-banner'] h3");
		
	

	
	public AcadamyHomePage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}



	public WebElement login()
	{
		return driver.findElement(sigin);
	}
	
	
	public WebElement register()
	{
		return driver.findElement(regi);
	}
	
	public WebElement featuredcourse()
	{
		return driver.findElement(course);
	}
	
	
	public WebElement viewallcourses()
	{
		return driver.findElement(allcourse);
	}
	
}
