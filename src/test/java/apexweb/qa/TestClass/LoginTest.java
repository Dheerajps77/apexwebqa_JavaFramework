package apexweb.qa.TestClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import apexweb.qa.TestBase.TestBaseClass;
import apexweb.qa.TestPage.LoginPage;

public class LoginTest extends TestBaseClass{

	
	LoginPage objLoginPage;
	
	@Test(priority=0)
	public void SelectServerName() throws InterruptedException
	{
		objLoginPage=PageFactory.initElements(driver, LoginPage.class);
		objLoginPage.SelectServerName();
	}
	
	@Test(priority=1)
	public void EnterUserName()
	{
		objLoginPage.EnterUserName();
	}
	
	@Test(priority=2)
	public void EnterPassWord()
	{
		objLoginPage.EnterUserPassword();
	}

	@Test(priority=3)
	public void ClickOnLogin()
	{
		objLoginPage.ClickOnLogin();
	}
}
