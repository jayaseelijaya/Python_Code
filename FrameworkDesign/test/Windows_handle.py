import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait

driver = webdriver.Chrome()
driver.maximize_window()
driver.get("https://rahulshettyacademy.com/loginpagePractise/")

driver.find_element(By.XPATH,"//a[@class='blinkingText'][1]").click()
windows = driver.window_handles
driver.switch_to.window(windows[1])
text = driver.find_element(By.CSS_SELECTOR,"p[class='im-para red']").text
splitedText = str(text.split(' ')[4].strip())
print(splitedText)
driver.close()
driver.switch_to.window(windows[0])
time.sleep(2)
driver.find_element((By.CSS_SELECTOR,"input[id='username']")).send_keys(splitedText)
driver.find_element((By.CSS_SELECTOR,"input[id='password']")).send_keys(splitedText)
driver.find_element(By.NAME,"signin").click()
wait = WebDriverWait(driver,3).until(expected_conditions.invisibility_of_element_located
                                     (driver.find_element(By.XPATH,"//div[@class='alert alert-danger col-md-12']")))
located_element = driver.find_element(By.XPATH,"//div[@class='alert alert-danger col-md-12']").text
assert located_element == "Incorrect username/password."




