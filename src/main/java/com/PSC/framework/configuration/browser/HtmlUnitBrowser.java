
package com.PSC.framework.configuration.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author krana
 *
 */
public class HtmlUnitBrowser {

	public Capabilities getHtmlUnitDriverCapabilities() {
		DesiredCapabilities unit = new DesiredCapabilities();
		return unit;
	}

	public WebDriver getHtmlUnitDriver(Capabilities cap) {
		return new HtmlUnitDriver(cap);
	}

}
