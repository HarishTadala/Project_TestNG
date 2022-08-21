package com.selenium.webobject;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_IFrame_3 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w=new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test
	public void Code_For_IFrame_Test() throws Exception{

		w.get("https://groww.in/calculators/emi-calculator/");

		WebElement framePage=w.findElement(By.cssSelector("iframe[data-lazy-type='iframe']"));

		w.switchTo().frame(framePage);

		Thread.sleep(2000);

		w.findElement(By.id("inputAmount")).clear();
		w.findElement(By.id("inputAmount")).sendKeys("400000");
		w.findElement(By.id("inputRoi")).clear();
		w.findElement(By.id("inputRoi")).sendKeys("9");
		w.findElement(By.id("inputYears")).clear();
		w.findElement(By.id("inputYears")).sendKeys("8");

	}

	@AfterTest
	public void afterTest() {
		//	w.quit();
	}

}
