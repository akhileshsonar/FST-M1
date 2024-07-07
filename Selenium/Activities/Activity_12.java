package test_basic_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_12 {

	public static void main(String[] args) {
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/dynamic-controls");
		System.out.println("Title page is : "+drive.getTitle());
		WebElement Textinput=drive.findElement(By.id("input-text"));
		System.out.println("Text input status "+Textinput.isEnabled());
		if (Textinput.isEnabled()==false) {
			drive.findElement(By.id("toggleInput")).click();
			System.out.println("Text input status "+Textinput.isEnabled());
		}
		drive.quit();
    }

	}


