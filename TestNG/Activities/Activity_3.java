package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_3 {

	WebDriver driver;

	@BeforeClass
	public void Set_config() {
		driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");
	}

	@Test
	public void Log_in() {
		WebElement userName =driver.findElement(By.id("username"));
		WebElement PassWord =driver.findElement(By.id("password"));
		userName.sendKeys("admin");
		PassWord.sendKeys("password");
		
		driver.findElement(By.xpath("//button[@type='submit' and text()='Log in']")).click();
		String massage =driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Confirmation Massage is "+massage);
		Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), massage);
	}

	

	@AfterClass
	public void afterMethod() {
		driver.close();
	}

}
