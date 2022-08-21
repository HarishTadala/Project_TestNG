package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium99 {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("http://www.testyou.in/Login.aspx");	

		driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");

		driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");

		driver.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();		

		Thread.sleep(3000);

		driver.findElement(By.className("signout")).click();

		driver.quit();

	}

}
