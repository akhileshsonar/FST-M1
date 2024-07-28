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

    ##Edit member
    driver.find_element(By.ID,"menu_dashboard_index").click()
    wait.until(EC.element_to_be_clickable(driver.find_element(By.XPATH, "//*[@id='menu_pim_viewMyDetails']/b")))
    My_info=driver.find_element(By.XPATH,"//*[@id='menu_pim_viewMyDetails']/b")
    My_info.click()
    
    wait.until(EC.element_to_be_clickable(driver.find_element(By.XPATH, "//*[@id='btnSave']")))
    driver.find_element(By.XPATH,"//*[@id='btnSave']").click()
    driver.find_element(By.XPATH,"//*[@id='personal_txtEmpFirstName']").clear()
    driver.find_element(By.XPATH,"//*[@id='personal_txtEmpLastName']").clear()
    driver.find_element(By.XPATH,"//*[@id='personal_txtEmpFirstName']").send_keys("Aks")
    driver.find_element(By.XPATH,"//*[@id='personal_txtEmpLastName']").send_keys("Aks")
    driver.find_element(By.XPATH,"//*[@id='personal_optGender_2']").click()
    driver.find_element(By.XPATH,"//*[@id='btnSave']").click()
    confirmationd_massage=driver.find_element(By.XPATH,"//div[@class='message success fadable']").text
    print("Confimation massage after edit ",confirmationd_massage)