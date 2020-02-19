package EndtoEndwebtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AcadamyHomePage;
import resources.browserInitialization;

public class HomepagelinksTest extends browserInitialization{
	
	
public static Logger log=LogManager.getLogger(HomePageAssetrionTest.class.getName());
AcadamyHomePage a;
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =InitializeBrowser();

	}
	
	
	@Test
	public void Homepagelinkscount() throws IOException 
	{
			driver.get(prop.getProperty("url"));
			
			// AcadamyHomePage object is defined globally above so i can use it through out this class browserInitialization. if i define the AcadamyHomePage 
			//below this will be applicable for this class (Homepagelinkscount) only as this is public of this class
			 a=new AcadamyHomePage(driver);
	
		int link=driver.findElements(By.tagName("a")).size();
		System.out.println(link);
	
	}
	
	
	@Test
	public void allcoursestextvalidationFeaturedcoursevalidation()
	{
		// AcadamyHomePage object is defined globally above so i can use it through out this class browserInitialization. if i define the AcadamyHomePage 
					//below this will be applicable for this class (allcoursestextvalidationFeaturedcoursevalidation) only as this is public of this class
		// 
	Assert.assertEquals(a.featuredcourse().getText(), "FEATURED COURSES");
	}
	
	@Test
	public void featuredcoursevalidation()
		{
		
		// AcadamyHomePage object is defined globally above so i can use it through out this class browserInitialization. if i define the AcadamyHomePage 
					//below this will be applicable for this class (featuredcoursevalidation) only as this is public of this class
		
	Assert.assertEquals(a.viewallcourses().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	
	
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
}
