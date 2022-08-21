package com.harish.testcases;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDriven_DataProvider_Assignment {
	WebDriver w;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "5", "5","+"}, 
			new Object[] { "6", "2","-"},  
			new Object[] { "3", "3","*"},  
			new Object[] { "5", "2","/"}, 
		};
	}

	@BeforeTest
	public void preCondition() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	public void arithmeticoperation_Test(String firsttnumber,String secondnumber,String operator) throws Exception {

		w.get("https://juliemr.github.io/protractor-demo/");

		w.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
		w.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys(firsttnumber);

		w.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
		w.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys(secondnumber);

		WebElement frequency = w.findElement(By.xpath("/html/body/div/div/form/select"));
		Select frequencyDropDown = new Select(frequency);
		frequencyDropDown.selectByVisibleText(operator);

		w.findElement(By.id("gobutton")).click();

		Thread.sleep(2000);

		String Result = w.findElement(By.cssSelector("h2.ng-binding")).getText();
		System.out.println("Result value : " +Result);

	}

	@AfterTest
	public void postCondition() {

		w.quit();
	}

}
