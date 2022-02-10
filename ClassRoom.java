package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdown = new Select(source);
		dropdown.selectByVisibleText("Employee");

		WebElement dropdown1 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dropdown2 = new Select(dropdown1);
		dropdown2.selectByValue("IND_INSURANCE");

		WebElement dropdown3 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dropdown4 = new Select(dropdown3);
		dropdown4.selectByIndex(2);

	}
}
