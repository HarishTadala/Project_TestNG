package com.harish.login.selenium_automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Css_LinkText {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver w=new ChromeDriver();

		w.get("https://opensource-demo.orangehrmlive.com/");		

		//css locator== tagname#id or #id

		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");

		//css locator== tagname[attribute='value']  or [attribute='value']

		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");

		//css locator== tagname.classname or .classname

		w.findElement(By.cssSelector("input.button")).click();

		Thread.sleep(3000);

		w.findElement(By.linkText("Welcome Paul")).click();

		Thread.sleep(3000);

		w.findElement(By.linkText("Logout")).click();		

		w.quit();

		System.out.println("Login test case Passed !!!");

	}

}
