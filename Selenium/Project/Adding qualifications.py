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

    ##Add qualification
    driver.find_element(By.ID,"menu_pim_viewMyDetails").click()
    wait.until(EC.element_to_be_clickable(driver.find_element(By.XPATH,"//*[@id='menu_pim_viewMyDetails']/b")))
    My_info=driver.find_element(By.XPATH,"//*[@id='menu_pim_viewMyDetails']/b")
    My_info.click()
    driver.find_element(By.LINK_TEXT,"Qualifications").click()
    driver.find_element(By.ID,"addWorkExperience").click()
    driver.find_element(By.ID,"experience_employer").send_keys("Test_Compony")
    driver.find_element(By.ID,"experience_jobtitle").send_keys("admin")
    driver.find_element(By.ID,"experience_from_date").clear()
    driver.find_element(By.ID,"experience_to_date").clear()
    driver.find_element(By.ID,"experience_from_date").send_keys("1995-01-01")
    driver.find_element(By.ID,"experience_to_date").send_keys("2024-01-01")
    driver.find_element(By.ID,"experience_comments").send_keys("qualifications is added")
    driver.find_element(By.ID,"btnWorkExpSave").click()
    driver.quit()

