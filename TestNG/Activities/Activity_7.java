package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_7 {
	WebDriver driver;
	WebDriverWait wait ;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/login-form");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@DataProvider(name="Credentials")
	public static Object[][] data() {
		
		return new Object[][] {
			{"admin","password","Welcome Back, admin"},
			{"admi","passwor","Invalid Credentials"},
			{"   ","passwor","Invalid Credentials"},
			{"   ","  ","Invalid Credentials"},
			{"admin","  ","Invalid Credentials"},
			{"@admin","password","Invalid Credentials"},
			{"admin","@password","Invalid Credentials"},
		};
	}
	@Test(dataProvider = "Credentials")
	public void LogINtest (String username, String password, String expecetedResult) {
		WebElement userName =driver.findElement(By.id("username"));
		WebElement PassWord =driver.findElement(By.id("password"));
		
		
		userName.clear();
		PassWord.clear();
		
		userName.sendKeys(username);
		PassWord.sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit' and text()='Log in']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
		
        System.out.println("Confirmation massage: " + driver.findElement(By.id("action-confirmation")).getText());
        Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), expecetedResult);
        
	}
	@AfterClass
	public void CloseBroser() {
		driver.quit();
	}

}
