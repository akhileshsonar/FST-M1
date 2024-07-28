from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium.webdriver.common.action_chains import ActionChains

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    print("Title is: ",driver.title)
    assert driver.title == 'OrangeHRM' 
    wait = WebDriverWait(driver, 10)

    ##login
    userName=driver.find_element(By.ID,"txtUsername")
    PassWord=driver.find_element(By.ID,"txtPassword")
    Login_button=driver.find_element(By.ID,"btnLogin")
    userName.send_keys("orange")
    PassWord.send_keys("orangepassword123")
    Login_button.click()

    driver.find_element(By.ID,"menu_pim_viewMyDetails").click()
    wait.until(EC.element_to_be_clickable(driver.find_element(By.XPATH,"//*[@id='menu_pim_viewMyDetails']/b")))
    My_info=driver.find_element(By.XPATH,"//*[@id='menu_pim_viewMyDetails']/b")
    My_info.click()
    driver.find_element(By.LINK_TEXT,"Emergency Contacts").click()
    myElements = driver.find_elements(By.XPATH,"//*[@id='emgcontact_list']/tbody/tr")
    print(len(myElements))
    for  ele in myElements :
            print("Contact details are-> ",ele.text)