package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity1GoogleSearchSteps {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("User is on Google Home Page")
    public void userIsOnGooglePage() throws Throwable {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }
    
    @When("User types in Cheese and hits ENTER")
    public void userTypesInCheeseAndHitsENTER() throws Throwable {
        driver.findElement(By.name("q")).sendKeys("Current date", Keys.RETURN);
    }
 
    @Then("Search current date")
    public void showHowManySearchResultsWereShown() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vk_bk dDoNo FzvWSb']")));
        String resultStats = driver.findElement(By.xpath("//div[@class='vk_bk dDoNo FzvWSb']")).getText();
        System.out.println("Current Date is : " + resultStats);
    }
 
    @And("Close the browser")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }

}
