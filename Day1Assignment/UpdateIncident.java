package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends IncidentBaseClass {

	@Test
	public void updateIncident() throws InterruptedException, IOException {

		WebElement findElement = driver.findElement(By.id("incident_table_header_search_control"));
		findElement.sendKeys("INC0000051");
		findElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td[3]/a")).click();
		WebElement dd =driver.findElement(By.id("incident.urgency"));
		Select dropdown = new Select(dd);
		dropdown.selectByValue("1");
		WebElement dd1 =driver.findElement(By.id("incident.state"));
		Select dropdown1 = new Select(dd1);
		dropdown1.selectByValue("2");
		driver.findElement(By.id("sysverb_update_bottom")).click();	

		
		}
}