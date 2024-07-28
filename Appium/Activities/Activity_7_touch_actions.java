package activities;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity_7_touch_actions {

	AppiumDriver Appdriver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// set capabilities
		UiAutomator2Options caps = new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.android.chrome")
				.setAppActivity(".com.google.android.apps.chrome.Main")
				.noReset();
		// set appium server url

		URL serverULR = new URI("http://localhost:4723").toURL();

		// initialization
		Appdriver = new AppiumDriver(serverULR, caps);
		wait = new WebDriverWait(Appdriver, Duration.ofSeconds(10));

		Appdriver.get("https://v1.training-support.net/selenium/sliders");

	}

	@Test
	public void Send_SMS() {

		// Wait for page to load
		wait.until(ExpectedConditions.
				elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar[@resource-id='slider']")));
		
		
		// Get the size of the screen
		Dimension dims = Appdriver.manage().window().getSize();
		
		
		// Set the start and end points
		Point start = new Point((int)(dims.getWidth() * .34), (int)(dims.getHeight() * .53));
        Point end = new Point((int)(dims.getWidth() * .5), (int)(dims.getHeight() * .52));
        // Perform swipe
        ActionsBase.doSwipe(Appdriver, start, end, 500);
        System.out.println(start+" "+end);

		// Get the volume level
		String volumeText = Appdriver.findElement(AppiumBy.xpath("//android.view.View[contains(@text, 'Volume')]"))
				.getText();
		
		 System.out.println(volumeText);
		// Assertions
		assertTrue(volumeText.contains("50%"));

	}

	@AfterClass
	public void closeTest() {
		Appdriver.quit();
	}

}
