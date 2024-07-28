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

public class Activity_11_Google_Keep_Goal2 {

	AppiumDriver appdrivers;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// set capabilities
		UiAutomator2Options caps = new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.google.android.keep")
				.setAppActivity(".activities.BrowseActivity")
				.noReset();
		// set appium server url
		URL serverULR = new URI("http://localhost:4723").toURL();

		// initialization
		appdrivers = new AndroidDriver(serverULR, caps);

	}

	@Test
	public void AddTask_onGoogleTaks() {
		
		appdrivers.findElement(AppiumBy.accessibilityId("New text note")).click();
		appdrivers.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"))
		.sendKeys("Testing Google keep app");
		appdrivers.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"))
			.sendKeys("Task1");
		appdrivers.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		
		WebElement TaksTile=appdrivers.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"));
		  Assert.assertEquals(TaksTile.getText(),"Task1");
	}

	@AfterClass
	public void closeTest() {
		appdrivers.quit();
	}

}
