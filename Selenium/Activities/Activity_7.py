from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("Title is: ",driver.title)
    action = ActionChains(driver)

    Ball=driver.find_element(By.XPATH,"//img[@id='draggable']")
    Drop1=driver.find_element(By.XPATH,"//div[@id='droppable' and text()='Dropzone 1']")
    Drop2=driver.find_element(By.XPATH,"//div[@id='dropzone2' and text()='Dropzone 2']")
    action.drag_and_drop(Ball,Drop1).perform()
    print("Enter drop 1 ", driver.find_element(By.XPATH,"//div[@id='droppable' and text()='Dropzone 1']/p").text)
    action.drag_and_drop(Ball,Drop2).perform()
    print("Enter drop 2 ", driver.find_element(By.XPATH,"//div[@id='dropzone2' and text()='Dropzone 2']/p").text)