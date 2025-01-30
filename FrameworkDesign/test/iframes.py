from selenium import webdriver
from selenium.webdriver.chrome import service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.service import Service

service_obj = service("test\\chromedriver.exe")
driver = webdriver.Chrome(service=service_obj)
driver.get("https://rahulshettyacademy.com/AutomationPractice/")
driver.maximize_window()
driver.switch_to.frame("courses-iframe")
text = driver.find_element(By.XPATH,"//li[normalize-space()='contact@rahulshettyacademy.com']").text
print(text)
assert text == "contact@rahulshettyacademy.com"
driver.switch_to.default_content()
print(driver.find_element(By.TAG_NAME,"h1").text)

