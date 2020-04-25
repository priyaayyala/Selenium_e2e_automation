package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;


public class base {

	     public static WebDriver driver;
	     public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\priya\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Learning\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		 else if(browserName.equals("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "C:\\Learning\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		 }
		
		

	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 return driver;
	}
public void getscreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	Files.copy(src.toPath(), new File("C:\\Learning\\Maven\\test\\"+result+"screenshot.png").toPath(),
            StandardCopyOption.REPLACE_EXISTING);
	
}
}	
