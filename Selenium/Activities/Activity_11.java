package test_basic_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_11 {

	public static void main(String[] args) {
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/dynamic-controls");
		System.out.println("Title page is : "+drive.getTitle());
		

        WebElement checkbox = drive.findElement(By.name("toggled"));
        checkbox.click();
        
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        checkbox.click();
        
        System.out.println("Checkbox is Unselected: " + checkbox.isSelected());
        drive.quit();
    }

	}


