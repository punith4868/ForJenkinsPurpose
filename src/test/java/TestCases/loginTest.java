package TestCases;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import Base.BaseClass;

public class loginTest extends BaseClass{
	 
	@Test(priority=0)
	public void loginValid() {
		 
		 driver.findElement(By.id("input-email")).sendKeys("jhansi4868@gmail.com");
		 driver.findElement(By.id("input-password")).sendKeys("Jhansi@04");
		 driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		 //Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		 
	}
	@Test(priority=1)
	public void invalidCredential() throws InterruptedException {
		 driver.findElement(By.id("input-email")).sendKeys(Utilities.timeStamp.timeStampWithemail());
		 Thread.sleep(3000);
		 driver.findElement(By.id("input-password")).sendKeys("Jhansi@04");
		 driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		 String actualText=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		 System.out.println(actualText);
		 String expectedText="Warning: No match for E-Mail Address and/or Password.";
		// Assert.assertTrue(actualText.contains(expectedText), "passed");
		 
	} 
}
