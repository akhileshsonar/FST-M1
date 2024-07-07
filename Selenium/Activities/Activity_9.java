package test_basic_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_9 {

	public static void main(String[] args) {
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/ajax");
		System.out.println("Title page is : "+drive.getTitle());
		WebElement ChangeContent=drive.findElement(By.cssSelector("button.violet"));
		WebDriverWait wait = new WebDriverWait(drive, Duration.ofSeconds(10));
		ChangeContent.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajax-content']/h1")));
		String h1=drive.findElement(By.xpath("//div[@id='ajax-content']/h1")).getText();
		String h3=drive.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText();
		System.out.println("H1 Text is "+h1);
		System.out.println("H3 Text before change "+h3);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='ajax-content']/h3"),"I'm late!"));
		String h3_new=drive.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText();
		System.out.println("H3 Text after change "+h3_new);
		drive.quit();
	}

}
