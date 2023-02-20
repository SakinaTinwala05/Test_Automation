
package com.PSC.framework.helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.PSC.framework.configreader.PropertyFileReader;
import com.PSC.framework.configuration.browser.BrowserType;
import com.PSC.framework.configuration.browser.ChromeBrowser;
import com.PSC.framework.configuration.browser.HtmlUnitBrowser;
import com.PSC.framework.configuration.browser.IExploreBrowser;
import com.PSC.framework.configuration.browser.PhantomJsBrowser;
import com.PSC.framework.exception.NoSuitableDriverFoundException;
import com.PSC.framework.helper.Generic.GenericHelper;
import com.PSC.framework.helper.Logger.LoggerHelper;
import com.PSC.framework.settings.ObjectRepo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;

public class InitializeWebDriver {

	public static String parent;
	private Logger oLog = LoggerHelper.getLogger(InitializeWebDriver.class);

	public InitializeWebDriver(PropertyFileReader reader) {
		ObjectRepo.reader = reader;
	}

	public WebDriver standAloneStepUp(BrowserType bType) throws Exception {
		try {
			oLog.info(bType);
			switch (bType) {
			case Chrome:
				ChromeBrowser chrome = new ChromeBrowser();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());
//			case Firefox:
//				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
//				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());
			case HtmlUnitDriver:
				HtmlUnitBrowser htmlUnit = HtmlUnitBrowser.class.newInstance();
				return htmlUnit.getHtmlUnitDriver(htmlUnit.getHtmlUnitDriverCapabilities());
			case Iexplorer:
				IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
				return iExplore.getIExplorerDriver(iExplore.getIExplorerCapabilities());
			case PhantomJs:
				PhantomJsBrowser jsBrowser = PhantomJsBrowser.class.newInstance();
				return jsBrowser.getPhantomJsDriver(jsBrowser.getPhantomJsService(),
						jsBrowser.getPhantomJsCapability());
			default:
				throw new NoSuitableDriverFoundException(" Driver Not Found : " + ObjectRepo.reader.getBrowser());
			}
		} catch (Exception e) {
			oLog.equals(e);
			throw e;
		}
	}

	@Before
	public void before() throws Exception {
		setUpDriver(ObjectRepo.reader.getBrowser());
		oLog.info(ObjectRepo.reader.getBrowser());
	}

	@After
	public void after(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order = 4, value = "@iexplorer")
	public void beforeExplorer() throws Exception {
		setUpDriver(BrowserType.Iexplorer);
		oLog.info(BrowserType.Iexplorer);
	}

	@After(order = 4, value = "@iexplorer")
	public void afterExplorer(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order = 3, value = "@firefox")
	public void beforeFirefox() throws Exception {
		setUpDriver(BrowserType.Firefox);
		oLog.info(BrowserType.Firefox);
	}

	@After(order = 3, value = "@firefox")
	public void afterFirefox(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order = 2, value = "@chrome")
	public void beforeChrome() throws Exception {
		setUpDriver(BrowserType.Chrome);
		oLog.info(BrowserType.Chrome);
	}

	@After(order = 2, value = "@chrome")
	public void afterChrome(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order = 1, value = "@phantomjs")
	public void beforePhantomjs() throws Exception {
		setUpDriver(BrowserType.PhantomJs);
		oLog.info(BrowserType.PhantomJs);
	}

	@After(order = 1, value = "@phantomjs")
	public void afterPhantomjs(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	public void setUpDriver(BrowserType bType) throws Exception {
		ObjectRepo.driver = standAloneStepUp(bType);
		oLog.debug("InitializeWebDrive : " + ObjectRepo.driver.hashCode());
		ObjectRepo.driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		ObjectRepo.driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.getImplicitWait(), TimeUnit.SECONDS);
		ObjectRepo.driver.manage().window().maximize();
		String parent = ObjectRepo.driver.getWindowHandle();
		ObjectRepo.driver.switchTo().window(parent);
	}

	public void tearDownDriver(Scenario scenario) throws Exception {
		try {
			if (ObjectRepo.driver != null) {
				if (scenario.isFailed()) {
					final String screenshot = new GenericHelper(ObjectRepo.driver).takeScreenShot(scenario.getName());
					scenario.attach(screenshot, "image/png", scenario.getName() + "_Failure_Screenshot");
				}

				ObjectRepo.driver.quit();
				ObjectRepo.reader = null;
				ObjectRepo.driver = null;
				oLog.info("Shutting Down the driver");
			}
		} catch (Exception e) {
			oLog.error(e);
			throw e;
		}
	}

	private static URL appiumURL;
	public static String appiumServer = "127.0.0.1";
	public static int appiumPort = 4723;

	public static DesiredCapabilities setCapabilitiesAndroid(String AppName, String appPackage, String appActivity) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "emulator-5554");
		File file = new File(
				System.getProperty("user.dir") + File.separator + "applications" + File.separator + AppName);
		capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("newCommandTimeout", 1000);
//		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("autoGrantPermissions", true);
//		capabilities.setCapability("unicodeKeyboard", true);
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			capabilities.setCapability("autoAcceptAlerts", true);
		}
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("noReset", false);
		return capabilities;
	}

	public static AndroidDriver<MobileElement> launchApp(String AppName, String appPackage, String appActivity) {
		try {
			appiumURL = new URL("http://" + appiumServer + ":" + appiumPort + "/wd/hub");
			DesiredCapabilities cap = setCapabilitiesAndroid(AppName, appPackage, appActivity);
			return new AndroidDriver<MobileElement>(appiumURL, cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
