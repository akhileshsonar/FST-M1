from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/ajax")
    print("Title is: ",driver.title)
    actions = ActionChains(driver)
    ChangeContent=driver.find_element(By.CSS_SELECTOR,"button.violet")
    wait = WebDriverWait(driver, 10)
    ChangeContent.click()
    wait.until(expected_conditions.element_to_be_clickable(driver.find_element(By.XPATH,"//div[@id='ajax-content']/h1")))
    h1=driver.find_element(By.XPATH,"//div[@id='ajax-content']/h1").text
    h3=driver.find_element(By.XPATH,"//div[@id='ajax-content']/h3").text
    print("H1 Text is ",h1)
    print("H3 Text before change ",h1)
    wait.until(expected_conditions.element_to_be_clickable(driver.find_element(By.XPATH,"//div[@id='ajax-content']/h3")))
    h3_new=driver.find_element(By.XPATH,"//div[@id='ajax-content']/h3").text
    print("H3 Text after change ",h3_new)
    ##driver.quit()