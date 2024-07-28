package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity_2_Captured_heading {

	AppiumDriver Appdriver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// set capabilities
		UiAutomator2Options caps = new UiAutomator2Options().setPlatformName("android")
				.setAutomationName("UiAutomator2").setAppPackage("com.android.chrome")
				.setAppActivity(".com.google.android.apps.chrome.Main").noReset();
		// set appium server url
		URL serverULR = new URI("http://localhost:4723").toURL();

		// initialization
		Appdriver = new AndroidDriver(serverULR, caps);
		wait = new WebDriverWait(Appdriver, Duration.ofSeconds(10));
		Appdriver.get("https://v1.training-support.net/");
	}

	@Test
	public void addition() {
		
		String pageHeading = Appdriver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();

		System.out.println("Heading of first page: " + pageHeading);

		Appdriver.findElement(AppiumBy.accessibilityId("About Us")).click();

		String aboutPageHeading = Appdriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']"))
				.getText();
		System.out.println("heading on 2nd page "+aboutPageHeading);
	}

	@AfterClass
	public void closeTest() {
		Appdriver.quit();
	}

}
