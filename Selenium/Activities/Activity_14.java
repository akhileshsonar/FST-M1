package test_basic_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_14 {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/tables");
		System.out.println("Title page is : "+driver.getTitle());
		
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("Colm size: " + cols.size());
      
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("rows size: " + rows.size());

        WebElement cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("2nd row and 2nd value: " + cellValue.getText());

        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();

        cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("2nd row and 2nd value: " + cellValue.getText());
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("values of the footer is :");
        for(WebElement cell : footer) {
            System.out.println(cell.getText());
        }

        driver.quit();
	}

}
