import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

browser = new Browser()
browser.setDriver(new FirefoxDriver())
browser.go("http://localhost:8080")
browser.$("input", id: "username") << "orbitadmin"
browser.$("input", id: "password") << "testdata"
browser.driver.findElement(By.id('loginsubmit')).submit()
//browser.$('#loginsubmit1').submit()
//WebDriver driver = browser.getDriver()
//driver.findElement(By.id("loginsubmit"))
//assert element != null
browser.close()