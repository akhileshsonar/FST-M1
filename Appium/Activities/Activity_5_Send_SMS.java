package activities;

import java.net.MalformedURLException;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

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

public class Activity_5_Send_SMS {

	AndroidDriver Appdriver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// set capabilities
		UiAutomator2Options caps = new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.google.android.apps.messaging")
				.setAppActivity(".ui.ConversationListActivity")
				.noReset();
		// set appium server url

		URL serverULR = new URI("http://localhost:4723").toURL();
		
		// initialization
		Appdriver = new AndroidDriver(serverULR, caps);
		wait = new WebDriverWait(Appdriver, Duration.ofSeconds(10));

	}

	@Test
	public void Send_SMS() {

		Appdriver.findElement(AppiumBy.accessibilityId("Start chat")).click();

		wait.until(ExpectedConditions.elementToBeClickable(
				AppiumBy.xpath("//android.widget.EditText[@resource-id='ContactSearchField']")));

		Appdriver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='ContactSearchField']"))
				.sendKeys("8390768419");

		Appdriver.pressKey(new KeyEvent(AndroidKey.ENTER));

		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")));

		// Send massage
		Appdriver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text"))
				.sendKeys("Hello from Appium");

		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Send SMS")));

		// Sent button
		Appdriver.findElement(AppiumBy.accessibilityId("Send SMS")).click();

		// Assertion
		String messageTextSent = Appdriver.findElement(AppiumBy.accessibilityId("You said  Hello from Appium 01:00 .")).getText();
		Assert.assertEquals(messageTextSent, "Hello from Appium");

	}

	@AfterClass
	public void closeTest() {
		Appdriver.quit();
	}

}
