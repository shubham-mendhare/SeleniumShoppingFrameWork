package smtech.base;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import smtech.PageObjects.LoginPageObj;

public class Base {
	
	 public WebDriver driver;
	public Properties prop;
	public LoginPageObj loginpageobj;
	
	public WebDriver intializationdriver() throws IOException {
		prop=new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/smtech/config/GlobalVariabales.properties");
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
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	

	
	@BeforeMethod(alwaysRun = true)
	public LoginPageObj LunchApp() throws IOException {
		driver = intializationdriver();
		loginpageobj = new LoginPageObj(driver);
		loginpageobj.goTo(prop.getProperty("url"));
		return loginpageobj;
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
