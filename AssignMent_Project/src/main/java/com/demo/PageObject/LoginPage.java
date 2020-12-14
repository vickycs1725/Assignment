package com.demo.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.demo.helper.Logger.LoggerHelper;
import com.demo.helper.Wait.WaitHelper;
import com.demo.helper.assertionHelper.VerificationHelper;
import com.demo.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Vicky Kumar
 **/
public class LoginPage extends TestBase {
	WebDriver driver;
	public static final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	// ---------------------------
	@FindBy(linkText = "https://azent.com/")
	WebElement linkdisplayed;

	@FindBy(xpath = "//h3[@class='coachwidget-custom-modal']")
	WebElement lightBox;

	@FindBy(id = "username")
	WebElement enterEmail;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-colorError']")
	WebElement errMsg;

	@FindAll(@FindBy(xpath="//div[@class='MuiFormControl-root MuiTextField-root MuiFormControl-marginNormal MuiFormControl-fullWidth']//p"))
	List<WebElement> error;

	@FindBy(id = "password")
	WebElement passwrd;

	@FindBy(xpath="//span[.='Login']")
	WebElement loginBtn;

	@FindBy(xpath="//p[.='Home']")
	WebElement homePageLink;

	//signup
	@FindBy(xpath="//p[.='New Account? Sign Up!']")
	WebElement signUpLink;


	// ~~~~~~~~~~~~~Page Object Initialization~~~~~~~~~~~~

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);

	}

	// ~~~~~~~~~~~~~~Utilization~~~~~~~~~~~~~
	public void verifyLoginPage(String url) {
		test.log(LogStatus.INFO, "Given I am on Login page");
		boolean urlDis = VerificationHelper.compareTextEquals(driver.getCurrentUrl(), url);
		if(urlDis) {
			test.log(LogStatus.PASS, "Login Page is displayed..");
		}else {
			test.log(LogStatus.FAIL, "Login Page is not displayed seems");
			Assert.fail();
		}
	}

	public void enterEmail(String email) {
		test.log(LogStatus.INFO, "When I fill in Email with "+email);
		enterEmail.sendKeys(email);
		log.info("Email is entered successfully...");
	}

	public void enterPassword(String pass) {
		test.log(LogStatus.INFO, "When I fill in Password with "+pass);
		passwrd.sendKeys(pass);
		log.info("password is entered successFully...");
	}

	public void checkForError() {
		test.log(LogStatus.INFO, "When I check For ErrorMsg");
		boolean err = VerificationHelper.verifyElementPresent(errMsg);
		if(err) {
			test.log(LogStatus.ERROR, "Error msg :"+errMsg.getText());
		}else if(error.iterator().next().isDisplayed()) {
			for(WebElement er:error) {
				test.log(LogStatus.ERROR, er.getText() + "is Displayed");
			}
		}
		else {
			test.log(LogStatus.INFO, "Error msg is not displayed");
			log.info("Error Messege is not displayed");
		}
	}

	public void clickLoginBtn() {
		test.log(LogStatus.INFO, "And I press Login");
		loginBtn.click();
		log.info("Login button clicked successfully");
	}

	public void verifyHomePage() {
		test.log(LogStatus.INFO, "And I should see HomePage");
		waitHelper.waitForElementVisible(homePageLink, 10, 1);
		boolean home = VerificationHelper.verifyElementPresent(homePageLink);
		if(home) {
			test.log(LogStatus.PASS, "Home page is displayed successFully");
		}else {
			test.log(LogStatus.FAIL, "Home page is not displayed seems");
		}
	}

	public void selectSignUp() {
		test.log(LogStatus.INFO, "When I click on Signup Link");
		signUpLink.click();
		log.info("SignUp link is clicked successfully...");
	}

}