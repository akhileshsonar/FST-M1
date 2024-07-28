from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title is: ",driver.title)
    wait = WebDriverWait(driver, 10)
    Removebutton=driver.find_element(By.ID,"toggleCheckbox")
    Dynamic_Button=driver.find_element(By.ID,"dynamicCheckbox")
    Removebutton.click()
    wait.until(expected_conditions.invisibility_of_element(Dynamic_Button))
    print("Check box is desable ")
    Removebutton.click()
    wait.until(expected_conditions.visibility_of(Dynamic_Button))
    print("Check box is Enable ")
    driver.quit()