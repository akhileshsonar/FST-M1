from selenium import webdriver

with webdriver.Firefox() as driver:
    driver.get("https://v1.training-support.net")
    print("Title is: ",driver.title)
    driver.quit()