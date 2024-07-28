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

    ## Apply leave
    driver.find_element(By.ID,"menu_pim_viewMyDetails").click()
    wait.until(EC.element_to_be_clickable(driver.find_element(By.ID,"menu_dashboard_index")))
    Dashboard=driver.find_element(By.ID,"menu_dashboard_index")
    Dashboard.click()
    driver.find_element(By.XPATH,"//div[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a/img").click()
    option=  Select(driver.find_element(By.ID,"applyleave_txtLeaveType"))

    option.select_by_visible_text("DayOff")
    driver.find_element(By.ID,"applyleave_txtFromDate").clear()
    driver.find_element(By.ID,"applyleave_txtFromDate").send_keys("2024-07-29")
    driver.find_element(By.ID,"applyleave_txtToDate").clear()
    driver.find_element(By.ID,"applyleave_txtToDate").send_keys("2024-08-20")
    driver.find_element(By.ID,"applyleave_txtComment").send_keys("Applay leave")
    driver.find_element(By.ID,"applyBtn").click()
    leave= driver.find_element(By.ID,"menu_leave_viewLeaveModule")
    action = ActionChains(driver)
    action.move_to_element(leave)
    driver.find_element(By.ID,"menu_leave_viewMyLeaveList").click()
    driver.find_element(By.ID,"calFromDate").clear()
    driver.find_element(By.ID,"calFromDate").send_keys("2024-07-29")
    driver.find_element(By.ID,"calToDate").clear()
    driver.find_element(By.ID,"calToDate").send_keys("2024-08-20")
    driver.find_element(By.ID,"btnSearch").click()
    Status=driver.find_element(By.CSS_SELECTOR,"tr.odd:nth-child(1) > td:nth-child(6) > a:nth-child(1)").text
    print("Staus",Status)
    assert Status=="Pending Approval(7.00)"
    