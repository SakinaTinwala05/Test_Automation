package com.PSC.helper.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.PSC.framework.helper.BasePageObject.PageBase;
import com.PSC.framework.helper.Button.ButtonHelper;
import com.PSC.framework.helper.TextBox.TextBoxHelper;
import com.PSC.framework.helper.Wait.WaitHelper;
import com.PSC.framework.settings.ObjectRepo;

public class MakeMyTrip extends PageBase {
	
	private WebDriver driver;
	private WaitHelper wH;
	private ButtonHelper bH;
	private TextBoxHelper tH;


	public MakeMyTrip(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wH = new WaitHelper(driver, ObjectRepo.reader);
		bH = new ButtonHelper(driver);
		tH = new TextBoxHelper(driver);
	}
	
	@FindBy(xpath = "//*[@href='https://www.makemytrip.com/flights/']")
	@CacheLookup
	private WebElement Flights;
	
	@FindBy(id = "fromCity")
	@CacheLookup
	private WebElement FromCity;
	
	@FindBy(id = "toCity")
	@CacheLookup
	private WebElement ToCity;
	
	@FindBy(id = "departure")
	@CacheLookup
	private WebElement Departure;

	@FindBy(xpath = "//*[@data-cy='submit']")
	@CacheLookup
	private WebElement Search;

	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void navigateMakeMyTripScreen() {
		System.out.println("URL------------------>" + ObjectRepo.reader.MakeMyTripURL());
		ObjectRepo.driver.get(ObjectRepo.reader.MakeMyTripURL());
	}
	
	public void clickFlights() {
		try {
			bH.click(Flights);
			log("Click on All button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.xpath("//*[@href='https://www.makemytrip.com/flights/']")).click();
		}
	}
	
	public void enterCityFrom(String cityF) {
		try {
			tH.clearAndSendKeys(FromCity, cityF);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("fromCity")).sendKeys(cityF);
		}
	}
	
	WebElement link_Home = driver.findElement(By.linkText("Home"));
    WebElement td_Home = driver
            .findElement(By
            .xpath("//html/body/div"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr"));    
     
    Actions builder = new Actions(driver);
    Action mouseOverHome = builder
            .moveToElement(link_Home)
            .build();
	
	public void enterCityTo(String cityT) {
		try {
			tH.clearAndSendKeys(ToCity, cityT);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("toCity")).sendKeys(cityT);
		}
	}
	
	WebElement link_Home1 = driver.findElement(By.linkText("Home1"));
    WebElement td_Home1 = driver
            .findElement(By
            .xpath("//html/body/div"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr"));    
     
    Actions builder1 = new Actions(driver);
    Action mouseOverHome1 = builder
            .moveToElement(link_Home)
            .build();
	
	public void enterDeparture(String dep) {
		try {
			tH.clearAndSendKeys(Departure, dep);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.id("departure")).sendKeys(dep);
		}
	}
	
	WebElement link_Home2 = driver.findElement(By.linkText("Home2"));
    WebElement td_Home2 = driver
            .findElement(By
            .xpath("//html/body/div"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr/td"
            + "/table/tbody/tr"));    
     
    Actions builder2 = new Actions(driver);
    Action mouseOverHome2 = builder
            .moveToElement(link_Home)
            .build();
	
	public void clickSearch() {
		try {
			bH.click(Search);
			log("Click on All button", false);
			Thread.sleep(1000);
		} catch (Exception e) {
			ObjectRepo.driver.findElement(By.xpath("//*[@data-cy='submit']")).click();
		}
	}
	
	
	public void visibilityMakeMyTripPage() {
		wH.waitForVisibility(Flights);
		
	}
	
}
