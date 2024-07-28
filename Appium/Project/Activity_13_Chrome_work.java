package appium_project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity_13_Chrome_work {
	
	AppiumDriver appdrivers;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		//set capabilities
		UiAutomator2Options caps=new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.android.chrome")
				.setAppActivity(".com.google.android.apps.chrome.Main")
				.noReset();
		//set appium server url
		URL serverULR=new URI("http://localhost:4723").toURL();
		
		//initialization
		appdrivers=new AndroidDriver(serverULR,caps);
		wait=new WebDriverWait(appdrivers, Duration.ofSeconds(10));
		appdrivers.get("https://v1.training-support.net/selenium");
		
	}
	
	@Test
	public void webApptest() {
		
		Dimension dim=appdrivers.manage().window().getSize();
		
		Point start=new Point((int)(dim.getWidth() *0.5), (int)(dim.getHeight()*0.85));
		Point end=new Point((int)(dim.getWidth() *0.5), (int)(dim.getHeight()*0.65));
		
		wait.until(ExpectedConditions.elementToBeClickable
			(appdrivers.findElement(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']"))));
		
		ActionsBase.doSwipe(appdrivers, start, end, 50);
		
		wait.until(ExpectedConditions.elementToBeClickable
				(appdrivers.findElement
						(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']"))))
							.click();
		
		WebElement inputTask=appdrivers.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Todo List']/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText"));
		WebElement addTask=appdrivers.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
		
			inputTask.sendKeys("Task1");
			addTask.click();			
			inputTask.sendKeys("Task2");
			addTask.click();
			inputTask.sendKeys("Task3");
			addTask.click();
			List<WebElement> lists=appdrivers.findElements(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View"));
			System.out.println("before clear list "+lists.size());
			
			for(WebElement element: lists) {
				//strike every task
				element.click();
				//element.clear();
			}
			lists.clear();
			System.out.println("after clear list "+lists);
		Assert.assertEquals(lists.size(), 0);
		
	}
	@AfterClass
	public void closeTest() {
		appdrivers.quit();
	}

}
