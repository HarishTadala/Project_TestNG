package com.selenium.webobject.inclassroom;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_WindowSize_5 {
	WebDriver w;

	@BeforeTest
	public void beforeTest() throws Exception {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		w.manage().window().maximize();

	}

	@Test
	public void Code_For_WindowSize() throws InterruptedException {


		w.get("https://www.google.co.in/");
		Thread.sleep(3000);

		//Class Dimension

		Dimension d=new Dimension(1400, 900); // width , height
		w.manage().window().setSize(d);
		Thread.sleep(3000);
		w.manage().window().minimize();

	}

	@AfterTest
	public void afterTest() {
	}
}
