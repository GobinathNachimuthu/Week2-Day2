package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
		// 1 Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		// 2 Enter the username
		// 3 Enter the password
		driver.findElement(By.id("username")).sendKeys("Democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// 4 Click Login
		// 5 Click crm/sfa link
		// 6 Click Leads link
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		// 7 Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//a[text() = 'Leads']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name = 'firstName'])[3]")).sendKeys("gobi");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[@class = 'linktext'])[4]")).click();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		if ((driver.getTitle()).contains("View Lead | opentaps CRM")) {
			System.out.println("Title is Matched");
		} else {
			System.out.println("Title is Not Match");
		}
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		WebElement companyname = driver.findElement(By.xpath("//input[@id ='updateLeadForm_companyName']"));
		companyname.clear();
		companyname.sendKeys("a");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);
		String companyname1 = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		System.out.println(companyname1);
		if (companyname1.contains("a")) {
			System.out.println("Company is Name Updated");
		} else {
			System.out.println("Company is Name Not Updated");
		}
		driver.close();
	}

}
