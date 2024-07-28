from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title is: ",driver.title)
    wait = WebDriverWait(driver, 10)

    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")
    print("Checkbox is visible: ", checkbox.is_displayed())
    checkbox_toggle.click()
    wait.until(expected_conditions.invisibility_of_element(checkbox))
    print("Checkbox is visible: ", checkbox.is_displayed())