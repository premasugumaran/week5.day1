package week5.day1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass {
@Test
	public void duplicateLead(String[] args) throws InterruptedException {
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='Email']")).click();
	driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("gmail");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(3000);
	String FirstName= driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']")).getText();
	System.out.println(FirstName);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Duplicate Lead")).click(); 

	driver.findElement(By.className("smallSubmit")).click();
	String DuplicateName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
	System.out.println(DuplicateName);
	if(DuplicateName.equalsIgnoreCase(FirstName))
	{
		System.out.println("captured name is duplicated");
	}
	else {
		System.out.println("Not a duplicate lead");
	}

  
}

}
