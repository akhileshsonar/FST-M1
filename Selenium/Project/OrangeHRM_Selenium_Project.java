package selenium_Project_HRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.JCommander.Builder;

public class OrangeHRM_Selenium_Project {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void Init() {
		this.driver=Webdriver_setup.Setup();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test(priority =1)
	public void verify_Title_TC01() {
		String title =driver.getTitle();
		System.out.println("HRM APP Title is: "+title);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	@Test(priority =2)
	public void Get_the_url_of_the_header_image_TC02() {
		String HRM_Header_URL=driver.findElement(By.xpath("//*[@id='divLogo']/img")).getAttribute("src");
		System.out.println("URL is: "+HRM_Header_URL);
	}
	@Test(priority =3)
	public void Verify_login_TC03() {
		WebElement userName=driver.findElement(By.id("txtUsername"));
		WebElement PassWord=driver.findElement(By.id("txtPassword"));
		WebElement Login_button=driver.findElement(By.id("btnLogin"));
		userName.sendKeys("orange");
		PassWord.sendKeys("orangepassword123");
		Login_button.click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		String verifyLogin=driver.findElement(By.xpath("//*[@id='welcome']")).getText();
		System.out.println("Log in by :"+verifyLogin);
		Assert.assertEquals(verifyLogin, "Welcome Test");
	}
	@Test(priority =4,dependsOnMethods = "Verify_login_TC03")
	public void Add_a_member_TC04() {
		wait.until(ExpectedConditions.
				elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]/a/b"))));
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]/a/b")).click();
		
		wait.until(ExpectedConditions.
				elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b"))));
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
		driver.findElement(By.id("btnAdd")).click();
		  wait.until(ExpectedConditions.
		  elementToBeClickable(driver.findElement(By.id("firstName"))));
		  driver.findElement(By.id("firstName")).sendKeys("Aks");
		  driver.findElement(By.id("lastName")).sendKeys("Aks");
		  String empid=driver.findElement(By.id("employeeId")).getAttribute("value");
		  System.out.println("Emp is "+empid);
			  driver.findElement(By.id("btnSave")).click();
			  driver.findElement(By.xpath("//*[@id='menu_pim_viewEmployeeList']")).click();
			  driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Aks");
			  driver.findElement(By.id("empsearch_id")).sendKeys(empid);
			  driver.findElement(By.id("searchBtn")).click();
			  String Created_id =driver.findElement(By.cssSelector("td.left:nth-child(2) > a:nth-child(1)")).getText();
			  System.out.println("Creaed id is "+Created_id);
			  Assert.assertEquals(empid, Created_id);
	}
	@Test(priority =5)
	public void My_info_TC05() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")));
		WebElement My_info=driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b"));
		My_info.click();
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		driver.findElement(By.xpath("//*[@id='personal_txtEmpFirstName']")).clear();
		driver.findElement(By.xpath("//*[@id='personal_txtEmpLastName']")).clear();
		driver.findElement(By.xpath("//*[@id='personal_txtEmpFirstName']")).sendKeys("Test");
		driver.findElement(By.xpath("//*[@id='personal_txtEmpLastName']")).sendKeys("Testlast");
		driver.findElement(By.xpath("//*[@id='personal_optGender_2']")).click();
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		String confirmationd_massage=driver.findElement(By.xpath("//div[@class='message success fadable']")).getText();
		System.out.println("Confimation massage after edit "+confirmationd_massage);
	}
	@Test(priority =6)
	public void Directory_TC06() {
		
		WebElement Directory=driver.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']/b"));
		if(Directory.isDisplayed()==true) {
			Directory.click();
			String Directory_Heading_Title=driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
			Assert.assertEquals(Directory_Heading_Title, "Search Directory");
			System.out.println("Directory Massage is "+Directory_Heading_Title);
		}
		
		
	}
	@Test(priority =7)
	public void Add_qualifications_TC07() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")));
		WebElement My_info=driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b"));
		My_info.click();
		driver.findElement(By.linkText("Qualifications")).click();
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("Test_Compony");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("admin");
		driver.findElement(By.id("experience_from_date")).clear();
		driver.findElement(By.id("experience_to_date")).clear();
		driver.findElement(By.id("experience_from_date")).sendKeys("1995-01-01");
		driver.findElement(By.id("experience_to_date")).sendKeys("2024-01-01");
		driver.findElement(By.id("experience_comments")).sendKeys("qualifications is added");
		driver.findElement(By.id("btnWorkExpSave")).click();
		
	}
	
	@Test(priority =8)
	public void Apply_leave_TC08() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
		WebElement Dashboard=driver.findElement(By.id("menu_dashboard_index"));
		Dashboard.click();
		Actions action=new Actions(driver);
		driver.findElement(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a/img")).click();
		Select option=new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		option.selectByVisibleText("DayOff");
		driver.findElement(By.id("applyleave_txtFromDate")).clear();
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-07-15");
		driver.findElement(By.id("applyleave_txtToDate")).clear();
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-07-20");
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Applay leave");
		driver.findElement(By.id("applyBtn")).click();
		WebElement leave= driver.findElement(By.id("menu_leave_viewLeaveModule"));
		action.moveToElement(leave);
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
	}
	@Test(priority =9)
	public void getContactDetails_TC09() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")));
		WebElement My_info=driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b"));
		My_info.click();
		driver.findElement(By.linkText("Emergency Contacts")).click();
		List<WebElement> myElements = driver.findElements(By.xpath("//*[@id='emgcontact_list']/tbody/tr"));
		System.out.println(myElements.size());
		for(WebElement ele: myElements) {
			System.out.println("Contact details are "+ele.getText());
		}
	}
	
	
	
	
	@AfterClass
	public void CloseApp() {
		//driver.quit();
	}
	
	
}