
package com.PSC.framework.helper.Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.PSC.framework.helper.Logger.LoggerHelper;
import com.PSC.framework.helper.Navigation.NavigationHelper;
import com.PSC.framework.interfaces.IwebComponent;
import com.PSC.framework.utility.DateTimeHelper;
import com.PSC.framework.utility.ResourceHelper;
import com.google.common.io.Files;

import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @author krana
 *
 *
 */
public class GenericHelper implements IwebComponent {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(GenericHelper.class);
	private NavigationHelper nHelper;

	public GenericHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("GenericHelper : " + this.driver.hashCode());
		nHelper = new NavigationHelper(driver);
	}

	public WebElement getElement(By locator) {
		oLog.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);

		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			oLog.error(re);
			throw re;
		}
	}

	/**
	 * Check for element is present based on locator If the element is present
	 * return the web element otherwise null
	 * 
	 * @param locator
	 * @return WebElement or null
	 */

	public WebElement getElementWithNull(By locator) {
		oLog.info(locator);
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			// Ignore
		}
		return null;
	}

	public boolean IsElementPresentQuick(By locator) {
		boolean flag = driver.findElements(locator).size() >= 1;
		oLog.info(flag);
		return flag;
	}

	public String takeScreenShot(String name) throws IOException {
		if (driver instanceof HtmlUnitDriver) {
			oLog.fatal("HtmlUnitDriver Cannot take the ScreenShot");
			return "";
		}
		File destDir = new File(ResourceHelper.getResourcePath("screenshots/") + DateTimeHelper.getCurrentDate());
		if (!destDir.exists())
			destDir.mkdir();
		File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + name + ".jpg");
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			oLog.error(e);
			throw e;
		}
		oLog.info(destPath.getAbsolutePath());
		screenshot(driver);
		return destPath.getAbsolutePath();
	}

	@Attachment(type = "image/png")
	public static byte[] screenshot(WebDriver driver) {
		try {
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			return Files.toByteArray(screen);
		} catch (IOException e) {
			return null;
		}
	}

	public String takeScreenShot() {
		oLog.info("");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public boolean verifyURL(String url) {
		if (!url.equalsIgnoreCase(nHelper.getCurrentUrl())) {
			oLog.error("URL mis match");
			System.err.println("############");
			System.err.println(url);
			System.err.println(nHelper.getCurrentUrl());
			System.err.println("############");
//			Assert.assertTrue(false, "URL mis match");
			return false;
		}
		return true;
	}
}
