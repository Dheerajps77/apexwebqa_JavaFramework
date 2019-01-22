package apexweb.qa.TestPage;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	WebDriver driver;
	String loginDetailspath = System.getProperty("user.dir") + "/configFiles/LoginDetails.properties";
	File file = new File(loginDetailspath);
	Properties prop = new Properties();
	
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH, using="//*[@id='root']/div[1]/div/div[2]/form/div[1]/div/input")
	public WebElement userName;
	
	@FindBy(how=How.XPATH, using="//*[@id='root']/div[1]/div/div[2]/form/div[2]/div/div/div[1]/input")
	public WebElement userPassword;
	
	@FindBy(how=How.XPATH, using="//*[@id='root']/div[1]/div/div[2]/form/button")
	public WebElement loginButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='root']/div[1]/div/div[2]/form/div[1]/div/input")
	public WebElement selectServer;
	

	public void SelectServerName() throws InterruptedException
	{
		Select selectDropdown=new Select(selectServer);
		selectDropdown.selectByVisibleText("wss://apiapexqa2.alphapoint.com/WSGateway/");
		Thread.sleep(2000);
	}
	
	public void EnterUserName()
	{
		userName.sendKeys(prop.getProperty("UserName"));
	}
	
	public void EnterUserPassword()
	{
		userPassword.sendKeys(prop.getProperty("PassWord"));
	}
	
	public void ClickOnLogin()
	{
		loginButton.click();
	}
}
