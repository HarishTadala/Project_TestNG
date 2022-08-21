package com.selenium.webobject.inclassroom;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_WindowTab_8  {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		w.manage().window().maximize();	
		
	}

		
	@Test(priority=0,description="Test case to handle Flipkart Tab")
	public void tabFlipkart() throws Exception {
		
		
		w.get("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines/fully-automatic-front-load~function/pr?sid=j9e%2Cabm%2C8qx&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Fully%20Automatic%20Front%20Load");
		
		w.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a")).click();
		
        Thread.sleep(2000);
        
         
      Set <String> windowsID=w.getWindowHandles();
      
      System.out.println(windowsID);
      
     Object winIDs[]=windowsID.toArray();
     
     System.out.println(winIDs[0].toString());
     System.out.println(winIDs[1].toString());
     
     
     w.switchTo().window(winIDs[0].toString());
     System.out.println("Window 1 : "+w.getTitle());
     
     Thread.sleep(3000);
      
     w.switchTo().window(winIDs[1].toString());
     System.out.println("Window 2 : "+w.getTitle());
     
     Thread.sleep(3000);
     
     w.switchTo().window(winIDs[0].toString());
     System.out.println("Window 1 : "+w.getTitle());
     
     Thread.sleep(3000);
      
     w.switchTo().window(winIDs[1].toString());
     System.out.println("Window 2 : "+w.getTitle());

	}
	@AfterTest
	public void afterTest() {
		
		w.quit();
		
	}

}
