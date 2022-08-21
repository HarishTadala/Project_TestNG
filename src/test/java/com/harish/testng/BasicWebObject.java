package com.harish.testng;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject  {
	WebDriver w;

	@BeforeTest
	public void preCondition() { 

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();

	}

	@Test(priority = 0, description = "Handle textbox")
	public void handleTextBox() {

		w.get("http://demo.automationtesting.in/Register.html");

		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Steve");

		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");

		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).clear();
		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("123 / B1, Sample testing address");


		w.findElement(By.cssSelector("input[type='email']")).clear();
		w.findElement(By.cssSelector("input[type='email']")).sendKeys("Jones@test.com");

		w.findElement(By.cssSelector("input[type='tel']")).clear();
		w.findElement(By.cssSelector("input[type='tel']")).sendKeys("8989898989");

	}

	@Test(priority = 1, description = "Handle radio button and checkbox")
	public void handleRadioCheckbox() {

		w.findElement(By.cssSelector("input[value='FeMale']")).click();

		w.findElement(By.id("checkbox1")).click();

		w.findElement(By.id("checkbox3")).click();
	}


	@Test(priority = 2, description = "Handle drop down list")
	public void handleDropDownList() {

		WebElement Skills=w.findElement(By.id("Skills"));

		Select sel=new Select(Skills);

		//	sel.selectByIndex(4);// 9 index - C  // 4 index - Android

		//	sel.selectByValue("Analytics"); // Select - > Option tag

		sel.selectByVisibleText("Java");



	}


	@Test(priority = 4, description = "Print drop down list")
	public void printValueFromDropDown() {

		WebElement monthList=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));

		Select sel=new Select(monthList);


		List <WebElement> elementFromDropDown=sel.getOptions();

		System.out.println("\n Print Months : \n");
		for(int i=1;i<elementFromDropDown.size();i++) {

			//elementFromDropDown[0] = "Jan"	

			System.out.println(elementFromDropDown.get(i).getText());


		}

	}


	@AfterTest
	public void postCondition() {

		//w.quit();
	}
}
