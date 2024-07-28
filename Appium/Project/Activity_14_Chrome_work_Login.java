package appium_project;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity_14_Chrome_work_Login {
	
	AppiumDriver appdrivers;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() throws MalformedURLException, URISyntaxException {
		
		//set capabilities
		UiAutomator2Options caps=new UiAutomator2Options()
				.setPlatformName("android")
				.setAutomationName("UiAutomator2")
				.setAppPackage("com.android.chrome")
				.setAppActivity(".com.google.android.apps.chrome.Main")
				.noReset();
		//set appium server url
		URL serverULR=new URI("http://localhost:4723").toURL();
		
		//initialization
		appdrivers=new AndroidDriver(serverULR,caps);
		wait=new WebDriverWait(appdrivers, Duration.ofSeconds(10));
		appdrivers.get("https://v1.training-support.net/selenium");
		
	}
	
	
	
	@Test(priority = 1)
	public void webApptest_Valid_login() {
		
		Dimension dim=appdrivers.manage().window().getSize();
		
		Point start=new Point((int)(dim.getWidth() *.45), (int)(dim.getHeight()* .69));
		Point end=new Point((int)(dim.getWidth() * .50), (int)(dim.getHeight()* .20));
		
		wait.until(ExpectedConditions.elementToBeClickable
				(appdrivers.findElement(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']"))));

		ActionsBase.doSwipe(appdrivers, start, end, 200);
		
		wait.until(ExpectedConditions.elementToBeClickable
				(appdrivers.findElement
						(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']"))));
		
		appdrivers.findElement
		(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable (appdrivers.findElement
				  (AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))));
		
		WebElement userName=appdrivers.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"));
		WebElement password=appdrivers.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"));
		
		WebElement LogBut=appdrivers.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']"));
		
		userName.sendKeys("admin");
		password.sendKeys("password");
		LogBut.click();
		LogBut.click();
		
		
		
		  wait.until(ExpectedConditions.elementToBeClickable (appdrivers.findElement
		  (AppiumBy.xpath(
		  "//android.widget.TextView[@resource-id='action-confirmation']"))));
		  
		  WebElement confirmation_mag= appdrivers.findElement (AppiumBy.xpath(
		  "//android.widget.TextView[@resource-id='action-confirmation']"));
		  Assert.assertEquals(confirmation_mag, "Welcome Back, admin");
		 
		
	}
	
	@Test(priority = 2)
	public void webApptest_Invalid_login() {
		
		Dimension dim=appdrivers.manage().window().getSize();
		
		Point start=new Point((int)(dim.getWidth() *.45), (int)(dim.getHeight()* .69));
		Point end=new Point((int)(dim.getWidth() * .50), (int)(dim.getHeight()* .20));
		
		wait.until(ExpectedConditions.elementToBeClickable
				(appdrivers.findElement(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']"))));

		ActionsBase.doSwipe(appdrivers, start, end, 200);
		
		wait.until(ExpectedConditions.elementToBeClickable
				(appdrivers.findElement
						(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']"))));
		
		appdrivers.findElement
		(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable (appdrivers.findElement
				  (AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))));
		
		WebElement userName=appdrivers.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"));
		WebElement password=appdrivers.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"));
		
		WebElement LogBut=appdrivers.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']"));
		
		userName.sendKeys("admi");
		password.sendKeys("passwor");
		LogBut.click();
		LogBut.click();
		
		
		
		  wait.until(ExpectedConditions.elementToBeClickable (appdrivers.findElement
		  (AppiumBy.xpath(
		  "//android.widget.TextView[@resource-id='action-confirmation']"))));
		  
		  WebElement confirmation_mag= appdrivers.findElement (AppiumBy.xpath(
		  "//android.widget.TextView[@resource-id='action-confirmation']"));
		  Assert.assertEquals(confirmation_mag, "Invalid Credentials");
		 
		
	}
	@AfterClass
	public void closeTest() {
		appdrivers.quit();
	}

}
