package com.selenium.webobject.inclassroom;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		// Count number of radio button on web page.

		List<WebElement> radioButton=w.findElements(By.name("radiooptions"));
		System.out.println("Number of radio button on page is : "+radioButton.size());


		// Count number of checkbox on web page.

		List<WebElement> checkBox=w.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Number of checkbox on page is : "+checkBox.size());

		// Count number of Dropdown on web page.

		List<WebElement> dropDown=w.findElements(By.tagName("select"));		
		System.out.println("Number of dropdown on page is : "+dropDown.size());


		// Count number of links on web page.

		List<WebElement> links=w.findElements(By.tagName("a"));		
		System.out.println("Number of links on page is : "+links.size());

		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}
}
