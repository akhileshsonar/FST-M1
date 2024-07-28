from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Title is: ",driver.title)
    actions = ActionChains(driver)
    actions.send_keys("A").key_down(Keys.CONTROL).send_keys("a").send_keys("c")
    actions.key_up(Keys.CONTROL).perform()