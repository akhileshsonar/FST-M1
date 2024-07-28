from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    print("Title is: ",driver.title)
    assert driver.title == 'OrangeHRM' 
    userName=driver.find_element(By.ID,"txtUsername")
    PassWord=driver.find_element(By.ID,"txtPassword")
    Login_button=driver.find_element(By.ID,"btnLogin")
    userName.send_keys("orange")
    PassWord.send_keys("orangepassword123")
    Login_button.click()
    verifyLogin=driver.find_element(By.XPATH,"//*[@id='welcome']").text
    print("Log in by :",verifyLogin)
    assert verifyLogin == 'Welcome Test' 
    driver.quit()