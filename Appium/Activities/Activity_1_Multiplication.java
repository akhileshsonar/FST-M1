package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity_1_Multiplication {
	
	AppiumDriver Appdriver;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		
		//set capabilities
		UiAutomator2Options caps=new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.oneplus.calculator")
				.setAppActivity(".com.android.calculator2.Calculator")
				.noReset();
		//set appium server url
		URL serverULR=new URI("http://localhost:4723").toURL();
		
		//initialization
		Appdriver=new AndroidDriver(serverULR,caps);
		
	}
	
	
	
	@Test
	public void addition() {
		
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_6")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Add")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_6")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Equals")).click();
		
		String addtion_Result=Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
		System.out.println("my addition result is "+addtion_Result);
		Assert.assertEquals(addtion_Result, "12");
	}
	@AfterClass
	public void closeTest() {
		Appdriver.quit();
	}
	
	
	
	
	

}
