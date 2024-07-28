from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title is: ",driver.title)

    T_1_Rows=driver.find_elements(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr")
    print("Table 1 rows are ",len(T_1_Rows))
    
    LT_1_Cols=driver.find_elements(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print("Table 1 cols are ",len(LT_1_Cols))
    
    Third_row = driver.find_elements(By.XPATH,"//table[contains(@class, 'ui celled striped table')]/tbody/tr[3]/td")
    print("Third row cell values: ")
    for value in Third_row:
        print(value.text)
    
    cellValue = driver.find_element(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")
    print("Third row cell values: ",cellValue.text)
		
		