package test_basic_practice;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity_6 {

	public static void main(String[] args) {
		
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/input-events");
		System.out.println("Home page Title is: "+drive.getTitle());
		Actions action =new Actions(drive);
		//left click
		action.keyDown(Keys.LEFT_SHIFT).sendKeys("s").keyUp(Keys.LEFT_SHIFT).release().build().perform();
		action.keyDown(Keys.LEFT_CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.LEFT_CONTROL).release().build().perform();
		drive.quit();
	}

}
