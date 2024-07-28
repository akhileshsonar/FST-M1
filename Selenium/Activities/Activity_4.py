from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Title is: ",driver.title)
    header_3=driver.find_element(By.XPATH,"//h3[@id='third-header']").text
    print("header 3 text is: ",header_3)
    header_5= driver.find_element(By.XPATH,"//h5[@class='ui green header']").value_of_css_property("color")
    print("header 5 color is: ",header_5)
    voilet= driver.find_element(By.CLASS_NAME,"violet").get_attribute("class")
    print("voilet color class is: ",voilet)
    grey= driver.find_element(By.CLASS_NAME,"grey").text
    print("grey button text is: ",grey)
    driver.quit()