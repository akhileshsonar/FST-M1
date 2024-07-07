package test_basic_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_13 {

	public static void main(String[] args) {
		
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/tables");
		System.out.println("Title page is : "+drive.getTitle());
		
		List<WebElement> T_1_Rows=drive.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
		System.out.println("Table 1 rows are "+T_1_Rows.size());
		
		List<WebElement> T_1_Cols=drive.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
		System.out.println("Table 1 cols are "+T_1_Cols.size());
		
		List<WebElement> Third_row = drive.findElements(By.xpath("//table[contains(@class, 'ui celled striped table')]/tbody/tr[3]/td"));
        System.out.println("Third row cell values: ");
        for(WebElement value :Third_row ) {
            System.out.println(value.getText());
            
        }
        
        WebElement cellValue = drive.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value is: " + cellValue.getText());
		
		
	}

}
