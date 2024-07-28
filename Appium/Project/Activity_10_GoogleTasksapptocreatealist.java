package appium_project;

import static org.testng.Assert.assertTrue;

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

public class Activity_10_GoogleTasksapptocreatealist {

	AppiumDriver appdrivers;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// set capabilities
		UiAutomator2Options caps = new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.google.android.apps.tasks")
				.setAppActivity(".ui.TaskListsActivity").noReset();
		// set appium server url
		URL serverULR = new URI("http://localhost:4723").toURL();

		// initialization
		appdrivers = new AndroidDriver(serverULR, caps);

	}

	@Test
	public void AddTask_onGoogleTaks() {

			
			  
			appdrivers.findElement(AppiumBy.accessibilityId("Create new task")).click();
		  appdrivers.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
		  appdrivers.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		  appdrivers.findElement(AppiumBy.accessibilityId("Create new task")).click();
		  appdrivers.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep"); 
		  appdrivers.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		  appdrivers.findElement(AppiumBy.accessibilityId("Create new task")).click();
		  appdrivers.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
		  appdrivers.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		  
		  List<WebElement> lists = appdrivers.findElements(AppiumBy.xpath(
					"//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.tasks:id/tasks_list']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView"));
			System.out.println(lists.size());

			for (WebElement ele : lists) {
				System.out.println(ele.getText());
				
				assertTrue(ele.getText().contains("Complete"));

			}
		  
		  Assert.assertEquals(lists.size(), 3);
		 

	}

	@AfterClass
	public void closeTest() {
		appdrivers.quit();
	}

}
