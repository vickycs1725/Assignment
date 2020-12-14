package com.demo.Test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.demo.PageObject.LoginPage;
import com.demo.PageObject.SignUpPage;
import com.demo.helper.Logger.LoggerHelper;
import com.demo.testBase.Config;
import com.demo.testBase.TestBase;

public class SignUpTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(SignUpTest.class);
	String firstname="test123%^";
	String lastname="test#$%^";
	String email="sdhkjsdh@3mail";
	String phno="7876789987";
	String passwrd="   ";
	String rpass="%^&*(H";



	@Test
	public void testLoginToApplicationVia_InnvalidData() {
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage lp = new LoginPage(driver);
		SignUpPage sp=new SignUpPage(driver);
		lp.verifyLoginPage(config.getWebsite());
		lp.selectSignUp();
		sp.signUpPageVerification();
		sp.enterSignUpDetails(firstname, lastname, email, phno, passwrd, rpass);
		sp.clickSignuP();
		sp.verifyErrorMsg();
	}
	
	//data is not set for valid data
	@Test(priority = 2)
	public void testLoginToApplicationVia_validData() {
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage lp = new LoginPage(driver);
		SignUpPage sp=new SignUpPage(driver);
		lp.verifyLoginPage(config.getWebsite());
		lp.selectSignUp();
		sp.signUpPageVerification();
		sp.enterSignUpDetails(firstname, lastname, email, phno, passwrd, rpass);
		sp.clickSignuP();
		sp.verifyErrorMsg();
		lp.verifyHomePage();
		
	}
}
