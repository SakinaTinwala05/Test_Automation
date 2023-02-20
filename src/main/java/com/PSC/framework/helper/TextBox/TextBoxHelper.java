
package com.PSC.framework.helper.TextBox;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PSC.constants.Constants;
import com.PSC.framework.helper.Generic.GenericHelper;
import com.PSC.framework.helper.Logger.LoggerHelper;
import com.PSC.framework.helper.Wait.WaitHelper;
import com.PSC.framework.settings.ObjectRepo;

/**
 * @author krana
 * 
 *
 */
public class TextBoxHelper extends GenericHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(TextBoxHelper.class);
	private WaitHelper wHelper;

	public TextBoxHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		oLog.debug("TextBoxHelper : " + this.driver.hashCode());
		wHelper = new WaitHelper(driver, ObjectRepo.reader);
	}

	public void sendKeys(By locator, String value) {
		wHelper.waitForElementVisible(locator, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		oLog.info("Locator : " + locator + " Value : " + value);
		getElement(locator).sendKeys(value);
	}

	public void clear(By locator) {
		wHelper.waitForElementVisible(locator, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		oLog.info("Locator : " + locator);
		getElement(locator).clear();
	}

	public String getText(By locator) {
		wHelper.waitForElementVisible(locator, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		oLog.info("Locator : " + locator);
		return getElement(locator).getText();
	}

	public void clearAndSendKeys(By locator, String value) {
		wHelper.waitForElementVisible(locator, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
		oLog.info("Locator : " + locator + " Value : " + value);
	}

	public void clearAndSendKeys(WebElement element, String value) {
		wHelper.waitForElementVisible(element, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		element.clear();
		element.sendKeys(value);
		oLog.info("Element : " + element + " Value : " + value);
	}

	public String getText(WebElement element) {
		wHelper.waitForElementVisible(element, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		oLog.info("Locator : " + element);
		return element.getText();
	}

	public void sendKeys(WebElement locator, String value) {
		wHelper.waitForElementVisible(locator, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		oLog.info("Locator : " + locator + " Value : " + value);
		locator.sendKeys(value);
	}
	
	public void sendKeysForKeyEvent(WebElement locator, Keys value) {
		wHelper.waitForElementVisible(locator, Constants.WAIT_EXPLICIT_SEC, Constants.WAIT_POLLING_MS);
		oLog.info("Locator : " + locator + " Value : " + value);
		locator.sendKeys(value);
	}
	
}
