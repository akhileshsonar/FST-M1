from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title is: ",driver.title)

    cols = driver.find_elements(By.XPATH,"//table[@id='sortableTable']/tbody/tr[1]/td")
    print("Colm size: ",len(cols))
    
    rows = driver.find_elements(By.XPATH,"//table[@id='sortableTable']/tbody/tr")
    print("rows size: ",len(rows)) 

    cellValue = driver.find_element(By.XPATH,"//table[@id='sortableTable']/tbody/tr[2]/td[2]")  
    print("2nd row and 2nd value: : ",cellValue.text) 

    driver.find_element(By.XPATH,"//table[@id='sortableTable']/thead/tr/th").click()       
    cellValue = driver.find_element(By.XPATH,"//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    print("2nd row and 2nd value: : ",cellValue.text) 
    footer = driver.find_elements(By.XPATH,"//table[@id='sortableTable']/tfoot/tr/th")
    print("values of the footer is :") 
    for cell in footer:
        print(cell.text)