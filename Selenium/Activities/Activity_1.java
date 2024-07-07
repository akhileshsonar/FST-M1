package test_basic_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_1 {

	public static void main(String[] args) {

		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net");
		System.out.println("Home page Title is: "+drive.getTitle());
		WebElement Aboutn_us_button=drive.findElement(By.id("about-link"));
		Aboutn_us_button.click();
		String Aboutn_us_title=drive.getTitle();
		System.out.println("About us title is: "+Aboutn_us_title);
		drive.quit();

	}

}
