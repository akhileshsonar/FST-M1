package test_basic_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_10 {

	public static void main(String[] args) {
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/dynamic-controls");
		System.out.println("Title page is : "+drive.getTitle());
		
		WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));
        WebElement check_box = drive.findElement(By.className("willDisappear"));
        
        WebElement Remove_Check_button = drive.findElement(By.id("toggleCheckbox"));
        Remove_Check_button.click();
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("willDisappear")));
        System.out.println("Checkbox is present: " + check_box.isDisplayed());
        
        Remove_Check_button.click();
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Checkbox is present: " + check_box.isDisplayed());
      
        drive.findElement(By.xpath("//input[@class='willDisappear']")).click();
        drive.quit();

	}

}
