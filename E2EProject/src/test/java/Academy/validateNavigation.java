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

public class validateNavigation extends base{

	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));
	}
	
@Test
	public void ValidateAppNavBar() 
	{
	
	LandingPage l=new LandingPage(driver);
	//compare the text from the browser with the actual text
	Assert.assertTrue(l.getNavbar().isDisplayed());
	log.info("Navigation bar is displayed");
	
	
	
	
	}


    @AfterTest
    public void teardown()
    {
    	driver.close();
    	driver=null;
    }
}



