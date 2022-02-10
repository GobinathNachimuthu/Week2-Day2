package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[]args) throws InterruptedException {
		//1	Launch the browser
		WebDriverManager.chromedriver().setup();;
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("Democsr");
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		//5	Click crm/sfa link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//8	Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		//9	Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9786298580");
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//11	Capture lead ID of First Resulting lead
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).getText();
		//12	Click First Resulting lead
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String Text = driver.findElement(By.className("x-paging-info")).getText();

		if (Text.contains("No records to be display")) {
			System.out.println("Text is Matched");
		} else {
			System.out.println("Text is not Match");
		}
		driver.close();
		
		
	}
}

		
		
		//13	Click Delete
		//14	Click Find leads
		//15	Enter captured lead ID
		//16	Click find leads button
		//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		//18	Close the browser (Do not log out)
		
		
	













