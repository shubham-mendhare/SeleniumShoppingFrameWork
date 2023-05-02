package smtech.PageObjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smtech.utility.Utility;


public class LoginPageObj extends Utility
{
	WebDriver driver;
	
	public LoginPageObj(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	public WebElement username;
	
	@FindBy(id="userPassword")
	public WebElement password;
	
	@FindBy(id="login")
	public WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(text(),'*Email is required')]")
	public WebElement errUsername;
	
	@FindBy(xpath="//div[contains(text(),'*Password is required')]")
	public WebElement errPassword;
	
	@FindBy(css = "div[aria-label=\"Incorrect email or password.\"]")
	public WebElement IncorrectPassOrUsername;
	
	public String PasswordFieldErrorValidation() {
		username.sendKeys("asdas@dfsafasd.com");
		loginBtn.click();
		return errPassword.getText();
		

	}
	
	public String EmailFieldErrorValidation() {
		username.sendKeys(Keys.CONTROL+"A");
		Action().keyDown(Keys.BACK_SPACE).build().perform();
		
		password.sendKeys("asdsaadsad");
		loginBtn.click();
		
		return errUsername.getText();
	}
	
	public boolean InvalidLoginValidation() {
		
//		password.clear();
		password.sendKeys(Keys.CONTROL+"A");
		Action().keyDown(Keys.BACK_SPACE).build().perform();
	
		username.sendKeys("asdas@dfsafasd.com");
		password.sendKeys("asdsaadsad");
		loginBtn.click();
		
		return IncorrectPassOrUsername.isDisplayed();
	}
	
	public void Login(String usrname, String passwd) {
		username.sendKeys(Keys.CONTROL+"A");
		Action().keyDown(Keys.BACK_SPACE).build().perform();
		
		password.sendKeys(Keys.CONTROL+"A");
		Action().keyDown(Keys.BACK_SPACE).build().perform();
		
		username.sendKeys(usrname);
		password.sendKeys(passwd);
		loginBtn.click();
	}
	
	public void goTo(String url) throws IOException {
		driver.get(url);
	}
}
