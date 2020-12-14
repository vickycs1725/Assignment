package com.demo.Test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.demo.PageObject.LoginPage;
import com.demo.helper.Logger.LoggerHelper;
import com.demo.testBase.Config;
import com.demo.testBase.TestBase;
/**
 * @author Vicky Kumar
 **/
public class LoginTest extends TestBase {
	String s1="$%^&*(HJNMKJ";
	String s2="UIIJH&^";
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);

	@Test()
	public void testLoginToApplicationVia_InvalidData() {
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginPage(config.getWebsite());
		lp.enterEmail(s1);
		lp.enterPassword(s2);
		lp.clickLoginBtn();
		lp.checkForError();
	}
	
	@Test(priority = 2)
	public void testLoginToApplicationVia_InvalidData2() {
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginPage(config.getWebsite());
		lp.enterEmail("");
		lp.enterPassword("");
		lp.clickLoginBtn();
		lp.checkForError();
	}
	
	@Test(priority = 3)
	public void testLoginToApplicationVia_ValidData() {
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginPage(config.getWebsite());
		lp.enterEmail(config.getEmaiId());
		lp.enterPassword(config.getPassword());
		lp.clickLoginBtn();
		lp.verifyHomePage();
	}
}
