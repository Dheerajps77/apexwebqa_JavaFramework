package apexweb.qa.TestUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {

	
	public static WebElement WaitElementToBeClickable(WebDriver driver, By findByLocation, int waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(findByLocation));
		return driver.findElement(findByLocation);
	}
	
	public static WebElement WaitAllElementsToBeVisible(WebDriver driver, By findByLocation, int waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findByLocation));
		
		WebElement waitForAllElementsToBeVisible=driver.findElement(findByLocation);
		return waitForAllElementsToBeVisible;
		
		//or like below
		//return driver.findElement(findByLocation);
	}
	
	public static WebElement WaitElementToBeSelected(WebDriver driver, By findByLocation, int WaitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver, WaitTime);
		wait.until(ExpectedConditions. elementToBeSelected(findByLocation));
		return driver.findElement(findByLocation);
	}
	
	public static String GetUserDetails()
	{
		FileInputStream fis=null;
		Properties prop=new Properties();
		String UserDetails = System.getProperty("user.dir") + "/configFiles/LoginDetails.properties";
		
		try
		{
		fis=new FileInputStream(UserDetails);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		try
		{
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return prop.getProperty(UserDetails);
	}
}
