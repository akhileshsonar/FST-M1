package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_2 {

	WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice");
	}

	@Test
	public void Test_getTitle() {
		Assert.assertEquals(driver.getTitle(), "Target Practice");
		System.out.println("Title is: " + driver.getTitle());
	}

	@Test
	public void Test_button() {
		WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "black");
	}

	@Test(enabled = false)
	public void Test_for_skip() {
		String subHeading = driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subHeading.contains("Practice"));
	}

	@Test
	public void testCase4() {
		throw new SkipException("Skipping test case");
	}

	@AfterTest
	public void afterMethod() {
		driver.close();
	}

}
