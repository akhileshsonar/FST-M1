package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity_6 {

	WebDriver driver;

	@BeforeClass
	public void Setup() {

		driver = new FirefoxDriver();
		driver.get(" https://v1.training-support.net/selenium/login-form");
	}
	 @Test
	    @Parameters({"username", "password"})
	    public void Activity6(String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	        Assert.assertEquals(loginMessage, "Welcome Back, admin");
	    }
	@AfterClass
	public void close_browser() {
		
		driver.quit();
	}

}
