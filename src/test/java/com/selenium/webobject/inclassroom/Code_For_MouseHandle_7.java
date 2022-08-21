package com.selenium.webobject.inclassroom;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_MouseHandle_7 {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().window().maximize();	
	}

	@Test
	public void Code_For_MouseHandle_Test() throws Exception {
		
		

	
	/*	w.get("https://www.ebay.com/");	
		
		w.findElement(By.linkText("Electronics")).click();
		Thread.sleep(2000);
		
		w.navigate().back();
		        
		Thread.sleep(2000);
		
		WebElement ElectronicsLink=w.findElement(By.linkText("Electronics"));
		
		Actions a=new Actions(w);
		
		a.moveToElement(ElectronicsLink).build().perform();
		
		Thread.sleep(2000);
		
		WebElement appleLink=w.findElement(By.linkText("Apple"));
		
		a.click(appleLink).build().perform();
		
		
		WebElement rightClickEvent_CellPhones_SmartWatches=w.findElement(By.linkText("Cell Phones, Smart Watches & Accessories"));
		
		a.contextClick(rightClickEvent_CellPhones_SmartWatches).build().perform();
		
		*/
		
		
	//	a.doubleClick(appleLink).build().perform();
		
		w.get("http://crossbrowsertesting.github.io/drag-and-drop.html");
		
		Thread.sleep(2000);
		
		WebElement draggable=w.findElement(By.id("draggable"));
		WebElement droppable=w.findElement(By.id("droppable"));

		Actions drag_drop=new Actions(w);
		drag_drop.dragAndDrop(draggable, droppable).build().perform();

		
		
	}

	@AfterTest
	public void afterTest() {
	}
}
