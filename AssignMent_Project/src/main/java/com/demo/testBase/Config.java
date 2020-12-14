package com.demo.testBase;

import java.util.Properties;

/**
 * @author Vicky Kumar
 **/

public class Config extends TestBase {

	private Properties OR;

	public Config(Properties OR) {
		this.OR = OR;
	}

	public String getUserName() {
		return OR.getProperty("Username");
	}

	public String getPassword() {
		return OR.getProperty("Password");
	}

	public String getWebsite() {
		return OR.getProperty("Website");
	}

	public String getBrowser() {
		return OR.getProperty("Browser");
	}

	// ---------------------getEmail----------------
	public String getEmaiId() {
		return OR.getProperty("email");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(OR.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}


}
