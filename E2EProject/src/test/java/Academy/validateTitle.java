package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageobjects.LandingPage;

import resources.base;

public class validateTitle extends base{

	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to Home Page");
	}
@Test
	public void ValidateApptitle() 
	{

	LandingPage l=new LandingPage(driver);
	//compare the text from the browser with the actual text
	Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
	 log.info("Successfully validated text message");
	
	
	}

@AfterTest
public void teardown()
{
	driver.close();
	driver=null;
}

}



