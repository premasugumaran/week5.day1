package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentBaseClass {
	public static  ChromeDriver driver;
	public static String incidentNum;
	@BeforeMethod (alwaysRun = true)
	public void beforeMethod() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev68398.service-now.com/login.do?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//driver.switchTo().frame("gsft_main");
		//driver.findElement(By.xpath("//button[@class='button-text']")).click();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Venkat@30");
		driver.findElement(By.id("sysverb_login")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.id("filter")).sendKeys("incidents");
		Thread.sleep(5000);
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a[1]")).click();
		Thread.sleep(2000);
		
		
		
	}
@AfterMethod()

public void afterMethod() {
driver.close();
}

}