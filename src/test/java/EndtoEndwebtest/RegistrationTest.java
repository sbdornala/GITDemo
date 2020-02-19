package EndtoEndwebtest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AcadamyHomePage;
import pageObjects.RegistrationPage;
import resources.browserInitialization;

public class RegistrationTest extends browserInitialization {
	public static Logger log=LogManager.getLogger(RegistrationTest.class.getName());
	
	
	@Test(dataProvider="senddata")
	
	public void memberregistration(String membername,String username,String password,String confirmpassword) throws IOException
	{
		driver=InitializeBrowser();

		System.out.println("This is for GIT Testing");
		
		driver.get(prop.getProperty("url"));
		AcadamyHomePage ah=new AcadamyHomePage(driver);
		ah.register().click();
		log.info("Registration page linked clicked");
		
	RegistrationPage r=new RegistrationPage(driver);
	r.Fullname().sendKeys(membername);
	log.info(membername);
	
	r.Username().sendKeys(username);
	
	log.info(username);
	r.Password().sendKeys(password);
	
	log.info(password);
	r.CnfrmPassword().sendKeys(confirmpassword);
	
	log.info(confirmpassword);
	
	log.info("Name,Username,Password,Confirm password entered sucessfully");
	//r.IamNotRobot().click();
	//r.AcceptTC().click();
	driver.close();
	
	log.info("Browser closed sucessfully");
	//returning the driver as the driver is initilized for each test case at the top
	driver=null;
	
	}
	
	@DataProvider
	
	public Object[][] senddata()
	{
		Object[][]	data=new Object[2][4];
		data[0][0]="Chulbul Panday";
		data[0][1]="Chulbul@Panday.com";
		data[0][2]="Chulday";
		data[0][3]="Chulday";
		
		data[1][0]="Kilbill Panday";
		data[1][1]="Kilbill@Panday.com";
		data[1][2]="Kilbill";
		data[1][3]="Kilbill";
		
		return data;
				
	}
	

}
