from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    print("Title is: ",driver.title)
    assert driver.title == 'OrangeHRM' 
    wait = WebDriverWait(driver, 10)

    ##login
    userName=driver.find_element(By.ID,"txtUsername")
    PassWord=driver.find_element(By.ID,"txtPassword")
    Login_button=driver.find_element(By.ID,"btnLogin")
    userName.send_keys("orange")
    PassWord.send_keys("orangepassword123")
    Login_button.click()

    ##Add member
    wait.until(EC.
				element_to_be_clickable(driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/ul/li[6]/a/b")))
    driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/ul/li[6]/a/b").click()
    wait.until(EC.
				element_to_be_clickable(driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/ul/li[2]/a/b")))
    driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/ul/li[2]/a/b").click()
	
    driver.find_element(By.ID,"btnAdd").click()

    wait.until(EC.
		  element_to_be_clickable(driver.find_element(By.ID,"firstName")))
    
    driver.find_element(By.ID,"firstName").send_keys("Aks")
    driver.find_element(By.ID,"lastName").send_keys("Aks")

    empid=driver.find_element(By.ID,"employeeId").get_attribute("value")
    print("Emp is: ",empid)
    driver.find_element(By.ID,"btnSave").click()
    driver.find_element(By.XPATH,"//*[@id='menu_pim_viewEmployeeList']").click()
    driver.find_element(By.ID,"empsearch_employee_name_empName").send_keys("Aks")
    driver.find_element(By.ID,"empsearch_id").send_keys(empid)
    driver.find_element(By.ID,"searchBtn").click()
    Created_id =driver.find_element(By.CSS_SELECTOR,"td.left:nth-child(2) > a:nth-child(1)").text
    print("Emp is: ",Created_id)
    assert empid == Created_id