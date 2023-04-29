package smtech.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import shpping.PageObjects.LoginPageObj;

public class Base {
	
	 WebDriver driver;
	public Properties prop;
	public LoginPageObj loginpageobj;
	
	public WebDriver intializationdriver() throws IOException {
		prop=new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/smtech/config/GlobalVariabales.properties");
		prop.load(input);
		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	
	}
	

	
	@BeforeMethod
	public LoginPageObj LunchApp() throws IOException {
		intializationdriver();
		loginpageobj = new LoginPageObj(driver);
		loginpageobj.goTo(prop.getProperty("url"));
		return loginpageobj;
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
