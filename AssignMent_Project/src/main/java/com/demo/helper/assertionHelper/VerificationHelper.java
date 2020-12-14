package com.demo.helper.assertionHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.demo.helper.Logger.LoggerHelper;

/**
 * @author Vicky Kumar
 **/

public class VerificationHelper {

	private static final Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public static synchronized boolean verifyElementPresent(WebElement element) {
		boolean isDispalyed = false;
		try {
			isDispalyed = element.isDisplayed();
			log.info(element.getText() + " is displayed");
		} catch (Exception ex) {
		}

		return isDispalyed;
	}

	public static synchronized boolean verifyElementClickable(WebElement element) {
		boolean isDispalyed = false;
		try {
			isDispalyed = element.isEnabled();
			log.info(element.getText() + " is Enabled");
		} catch (Exception ex) {
			log.error("Element not found " + ex);
		}

		return isDispalyed;
	}

	public static synchronized boolean verifyElementNotPresent(WebElement element) {
		boolean isDispalyed = false;
		try {
			element.isDisplayed();
			log.info(element.getText() + " is dispalyed");
		} catch (Exception ex) {
			log.error("Element not found " + ex);
			isDispalyed = true;
		}

		return isDispalyed;
	}

	public static synchronized boolean verifyTextEquals(WebElement element, String expectedText) {
		boolean flag = false;
		try {
			String actualText = element.getText();
			if (actualText.equalsIgnoreCase(expectedText)) {
				log.info("Test String is correct");
				log.info("actualText is :" + actualText + '\n' + " expected text is: " + expectedText);
				return flag = true;
			} else {
				log.error("actualText is :" + actualText + '\n' + " expected text is: " + expectedText);
				return flag;
			}
		} catch (Exception ex) {
			log.error("actualText is :" + element.getText() + '\n' + " expected text is: " + expectedText);
			log.info("text not matching" + ex);
			return flag;
		}
	}

	public static synchronized boolean verifyErrorMsg(WebElement element) {
		boolean isDispalyed = false;
		try {
			element.isDisplayed();
			Assert.fail(element.getText() + " is dispalyed");
		} catch (Exception ex) {
			// log.error("Element not found " + ex);
			isDispalyed = true;
		}

		return isDispalyed;
	}

	public static synchronized boolean verifyTextContains(WebElement element, String expectedText) {
		boolean flag = false;
		try {
			String actualText = element.getText().toLowerCase();
			if (actualText.contains(expectedText.toLowerCase())) {
				log.info("Test String is correct");
				log.info(" expected text is: " + expectedText + " is displayed...");
				return flag = true;
			} else {
				log.error("actualText is :" + actualText + '\n' + " expected text is: " + expectedText);
				return flag;
			}
		} catch (Exception ex) {
			log.error("actualText is :" + element.getText() + '\n' + " expected text is: " + expectedText);
			log.info("text not matching" + ex);
			return flag;
		}
	}

	public static synchronized boolean compareTextContains(String actualText, String expectedText) {
		boolean flag = false;
		try {
			if (actualText.toLowerCase().contains(expectedText.toLowerCase())) {
				log.info("Test String is correct");
				log.info(" expected text is: " + expectedText.toLowerCase() + " is displayed...");
				return flag = true;
			} else {
				log.error("actualText is :" + actualText.toLowerCase() + '\n' + " expected text is: "
						+ expectedText.toLowerCase());
				return flag;
			}
		} catch (Exception ex) {
			log.error("actualText is :" + actualText.toLowerCase() + '\n' + " expected text is: "
					+ expectedText.toLowerCase());
			log.info("text not matching" + ex);
			return flag;
		}
	}

	public static synchronized boolean compareTextEquals(String actualText, String expectedText) {
		boolean flag = false;
		try {
			if (actualText.toLowerCase().contains(expectedText.toLowerCase())) {
				log.info("Test String is correct");
				log.info(" expected text is: " + expectedText.toLowerCase() + " is displayed...");
				return flag = true;
			} else {
				log.error("actualText is :" + actualText.toLowerCase() + '\n' + " expected text is: "
						+ expectedText.toLowerCase());
				return flag;
			}
		} catch (Exception ex) {
			log.error("actualText is :" + actualText.toLowerCase() + '\n' + " expected text is: "
					+ expectedText.toLowerCase());
			log.info("text not matching" + ex);
			return flag;
		}
	}
}