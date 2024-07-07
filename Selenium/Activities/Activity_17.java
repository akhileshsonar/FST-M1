package test_basic_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_17 {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/selects");
		System.out.println("Title is: "+driver.getTitle());
		
		WebElement dropdown = driver.findElement(By.id("single-select"));

        Select singleSelect = new Select(dropdown);

        singleSelect.selectByVisibleText("Option 2");

        System.out.println("2nd  option: " + singleSelect.getFirstSelectedOption().getText());

        singleSelect.selectByIndex(3);
 
        System.out.println("3rd option: " + singleSelect.getFirstSelectedOption().getText());

        singleSelect.selectByValue("4");

        System.out.println("4th option: " + singleSelect.getFirstSelectedOption().getText());

        List<WebElement> allOptions = singleSelect.getOptions();
        System.out.println("Options in the dropdown: ");
        for(WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        driver.quit();
		
	}

}
