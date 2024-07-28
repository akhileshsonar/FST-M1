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

    ##Verify Directory
    driver.find_element(By.ID,"menu_pim_viewMyDetails").click()
    wait.until(EC.element_to_be_clickable
               (driver.find_element(By.ID, "menu_directory_viewDirectory")))
    
    Directory=driver.find_element(By.ID,"menu_directory_viewDirectory")
    print(Directory)
    if(Directory.is_displayed()==True):
        Directory.click()
        Directory_Heading_Title=driver.find_element(By.XPATH,"//div[@class='head']/h1").text
        assert Directory_Heading_Title == 'Search Directory'
        print("Directory Massage is-> ",Directory_Heading_Title)
		