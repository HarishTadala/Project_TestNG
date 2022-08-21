package com.harish.testcases;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Data_Driven_Assignment {

	WebDriver w;
	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell firsttnumber,secondnumber,operator,outputvalue;

	@BeforeTest
	public void openBrowser() throws Exception{

		WebDriverManager.chromedriver().setup();
		w=new ChromeDriver();
		w.manage().window().maximize();

		df=new DataFormatter();
		fi=new FileInputStream(".\\TestData\\AssignmentExcell.xlsx");		
		wb=new XSSFWorkbook(fi);
		sht=wb.getSheetAt(0);

	}

	@Test(priority = 0, description = "validate arithmetic operation")
	public void verifyoutputvalue() throws Exception {

		int rowCount=sht.getLastRowNum();

		for(int i=1;i<=rowCount;i++) {

			//i - > row index

			row=sht.getRow(i);		  

			firsttnumber=row.getCell(0);
			secondnumber=row.getCell(1);
			operator=row.getCell(2);
			outputvalue=row.getCell(3);

			w.get("https://juliemr.github.io/protractor-demo/");

			w.findElement(By.xpath("/html/body/div/div/form/input[1]")).clear();
			w.findElement(By.xpath("/html/body/div/div/form/input[1]")).sendKeys(df.formatCellValue(firsttnumber).toString());

			w.findElement(By.xpath("/html/body/div/div/form/input[2]")).clear();
			w.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys(df.formatCellValue(secondnumber).toString());

			WebElement operatorsign=w.findElement(By.xpath("/html/body/div/div/form/select"));
			Select opearatorDropDown=new Select(operatorsign);
			opearatorDropDown.selectByVisibleText(df.formatCellValue(operator).toString());	  

			w.findElement(By.id("gobutton")).click();

			Thread.sleep(4000);

			String Result = w.findElement(By.cssSelector("h2.ng-binding")).getText();
			System.out.println("Result value : " +Result);
			Assert.assertTrue(Result.contains(df.formatCellValue(outputvalue)),"output Value is different !!!");
		}
	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}
}
