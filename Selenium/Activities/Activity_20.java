package test_basic_practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_20 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        System.out.println("Home page title: " + driver.getTitle());

        driver.findElement(By.id("prompt")).click();

        Alert promtAlert = driver.switchTo().alert();
        String alertText = promtAlert.getText();
        System.out.println("Text in alert: " + alertText);

        promtAlert.sendKeys("Test Alert");

        promtAlert.accept();
        driver.quit();
    }
}
