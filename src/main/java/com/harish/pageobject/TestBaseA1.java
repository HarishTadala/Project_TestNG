package com.harish.pageobject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseA1 {

	String url="http://blazedemo.com/";
	WebDriver w;
	SoftAssert sft;

	public void openApplicationURL() {

		w.get(url);
		sft=new SoftAssert();
		String loginTitle = w.getTitle();		
		sft.assertEquals(loginTitle, "BlazeDemo","Title is Wrong !!!");
		System.out.println("Validate page title should be :" +loginTitle);
	}

	public void choosefirst_flight() {
		sft=new SoftAssert();
		String flightLabel = w.findElement(By.xpath("/html/body/div[2]/h3")).getText();
		sft.assertTrue(flightLabel.contentEquals("Flights from Boston to London:"));
		System.out.println("Validate page label :" +flightLabel);
	}

	public void nextpagetittle() {

		sft=new SoftAssert();
		String loginTitle = w.getTitle();		
		sft.assertEquals(loginTitle, "BlazeDemo Purchase","Title is Correct !!!");
		System.out.println("Validate page title :" +loginTitle);
		String nextpageLabel = w.findElement(By.xpath("/html/body/div[2]/h2")).getText();
		sft.assertTrue(nextpageLabel.contentEquals("Your flight from TLV to SFO has been reserved."));
		System.out.println("Validate Page label :" +nextpageLabel);
		String airlineLabel = w.findElement(By.xpath("/html/body/div[2]/p[1]")).getText();
		sft.assertTrue(airlineLabel.contentEquals("United"));
		System.out.println("Validate Airline should be :" +airlineLabel);
		String flightLabel = w.findElement(By.xpath("/html/body/div[2]/p[2]")).getText();
		sft.assertTrue(flightLabel.contentEquals("UA954"));
		System.out.println("Validate flight no should be :" +flightLabel);
	}

	public void confirmingpurchase() {

		sft=new SoftAssert();
		String loginTitle = w.getTitle();		
		sft.assertEquals(loginTitle, "BlazeDemo Confirmation","Title is Wrong !!!");
		System.out.println("Validate page title as :" +loginTitle);
	}

	public void openBrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			w=new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			w=new FirefoxDriver();

		}else if(browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			w=new EdgeDriver();			
		}

		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void closeBrowser() {
		w.quit();
	}

	public void handleInputEvent(WebElement we,String value) {		
		we.clear();
		we.sendKeys(value);		
	}

	public void handleClickEvent(WebElement we) {		
		we.click();		
	}

	public void handleDropDown(WebElement we,String value) {

		Select sel=new Select(we);
		sel.selectByVisibleText(value);
	}

	public void waitForSec(int sec) throws Exception {		
		Thread.sleep(1000 * sec);
	}

	public void handleAlert() {
		try {
			w.switchTo().alert().accept();
		}
		catch(Exception e) {

		}
	}

	public void handleFrame(String frameName) {
		w.switchTo().frame(frameName);
	}


	public String getValidationValue(WebElement we) {

		return we.getText();
	}

	public String getPageTitle() {

		return w.getTitle();
	}

	public void pageScroll() {	
		JavascriptExecutor js=(JavascriptExecutor) w;
		js.executeScript("window.scrollBy(0,300)");
	}

}
