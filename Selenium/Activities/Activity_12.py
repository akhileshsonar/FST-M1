from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title is: ",driver.title)

    Textinput=driver.find_element(By.ID,"input-text")
    print("Text input status ",Textinput.is_enabled())
    if Textinput.is_enabled()==False:
        driver.find_element(By.ID,"toggleInput").click()
    print("Text input status ",Textinput.is_enabled())