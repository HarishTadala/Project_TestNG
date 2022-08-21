package com.harish.login.selenium_automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws Exception {

		// interfaceName instance= new implementationClassName();
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver(); //open a blank chrome browser

		driver.get("https://demo.testfire.net/login.jsp"); //Enter URL to open application

		driver.findElement(By.id("uid")).sendKeys("admin"); //Enter the username

		driver.findElement(By.id("passw")).sendKeys("admin"); //Enter the password

		driver.findElement(By.name("btnSubmit")).click(); //Click on login button		

		Thread.sleep(3000); // Wait for 3 sec = 3000 millisec

		driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click(); //Click on the Sign out link

		System.out.println("Admin has successfully Logged-In : Passed"); //Print the comment

		driver.quit();//It will quit the browser

	}

}
