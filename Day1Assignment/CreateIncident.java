package week5.day1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident extends IncidentBaseClass {
public String incidentNum;
	@Test
		public void createIncident() throws InterruptedException, IOException {

			driver.findElement(By.id("sysverb_new")).click();
			driver.findElement(By.id("sys_display.incident.caller_id")).click();
			driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			for (String string : windowHandles) {
			}
			List<String> child=new ArrayList<String>(windowHandles);
			String string = child.get(1);
			driver.switchTo().window(string);
			driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
			driver.switchTo().window(child.get(0));
			driver.switchTo().frame("gsft_main");

			driver.findElement(By.id("incident.short_description")).sendKeys("Hi Iam from TestLeaf");
			Thread.sleep(3000);
			
			WebElement searchnumber = driver.findElement(By.xpath("//input[@id='incident.number']"));
			String incidentNum = searchnumber.getAttribute("value");
			System.out.println("Incident Number : " + incidentNum);
			driver.findElement(By.id("sysverb_insert_bottom")).click();
			
			WebElement search1 = driver.findElement(By.xpath("//input[@class='form-control']"));
			search1.sendKeys(incidentNum);
			search1.sendKeys(Keys.ENTER);
			String inciNum = driver.findElement(By.xpath("//td[@class='vt']/a")).getText();
			if(inciNum.equals(incidentNum)) {
				System.out.println("The incident creation is Successful");
			}else {
				System.out.println("The incident creation is unsuccessful");
			}

			 
	}
	
}