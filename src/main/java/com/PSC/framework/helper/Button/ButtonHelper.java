
package com.PSC.framework.helper.Button;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PSC.framework.helper.Logger.LoggerHelper;
import com.PSC.framework.helper.Wait.WaitHelper;
import com.PSC.framework.interfaces.IwebComponent;
import com.PSC.framework.settings.ObjectRepo;

/**
 * @author krana
 *
 */
public class ButtonHelper implements IwebComponent {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(ButtonHelper.class);
	private WaitHelper wHelper;

	public ButtonHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("Button Helper : " + this.driver.hashCode());
		wHelper = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);
	}

	public void click(By locator) {
		wHelper.waitForElementToBeClickable(locator);
		click(driver.findElement(locator));
		oLog.info(locator);
	}

	public void click(WebElement element) {
		wHelper.waitForElementToBeClickable(element);
		element.click();
		oLog.info(element);
	}
	
	
}
