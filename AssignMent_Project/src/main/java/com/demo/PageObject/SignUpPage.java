package com.demo.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.helper.Logger.LoggerHelper;
import com.demo.helper.Wait.WaitHelper;
import com.demo.helper.assertionHelper.VerificationHelper;
import com.demo.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;
/**
 * @author Vicky Kumar
 **/

public class SignUpPage extends TestBase {
	WebDriver driver;
	public static final Logger log = LoggerHelper.getLogger(SignUpPage.class);
	WaitHelper waitHelper;
	// ~~~~~~~~~~~~~Initialization~~~~~~~~~~~~
	@FindBy(xpath = "//p[.='Already have an account? Login!']")
	WebElement signupTab;

	@FindBy(id="firstName")
	WebElement fname;

	@FindBy(id="lastName")
	WebElement lname;

	@FindBy(id="email")
	WebElement emailid;

	@FindBy(id="mobile")
	WebElement mob;

	@FindBy(id="password-1")
	WebElement passwd;

	@FindBy(id="password-2")
	WebElement repasswd;

	@FindBy(xpath="//span[.='Signup']")
	WebElement signUpBtn;

	@FindAll(@FindBy(xpath="//div[@class='MuiFormControl-root MuiTextField-root MuiFormControl-marginNormal MuiFormControl-fullWidth']//p"))
	List<WebElement> error;

	//~~~~~~~~~~~~~~Declaration~~~~~~~~~~~~~~~
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	//~~~~~~~~~~~~~~Utilization~~~~~~~~~~~~~~~
	public void signUpPageVerification() {
		test.log(LogStatus.INFO, "Given I am on SignUp page");
		waitHelper.waitForElementVisible(signupTab, 10, 1);
		boolean sp = VerificationHelper.verifyElementPresent(signupTab);
		if(sp) {
			test.log(LogStatus.PASS, "Signup Page is displayed...");
		}else {
			test.log(LogStatus.FAIL, "Signup page is not displayed...");	
		}
	}

	public void enterSignUpDetails(String firname,String lastname,String email,String mobile,String pass,String repass) {
		test.log(LogStatus.INFO, "Then I Enter signup details");
		fname.sendKeys(firname);
		lname.sendKeys(lastname);
		emailid.sendKeys(email);
		mob.sendKeys(mobile);
		passwd.sendKeys(pass);
		repasswd.sendKeys(repass);
	}

	public void clickSignuP() {
		test.log(LogStatus.INFO, "Then I click on SignUp Button");
		signUpBtn.click();
		log.info("Signup button is clicked successfully");
	}

	public void verifyErrorMsg() {
		try {
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "And I check for Error messeges");
			for(WebElement err:error) {
				test.log(LogStatus.ERROR, "error displayed :"+err.getText());
			}
		}
		catch(Exception e) {
			test.log(LogStatus.PASS, "No Errors to display");
		}
	}
}
