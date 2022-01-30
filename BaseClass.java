package week5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public ChromeDriver driver;
	 public String fileName;
	 @Parameters({"url","userName","password"})
	  @BeforeMethod(alwaysRun = true)
	  public void beforeMethod(String url,String name,String pwd) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("username")).sendKeys(name);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.className("decorativeSubmit")).click();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }
	  
	  @DataProvider(name="fetchData")
	  public String[] [] sendData() throws IOException{
	  return ReadData.readData(fileName);
	  }



}
