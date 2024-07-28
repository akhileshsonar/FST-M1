from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Title is: ",driver.title)
    userName=driver.find_element(By.ID,"username").send_keys("admin")
    password= driver.find_element(By.ID,"password").send_keys("password")
    submitButton=driver.find_element(By.XPATH,"//button[text()='Log in']")
    submitButton.click()
    print("New page title is: ",driver.title)
    confirm_mag=driver.find_element(By.ID,"action-confirmation").text
    print("After log got a message: ",confirm_mag)
    driver.quit()