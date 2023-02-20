package com.PSC.helper.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


import com.PSC.framework.helper.BasePageObject.PageBase;
import com.PSC.framework.helper.Button.ButtonHelper;
import com.PSC.framework.helper.TextBox.TextBoxHelper;
import com.PSC.framework.helper.Wait.WaitHelper;
import com.PSC.framework.settings.ObjectRepo;

public class LoginPage extends PageBase {

	private WebDriver driver;
	private WaitHelper wH;
	private ButtonHelper bH;
	private TextBoxHelper tH;
//	private JavaScriptHelper jsH;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wH = new WaitHelper(driver, ObjectRepo.reader);
		bH = new ButtonHelper(driver);
		tH = new TextBoxHelper(driver);
	}
	
	@FindBy(id = "nav-hamburger-menu")
	@CacheLookup
	private WebElement All;

	@FindBy(xpath = "//*[@data-ref-tag='nav_em_1_1_1_6']")
	@CacheLookup
	private WebElement Echo_Alexa;
	
	@FindBy(xpath = "//*[@href='/dp/B07PFFMP9P?ref_=nav_em_in_pc_sbc_dot_0_2_2_3']")
	@CacheLookup
	private WebElement Echo;
	
	@FindBy(id = "buy-now-button")
	@CacheLookup
	private WebElement BuyNow;
	
	@FindBy(id = "ap_email")
	@CacheLookup
	private WebElement email;

	@FindBy(id = "continue")
	@CacheLookup
	private WebElement submit;

	@FindBy(id = "ap_password")
	@CacheLookup
	private WebElement password;

	@FindBy(id = "signInSubmit")
	@CacheLookup 
	private WebElement signIn;
	
	@FindBy(xpath = "//*[text()='Enter your email or mobile phone number']")
	@CacheLookup 
	private WebElement InvalidLoginMsg;
	
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void navigateAmazonScreen() {
		System.out.println("URL------------------>" + ObjectRepo.reader.LoginURL());
		ObjectRepo.driver.get(ObjectRepo.reader.LoginURL());
	}
	
	public void clickAll() {
		try {
			bH.click(All);
			log("Click on All button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("nav-hamburger-menu")).click();
		}
	}
	
	public void clickEchoAlexa() {
		try {
			bH.click(Echo_Alexa);
			log("Click on All button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.xpath("//*[@data-ref-tag='nav_em_1_1_1_6']")).click();
		}
	}
	
	public void clickEchoMenu() {
		try {
			bH.click(Echo);
			log("Click on All button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.xpath("//*[@href='/dp/B07PFFMP9P?ref_=nav_em_in_pc_sbc_dot_0_2_2_3']")).click();
		}
	}
	
	public void clickBuyNow() {
		try {
			bH.click(BuyNow);
			log("Click on All button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("buy-now-button")).click();
		}
	}
	
	public void navigateToLoginScreen() {
		System.out.println("URL------------------>" + ObjectRepo.reader.LoginURLs());
		ObjectRepo.driver.get(ObjectRepo.reader.LoginURLs());
	}
	
	public void clickContinue() {
		try {
			bH.click(submit);
			log("Click on Continue button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("Continue")).click();
		}
	}
	
	public String errorMsg() {
		wH.hardWait(1500);
		String text = tH.getText(InvalidLoginMsg);
		log("Get value :" + text, false);
		return text;
	}
	
	public void enterEmail(String emailP) {
		try {
			tH.clearAndSendKeys(email, emailP);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("ap_email")).sendKeys(emailP);
		}
	}
	
	public void clickContinueButton() {
		try {
			bH.click(submit);
			log("Click on Continue button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("Continue")).click();
		}
	}
	
	public void enterPassword(String pass) {
		try {
			tH.clearAndSendKeys(password, pass);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("ap_password")).sendKeys(pass);
		}
	}
	
	public void clickSignInButton() {
		try {
			bH.click(signIn);
			log("Click on Continue button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("signInSubmit")).click();
		}
	}
	
	
	public void visibilityAmazonPage() {
		wH.waitForVisibility(All);
		
	}

	public void visibilityEchoPage() {
		wH.waitForVisibility(Echo);
		
	}
	
	public void visibilityEmailAndContinue() {
		wH.waitForVisibility(email);
		wH.waitForVisibility(submit);
	}
	
	public void visibilityPasswordAndSignIn() {
		wH.waitForVisibility(password);
		wH.waitForVisibility(signIn);
	}
	
	
	
	
	/** Web Elements */

	/*@FindBy(id = "login-password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(id = "login-email")
	@CacheLookup
	private WebElement email;

	@FindBy(xpath = "//*[text()='LOGIN']")
	@CacheLookup
	private WebElement login;*/ //panet dashboard
	
	/*@FindBy(id = "pass")
	@CacheLookup
	private WebElement password;
	
	@FindBy(id = "email")
	@CacheLookup
	private WebElement email;

	@FindBy(id = "loginbutton']")
	@CacheLookup
	private WebElement login;*/
	
	
/*
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void navigateToLoginScreen() {
		System.out.println("URL------------------>" + ObjectRepo.reader.LoginURL());
		ObjectRepo.driver.get(ObjectRepo.reader.LoginURL());
	}
	
	public void enterEmail(String emailP) {
		try {
			tH.clearAndSendKeys(email, emailP);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("email")).sendKeys(emailP);
		}
	}
	
	public void enterPassword(String pass) {
		try {
			tH.clearAndSendKeys(password, pass);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("pass")).sendKeys(pass);
		}
	}
	
	public void clickLoginButton() {
		try {
			bH.click(login);
			log("Click on Login button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("loginbutton")).click();
		}
	}
	
	
	

	public void visibilityEmailPasswordAndLogin() {
		wH.waitForVisibility(email);
		wH.waitForVisibility(password);
		wH.waitForVisibility(login);
	}*/ // FaceBook Step Defination
}
