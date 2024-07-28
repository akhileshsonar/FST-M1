from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net")
    print("Title is: ",driver.title)
    about_button=driver.find_element(By.ID,"about-link")
    about_button.click()
    print("New page title is: ",driver.title)
    driver.quit()