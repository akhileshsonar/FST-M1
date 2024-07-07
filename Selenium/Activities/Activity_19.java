package test_basic_practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_19 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/javascript-alerts");
		System.out.println("Title is: " + driver.getTitle());

		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert = driver.switchTo().alert();

		String mag = confirmAlert.getText();
		System.out.println("Text in alert: " + mag);
		Thread.sleep(3000);
		confirmAlert.accept();
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
		confirmAlert.dismiss();
		driver.quit();

	}

}
