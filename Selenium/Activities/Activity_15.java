package test_basic_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_15 {

	public static void main(String[] args) {


		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/dynamic-attributes");
		System.out.println("Home page Title is: "+drive.getTitle());
		WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));
		
		WebElement userName=drive.findElement(By.xpath("//input[starts-with(@class,'username-')]"));
		userName.sendKeys("admin");
		
		WebElement PassWord=drive.findElement(By.cssSelector("input[class^='password-']"));
		PassWord.sendKeys("password");
		
		WebElement submitButton=drive.findElement(By.xpath("//button[@type='submit' and text()='Log in']"));
		submitButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        System.out.println("Confirmation massage: " + drive.findElement(By.id("action-confirmation")).getText());
        drive.quit();

	}

}
