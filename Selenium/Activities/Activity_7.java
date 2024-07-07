package test_basic_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity_7 {

	public static void main(String[] args) {
	
		WebDriver drive =new ChromeDriver();
		drive.get("https://v1.training-support.net/selenium/drag-drop");
		System.out.println("Title page is for drag and drop: "+drive.getTitle());
		WebElement ball=drive.findElement(By.xpath("//img[@id='draggable']"));
		WebElement Drop1=drive.findElement(By.xpath("//div[@id='droppable' and text()='Dropzone 1']"));
		WebElement Drop2=drive.findElement(By.xpath("//div[@id='dropzone2' and text()='Dropzone 2']"));
		
		Actions action =new Actions(drive);
		action.dragAndDrop(ball, Drop1).build().perform();
		
		String BallExterl1=drive.findElement(By.xpath("//div[@id='droppable' and text()='Dropzone 1']/p")).getText();
		System.out.println("Ball Enter in zone 1 "+BallExterl1);
		
		action.dragAndDrop(ball, Drop2).build().perform();
		
		String BallExterl2=drive.findElement(By.xpath("//div[@id='dropzone2' and text()='Dropzone 2']/p")).getText();
		System.out.println("Ball Enter in zone 2 "+BallExterl2);
		
		
	}

}
