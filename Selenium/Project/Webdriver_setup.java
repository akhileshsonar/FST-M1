package selenium_Project_HRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Webdriver_setup {

	static WebDriver driver;
	static public WebDriver Setup() {
		try {
			driver = new FirefoxDriver();
			driver.get("http://alchemy.hguy.co/orangehrm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}


}
