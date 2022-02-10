package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook1 {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Gobinath");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nachimuthu");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9786298580");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Gobi@8580");
		Select date = new Select (driver.findElement(By.id("day")));
		date.selectByValue("25");
		Select month = new Select (driver.findElement(By.id("month")));
		month.selectByValue("6");
		Select year = new Select (driver.findElement(By.id("year")));
		year.selectByValue("1998");
		driver.findElement(By.xpath("//label[text()='Female']")).click();
	}

}
	