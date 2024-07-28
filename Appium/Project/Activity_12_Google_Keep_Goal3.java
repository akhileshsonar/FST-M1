package appium_project;



import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
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

public class Activity_12_Google_Keep_Goal3 {

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
		
		wait=new WebDriverWait(appdrivers, Duration.ofSeconds(10));
	}

	@Test
	public void AddTask_onGoogleTaks() {
		
		//Task Added
		appdrivers.findElement(AppiumBy.accessibilityId("New text note")).click();
		appdrivers.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"))
		.sendKeys("Testing Google keep app");
		appdrivers.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"))
			.sendKeys("Task1");
		appdrivers.findElement(AppiumBy.accessibilityId("Reminder")).click();
		appdrivers.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/menu_text' and @text='Later today']"))
			.click();
		
		//Navigate to back
		appdrivers.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		appdrivers.findElement(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")).click();
		
		// verify reminder
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Time reminder Today, 18:00")));
		
		WebElement reminderText=appdrivers.findElement(AppiumBy.accessibilityId("Time reminder Today, 18:00"));
		Assert.assertEquals(reminderText.getText(),"Today, 18:00");
		System.out.println("Reminder is "+reminderText.getText());
		
		
		WebElement TaksTile=appdrivers.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"));
		  Assert.assertEquals(TaksTile.getText(),"Task1");
	}

	@AfterClass
	public void closeTest() {
		appdrivers.quit();
	}

}
