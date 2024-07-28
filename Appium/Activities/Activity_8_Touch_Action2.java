package activities;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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

public class Activity_8_Touch_Action2 {

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

		Appdriver.get("https://v1.training-support.net/selenium/lazy-loading");

	}

	@Test
	public void Send_SMS() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
        
   
        Dimension dims = Appdriver.manage().window().getSize();
        
        Point start = new Point((int)(dims.getWidth() * .51), (int)(dims.getHeight() * .86));
        Point end = new Point((int)(dims.getWidth() * .51), (int)(dims.getHeight() * .21));
        

        List<WebElement> imageElements = Appdriver.findElements(AppiumBy.className("android.widget.Image"));
 
        System.out.println("Before scroll: " + imageElements.size());
        
        ActionsBase.doSwipe(Appdriver, start, end, 200);
 
        imageElements = Appdriver.findElements(AppiumBy.className("android.widget.Image"));
 
        System.out.println("After scroll: " + imageElements.size());
 
        Assert.assertEquals(imageElements.size(), 3);

	}

	@AfterClass
	public void closeTest() {
		Appdriver.quit();
	}

}
