
package com.PSC.constants;

import com.PSC.framework.settings.ObjectRepo;

public class Constants {
	public static final int WAIT_EXPLICIT_SEC = ObjectRepo.reader.getExplicitWait();
	public static final int WAIT_POLLING_MS = ObjectRepo.reader.getPollingTime();
	public static final String URL = ObjectRepo.reader.LoginURL() + "app/";
	public static final int LOADER_WAIT = 180;
	public static final boolean IS_HEADLESS = Boolean.parseBoolean(System.getProperty("isHeadless"));
	public static final String email = "Sakina12@gmail.com";
	public static final String password = "Sakina@123";
	public static final String FromCity = "Ahmedabad";
	public static final String ToCity = "Surat";
	public static final String Departure = "10Feb";
}