package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity_3_More_Calculation_on_calculator {
	
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
		//Clear calculator before execution
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/clr")).click();
		
	}
	
	
	
	@Test(priority = 1)
	public void addition() {
		
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_5")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Add")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_9")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Equals")).click();
		
		String addtion_Result=Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
		System.out.println("my addition result is "+addtion_Result);
		Assert.assertEquals(addtion_Result, "14");
	}
	@Test(priority = 2)
	public void SubStraction() {
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_1")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_0")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Subtract")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_5")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Equals")).click();
		
		String addtion_Result=Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
		System.out.println("my SubStraction result is "+addtion_Result);
		Assert.assertEquals(addtion_Result, "5");
	}
	@Test(priority = 3)
	public void Multiplications() {
		
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_5")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Multiply")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_1")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_00")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Equals")).click();
		
		String addtion_Result=Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
		System.out.println("my Multiplications result is "+addtion_Result);
		Assert.assertEquals(addtion_Result, "500");
	}
	@Test(priority = 4)
	public void Division() {
		
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_5")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_0")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Divide")).click();
		Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_2")).click();
		Appdriver.findElement(AppiumBy.accessibilityId("Equals")).click();
		
		String addtion_Result=Appdriver.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
		System.out.println("my Division result is "+addtion_Result);
		Assert.assertEquals(addtion_Result, "25");
	}
	
	
	
	
	
	@AfterClass
	public void closeTest() {
		Appdriver.quit();
	}
	
	
	
	
	

}
