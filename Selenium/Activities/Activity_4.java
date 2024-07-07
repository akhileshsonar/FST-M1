package test_basic_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_4 {

	public static void main(String[] args) {
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/target-practice");
		System.out.println("Home page Title is: "+drive.getTitle());
		String header_3= drive.findElement(By.xpath("//h3[@id='third-header']")).getText();
		System.out.println("Header 3 is: "+header_3);
		
		String header_5= drive.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
		System.out.println("Header 5 color is: "+header_5);
		
		String voilets= drive.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
		System.out.println("class for voilets is: "+voilets);
		
		String grey= drive.findElement(By.xpath("//button[text()='Grey']")).getText();
		System.out.println("text for grey is: "+grey);
		drive.quit();

	}

}
