package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Optional {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		driver.findElement(By.id("input-username")).sendKeys("Vasanth47");
		driver.findElement(By.id("input-username")).sendKeys("Venu");
		driver.findElement(By.id("input-lastname")).sendKeys("Vasanth");
		driver.findElement(By.id("input-email")).sendKeys("venuvasanth4747@gmail.com");
		WebElement COUNTRY = driver.findElement(By.id("input-country"));
		Select dropdown = new Select(COUNTRY);
		dropdown.selectByVisibleText("India");
		driver.findElement(By.id("input-password")).sendKeys("vVP4747");
		
}
}

