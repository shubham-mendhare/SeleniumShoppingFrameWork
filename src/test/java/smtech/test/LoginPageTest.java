package smtech.test;

import org.testng.Assert;
import org.testng.annotations.Test;


import smtech.base.Base;

public class LoginPageTest extends Base {
	
	@Test(priority = 1)
	public void PasswordFieldErrorValidationTest(){
		String errPassword = loginpageobj.PasswordFieldErrorValidation();
		Assert.assertEquals(errPassword, "*Password is required");
	}
	
	@Test(priority = 2)
	public void EmailFieldErrorValidationTest(){
		String errUsername = loginpageobj.EmailFieldErrorValidation();
		Assert.assertEquals(errUsername, "*Email is required");
	}
	
	@Test (priority = 3)
	public void InvalidLoginValidationTest(){
		boolean IncorrectPassOrUsername = loginpageobj.InvalidLoginValidation();
		Assert.assertTrue(IncorrectPassOrUsername);
	}
	
	@Test (priority = 4)
	public void LoginTest(){
		
		loginpageobj.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	 
	
}
