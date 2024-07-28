package activities;

import java.net.MalformedURLException;
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

public class Activity_4_Contacts_app {

	AppiumDriver Appdriver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// set capabilities
		UiAutomator2Options caps = new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.google.android.contacts")
				.setAppActivity(".com.android.contacts.activities.PeopleActivity").noReset();
		// set appium server url
		URL serverULR = new URI("http://localhost:4723").toURL();

		// initialization
		Appdriver = new AndroidDriver(serverULR, caps);
		wait = new WebDriverWait(Appdriver, Duration.ofSeconds(10));
	}

	@Test
	public void addition() {
		
		Appdriver.findElement(AppiumBy.accessibilityId("Create contact")).click();
 
       
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text='First name']")
        ));
 
        Appdriver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='First name']"
        )).sendKeys("Aaditya");
        
        Appdriver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Surname']"
        )).sendKeys("Varma_Test");
        Appdriver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Phone']"
        )).sendKeys("999148292");
        
        
        Appdriver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();
 
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
 
        String contactName = Appdriver.findElement(AppiumBy.id("large_title")).getText();
        
        System.out.println("New Created contact is "+contactName);
        
        Assert.assertEquals(contactName, "Aaditya Varma_Test");
	}

	@AfterClass
	public void closeTest() {
		Appdriver.quit();
	}

}
