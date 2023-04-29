package smtech.test;

import org.testng.Assert;
import org.testng.annotations.Test;


import smtech.base.Base;

public class LoginPageTest extends Base {
	
	@Test
	public void PasswordFieldErrorValidationTest(){
		String errPassword = loginpageobj.PasswordFieldErrorValidation();
		Assert.assertEquals(errPassword, "*Password is required");
	}
	
	@Test
	public void EmailFieldErrorValidationTest(){
		String errUsername = loginpageobj.EmailFieldErrorValidation();
		Assert.assertEquals(errUsername, "*Email is required");
	}
	
	@Test
	public void InvalidLoginValidationTest(){
		boolean IncorrectPassOrUsername = loginpageobj.InvalidLoginValidation();
		Assert.assertTrue(IncorrectPassOrUsername);
	}
	
	@Test
	public void LoginTest(){
		
		loginpageobj.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	 
	
}
