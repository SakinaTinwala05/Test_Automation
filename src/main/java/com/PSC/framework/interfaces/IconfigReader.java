
package com.PSC.framework.interfaces;

import com.PSC.framework.configuration.browser.BrowserType;

public interface IconfigReader {
	
	public BrowserType getBrowser();

	public String LoginURL();
	
	public int getPageLoadTimeOut();

	public int getImplicitWait();

	public int getExplicitWait();

	public int getPollingTime();

	public String LoginURLs();

	public String MakeMyTripURL();

}
