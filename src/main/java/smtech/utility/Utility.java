package smtech.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	public WebDriver driver;
	public WebDriverWait wait;
	public Utility(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public Actions Action() {
		Actions action = new Actions(driver);
		return action;
	}
	
	public WebElement FindEleVisibilityOf(WebElement ele) {
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public Boolean FindEleInvisibilityOf(WebElement ele) {
		return wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public WebElement FindEleByVisibility(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public Boolean FindEleByInvisibility(By by) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
}
