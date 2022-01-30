package week5.day1;
import java.io.IOException;
import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class CreateLead extends BaseClass {
		@BeforeClass
		public void setUp() {
			fileName="CreateLead";
		}
		@Test(dataProvider = "fetchData")
		
		//@Test(dataProvider = "fetchData" , enabled=true,invocationCount = 2,threadPoolSize = 2) 
		public void createLead(String cName, String fName,String lName)  {
	
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
			driver.findElement(By.name("submitButton")).click();
			
		}
		

	}






