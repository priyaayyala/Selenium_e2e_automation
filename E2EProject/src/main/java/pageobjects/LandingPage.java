package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By Navbar=By.xpath("/html[1]/body[1]/header[1]/div[2]/div[1]/nav[1]/ul[1]");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}


	public WebElement getLogin()
	{
		return driver.findElement(signin);
		
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	public WebElement getNavbar()
	{
		return driver.findElement(Navbar);
		
	}
}

