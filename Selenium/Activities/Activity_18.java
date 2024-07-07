package test_basic_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_18 {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/selects");
		System.out.println("Title is: "+driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select MultiSelect = new Select(dropdown);
    	//select NodeJS by value node
        MultiSelect.selectByValue("node");
      //selected JavaScript by text value
        MultiSelect.selectByVisibleText("Javascript");
        for(int i = 4; i<=6 ; i++) {
        	MultiSelect.selectByIndex(i);
        }
        
        List<WebElement> selectedOptions = MultiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
		
        MultiSelect.deselectByIndex(5);
        selectedOptions = MultiSelect.getAllSelectedOptions();
        System.out.println("Selected options are:");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
	}

}
