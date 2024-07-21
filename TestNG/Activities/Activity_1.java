package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_1 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://v1.training-support.net/");
	}
	@Test(priority=1)
	public void homePageTest() {
		Assert.assertEquals(driver.getTitle(), "Training Support");
		driver.findElement(By.id("about-link")).click();
	}
	@Test(priority=2)
	public void AboutPageTest() {
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	@AfterClass
	public void CloseBroser() {
		//driver.quit();
	}

}
