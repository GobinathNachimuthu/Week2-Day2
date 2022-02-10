package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// 1 Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://leaftaps.com/opentaps/control/main");
		Thread.sleep(2000);

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
		// 8 Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		// 9 Enter Email
		driver.findElement(By.xpath("//input[contains(@name,'emailAddress')]")).sendKeys("gobi@gmail.com");
		// 10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// 11 Capture name of First Resulting lead
		Thread.sleep(3000);
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).getText();
		Thread.sleep(3000);
		// 12 Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
		// 13 Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Duplicate Lead | opentaps CRM")) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title did not match");
		}
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(2000);
		String Name1 = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		String Name2 = driver.findElement(By.xpath("//span[@id='viewLead_lastName_sp']")).getText();
		System.out.println(Name1 + Name2);
		if ((Name1 + Name2).equals("dd")) {
			System.out.println("duplicated lead name is same as captured name");
		} else {
			System.out.println("duplicated lead name is not same as captured name");
		}
		driver.close();
	}

}
