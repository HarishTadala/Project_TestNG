package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");		

		WebElement s= driver.findElement(By.xpath("//input[@name='q']"));

		s.sendKeys("Snapdeal");

		s.submit();

		driver.findElement(By.linkText("Wikipedia")).click();

		driver.findElement(By.cssSelector("input[name='search']")).sendKeys("News");

		driver.findElement(By.cssSelector("input#searchButton")).click();

		driver.findElement(By.linkText("View history")).click();

	}

}
