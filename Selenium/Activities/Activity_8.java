package test_basic_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_8 {

	public static void main(String[] args) {
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/dynamic-controls");
		WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));

		
		System.out.println("Title page is for dynamic-controls: "+drive.getTitle());
		WebElement Remove_button=drive.findElement(By.id("toggleCheckbox"));
		Remove_button.click();
		WebElement Dynamic_CheckBox=drive.findElement(By.id("dynamicCheckbox"));
		wait.until(ExpectedConditions.invisibilityOf(Dynamic_CheckBox));
		if(Dynamic_CheckBox.isDisplayed()==false) {
			System.out.println("Dynamic_CheckBox "+"false");
		}
		Remove_button.click();
		wait.until(ExpectedConditions.visibilityOf(Dynamic_CheckBox));
		if(Dynamic_CheckBox.isDisplayed()==true) {
			System.out.println("Dynamic_CheckBox "+"TRUE");
		}
	}

}
