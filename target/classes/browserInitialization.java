package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class browserInitialization {
	
	// declaring the webdriver globally so it can be used globally
	
	// if we set driver to be static we cannot run the test cases in parallel if we remove the static word we can run all the test cases parallel
	//public static WebDriver driver;
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver InitializeBrowser() throws IOException
	{
		// set up a properties file to drive the type of browser 
	prop=new Properties();
	//Achiving the paths dynamically instead of hardcoding
	
	
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\browsername.properties");
	
	//FileInputStream fis=new FileInputStream("C:\\Users\\sdornala\\EndtoEndAutomation\\src\\main\\java\\resources\\browsername.properties");
	
	//load all the values in the file to the properties
	prop.load(fis);
	
	// Below System.getproperty is used so we can drive the browser name through Mavin instead of from the properties file
	String browserName=System.getProperty("browser");
	
	//this will take the browser name from the properties file
	//String browserName=prop.getProperty("browser");
	

/* this is simplae way of running the autmation on chrome  browser. if we dont want to see the browser open when we run the scripts then we have to use chromeheadless option
 	if (browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}
 */



//if the browser name passed contains only chrome the script gets executed
	if (browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		
		// If the browser name passed contains headless word then this will get executed
		if (browserName.contains("headless"))
		{
			options.addArguments("headless");
		}
		
		
		driver = new ChromeDriver(options);
	}
	else if (browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else if (browserName.equals("IE"))
	{
	
	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	
	}
//once the driver is selected give wait time
driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//return the driver
	return driver;

		
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\"+result+"screenshot.png"));
		
	}
		
}
