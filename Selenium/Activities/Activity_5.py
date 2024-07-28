from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Title is: ",driver.title)
    wait = WebDriverWait(driver, 10)
    actions = webdriver.ActionChains(driver)
    actions.click().perform()
    cubeValue_left=driver.find_element(By.CLASS_NAME,"active").text
    print("left click cube value is: ",cubeValue_left)
    actions.double_click().perform()
    cubeValue_double=driver.find_element(By.CLASS_NAME,"active").text
    print("double click cube value is: ",cubeValue_double)
    actions.context_click().perform()
    cubeValue_right=driver.find_element(By.CLASS_NAME,"active").text
    print("right click cube value is: ",cubeValue_right)
		