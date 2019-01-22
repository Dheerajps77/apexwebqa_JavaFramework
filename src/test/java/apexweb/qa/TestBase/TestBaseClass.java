package apexweb.qa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBaseClass {

	String loginDetailspath = System.getProperty("user.dir") + "/configFiles/LoginDetails.properties";
	String chromePath = System.getProperty("user.dir") + "/Driver/chromedriver.exe";
	String firfoxPath = System.getProperty("user.dir") + "/Driver/geckodriver.exe";
	String iePath = System.getProperty("user.dir") + "/Driver/IEDriverServer.exe";

	File file = new File(loginDetailspath);
	Properties prop = new Properties();
	protected WebDriver driver;
	
	@BeforeTest
	public void OpeningBrowser() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", chromePath);
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("product_URL"));
		driver.manage().timeouts().pageLoadTimeout(6000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		
		
	}

	@AfterTest
	public void TearDownBrowser() {

		driver.close();
	}
}
