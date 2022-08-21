package com.selenium.webobject.inclassroom;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_Screenshot_10 {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		w.manage().window().maximize();	
		
		
	}

	@Test
	public void Code_For_Screenshot() throws Exception {


		
	
		String screenshotPath=".\\Screenshot\\SeleniumHomePage.png";  //.gif .jpg .png
		
		w.get("https://www.selenium.dev/");

		
       TakesScreenshot ts=(TakesScreenshot) w;	       
       File f=ts.getScreenshotAs(OutputType.FILE);       
       FileUtils.copyFile(f, new File(screenshotPath));
		
	   Thread.sleep(2000);
		
        
		/*
		  
		 * For FileUtils add dependencies in pom.xml.
		 
		  <dependency>
		  
		   <groupId>commons-io</groupId>
		 <artifactId>commons-io</artifactId> 
		 <version>2.6</version>
		 
		    </dependency>
		 
		 
		 * 
		 */

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
