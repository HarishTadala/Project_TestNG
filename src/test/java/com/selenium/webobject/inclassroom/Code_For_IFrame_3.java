package com.selenium.webobject.inclassroom;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_IFrame_3 {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();

	}

	@Test
	public void Code_For_IFrame_Test() throws Exception{

		w.get("http://demo.automationtesting.in/Frames.html");

		w.switchTo().frame("singleframe");

		w.findElement(By.xpath("/html/body/section/div/div/div/input")).clear();
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
	}

	@AfterTest
	public void afterTest() {
		//	w.quit();
	}
}
