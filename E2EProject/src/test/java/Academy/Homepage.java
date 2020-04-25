package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;

public class Homepage extends base{

	

	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));
	}
@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{

	driver = initializeDriver();
    driver.get(prop.getProperty("url"));
	LandingPage l=new LandingPage(driver);
	l.getLogin().click();
	LoginPage lp=new LoginPage(driver);
	lp.getEmail().sendKeys(Username);
	lp.getPassword().sendKeys(Password);
	System.out.println("priya1");
	log.info(text);
	lp.clickLogin().click();
	
	}

     @AfterTest
     public void teardown()
     {
    	 driver.close();
    	 driver=null;
     }
@DataProvider
public  Object[][]  getData()

{
	//Array sixe is 2
	//means 0,1
	//Row stands for how many diff data type test should run
	//column stands for how many values per each test
	Object[][] data=new Object[2][3];
	data[0][0]="nonrestricteduser@gmail.com";
	data[0][1]="1234";
	data[0][2]="nonrestricteduser";
	
	data[1][0]="restricteduser@gmail.com";
	data[1][1]="5678";
	data[1][2]="restricteduser";
	
	return data;
}



}