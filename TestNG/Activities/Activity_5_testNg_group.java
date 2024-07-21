package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_5_testNg_group {

	WebDriver driver;

	@BeforeClass
	public void Setup() {

		driver = new FirefoxDriver();
		driver.get("https://v1.training-support.net/selenium/target-practice");
	}

	@Test(groups = { "HeaderTests", "ButtonTests" })
	public void Test_titile() {
		System.out.println("Title is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Target Practice");
	}

	@Test(dependsOnMethods = { "Test_titile" }, groups = { "HeaderTests" })
	public void HeaderTest1() {
		WebElement header_3 = driver.findElement(By.id("third-header"));
		Assert.assertEquals(header_3.getText(), "Third header");
	}

	@Test(dependsOnMethods = { "Test_titile" }, groups = { "HeaderTests" })
	public void HeaderTest2() {
		WebElement header_3 = driver.findElement(By.id("third-header"));
		Assert.assertEquals(header_3.getCssValue("color"), "rgb(251, 189, 8)");
	}

	@Test(dependsOnMethods = { "Test_titile" }, groups = { "ButtonTests" })
	public void ButtonTest1() {
		WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
		Assert.assertEquals(button1.getText(), "Olive");
	}

	@Test(dependsOnMethods = { "Test_titile" }, groups = { "ButtonTests" })
	public void ButtonTest3() {
		WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
		Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
	}
	@AfterClass
	public void close_browser() {
		
		driver.quit();
	}

}
