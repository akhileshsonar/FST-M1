from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    imgurl=driver.find_element(By.XPATH,"//*[@id='divLogo']/img").get_attribute("src")
    print("imgurl is: ", imgurl)
    driver.quit()