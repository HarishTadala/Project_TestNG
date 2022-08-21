package assignment;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Policyx {
	WebDriver w;

	@BeforeTest
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Validate Label on page")
	public void loginTest() {

		w.get("https://www.policyx.com/");

		String loginPageLabel = w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/div[1]/h1")).getText();
		Assert.assertTrue(loginPageLabel.contains("India's Most Trusted Insurance Portal"), "Label is correct !!!");

		//assertEquals("specific text", driver.findElement(By.xpath("xpath")).getText());
		//		w.findElement(By.id("uid")).sendKeys("admin");
		//		w.findElement(By.id("passw")).sendKeys("admin");
		//		w.findElement(By.name("btnSubmit")).click();

	}

	//	@Test(priority = 1, description = "Validate title contains "Insurance" text")
	//	public void logoutTest() throws Exception {
	//
	//		Thread.sleep(3000);
	//
	//		String homeTitle = w.getTitle();
	//		Assert.assertEquals(homeTitle, "Altoro Mutual", "Title is wrong !!!");
	//
	//		String homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
	//		Assert.assertTrue(homePageLabel.contains("Admin"), "UserName label is wrong !!!");
	//
	//		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	//	}

	@AfterTest
	public void closeBrowser() {

		w.quit();
	}


}
