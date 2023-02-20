package com.PSC.framework.configreader;

import java.util.Properties;

import com.PSC.framework.configuration.browser.BrowserType;
import com.PSC.framework.interfaces.IconfigReader;
import com.PSC.framework.utility.ResourceHelper;

public class PropertyFileReader implements IconfigReader {

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("configfile/" + "config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String LoginURL() {
		return prop.getProperty("LoginURL");
	}
	
	@Override
	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

	@Override
	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	@Override
	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplicitWait"));
	}

	@Override
	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	@Override
	public int getPollingTime() {
		return Integer.parseInt(prop.getProperty("PollingTime"));
	}

	@Override
	public String LoginURLs() {
		return prop.getProperty("LoginURLs");
	}
	
	@Override
	public String MakeMyTripURL() {
		return prop.getProperty("MakeMyTripURL");
	}
}

