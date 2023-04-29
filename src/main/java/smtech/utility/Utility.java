package smtech.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Utility {
	public WebDriver driver;
	public Utility(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public Actions Action() {
		Actions action = new Actions(driver);
		return action;
	}

}
