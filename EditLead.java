package week5.day1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass{
	@Test
	public void editLead() throws InterruptedException {
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Divya");
		

		
		//driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Divya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement comp=driver.findElement(By.id("updateLeadForm_companyName"));
		//comp.sendKeys("amdivya.v@gmail.com"); 
		String companyname=comp.getAttribute("value");
		System.out.println(companyname);
		comp.clear();
		comp.sendKeys("SVS",Keys.TAB);
		
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();


		
		

	}

}
