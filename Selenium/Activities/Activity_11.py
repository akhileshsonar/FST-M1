from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title is: ",driver.title)

    checkbox = driver.find_element(By.NAME,"toggled")
    checkbox.click()
    print("Checkbox is selected: ",checkbox.is_selected())
    checkbox.click()
    print("Checkbox is Unselected: ",checkbox.is_selected())