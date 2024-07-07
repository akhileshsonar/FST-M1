package test_basic_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity_5 {

	public static void main(String[] args) {
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/input-events");
		System.out.println("Home page Title is: "+drive.getTitle());
		Actions action =new Actions(drive);
		//left click
		
		action.click().pause(1000).build().perform();
		String cubeValue_left=drive.findElement(By.className("active")).getText();
		System.out.println("left click cube value is: "+cubeValue_left);
		//double click
		
		action.doubleClick().pause(1000).build().perform();
		String cubeValue_double=drive.findElement(By.className("active")).getText();
		System.out.println("double click cube value is: "+cubeValue_double);
		
		//right click
		action.contextClick().pause(1000).build().perform();
		String cubeValue_right=drive.findElement(By.className("active")).getText();
		System.out.println("right click cube value is: "+cubeValue_right);
		
		drive.quit();
	}

}
