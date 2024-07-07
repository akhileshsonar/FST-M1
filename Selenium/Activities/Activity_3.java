package test_basic_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_3 {

	public static void main(String[] args) {

		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/login-form");
		System.out.println("Home page Title is: "+drive.getTitle());
		WebElement username=drive.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("admin");
		WebElement pass=drive.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys("password");
		WebElement Submit_button=drive.findElement(By.xpath("//button[text()='Log in']"));
		Submit_button.click();
		String message = drive.findElement(By.xpath("//div[@class='ui massive green label']")).getText();
        System.out.println("Login message: " + message);
		drive.quit();

	}

}
