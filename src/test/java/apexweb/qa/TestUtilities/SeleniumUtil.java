package apexweb.qa.TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	
	public static void turnOffImplicitWaits(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void turnOnImplicitWaits(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public static boolean isElementPresent(WebDriver driver,By locator){
		turnOffImplicitWaits(driver);
		boolean result = false;
		try {
			driver.findElement(locator).isDisplayed();
			result = true;
		} catch (Exception e) {
			turnOnImplicitWaits(driver);
		}finally {
			turnOnImplicitWaits(driver);
		}
		return result;
	}
	
	public static void MouseHOverToElement(WebDriver driver, By findByLocation)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(findByLocation)).build().perform();
	}
	
	public static String CapturingScreenshot(WebDriver driver, String screenshotName)
	{
		
		String DestinationToStoreScreenshot=System.getProperty("user.dir")+"/Screenshot/"+screenshotName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		
		File file1=new File(DestinationToStoreScreenshot);
		
		try {
			FileUtils.copyFile(file, file1);
		} catch (IOException e) 
		{	
			e.printStackTrace();
		}
		
		return DestinationToStoreScreenshot;
	}
	
	public static void SelectedByVisibleTextFunction(WebDriver driver, By findByLocation, String selectedText)
	{
		WebElement element=driver.findElement(findByLocation);
		Select select=new Select(element);
		select.selectByVisibleText(selectedText);
	}
	
	public static void SelectedByVisibleIndexFunction(WebDriver driver, By findByLocation, int indexValue)
	{
		WebElement element=driver.findElement(findByLocation);
		Select select=new Select(element);
		select.selectByIndex(indexValue);
	}
	
	public static void SelectedByValueFunction(WebDriver driver, By findByLocation, String textValue)
	{
		WebElement element=driver.findElement(findByLocation);
		Select select=new Select(element);
		select.deselectByValue(textValue);
	}
}
