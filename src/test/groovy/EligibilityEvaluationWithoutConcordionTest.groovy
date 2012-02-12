import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

//browser = new Browser()
//browser.setDriver(new FirefoxDriver())
//browser.go("http://localhost:8080/testwebapp/")
////browser.$("input", id: "username") << "orbitadmin"
////browser.$("input", id: "password") << "testdata"
////browser.driver.findElement(By.id('loginsubmit')).submit()
////browser.$('#loginsubmit1').submit()
////WebDriver driver = browser.getDriver()
////driver.findElement(By.id("loginsubmit"))
////assert element != null
//
//browser.close()
def closure = {
    go "/testwebapp/"
}
Browser.drive(baseUrl: "http://localhost:8080",driver: new FirefoxDriver()) {
    go "/testwebapp/"

    def niNumberElement = $("table td", text: "L3754L")
    assert niNumberElement.size() == 1

    def enclosingTr = niNumberElement.parent()
    assert enclosingTr.size() == 1

    def radioButtonSibling = enclosingTr.find("input", type:"radio")
    assert radioButtonSibling.size() == 1

    radioButtonSibling.click()

    def autoEnrollButton = $("input", type: "submit", value: "auto-enroll")
    assert autoEnrollButton.size() == 1

    autoEnrollButton.click()

}.quit()