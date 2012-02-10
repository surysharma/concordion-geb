import geb.Browser
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.openqa.selenium.By
import org.openqa.selenium.firefox.FirefoxDriver

@RunWith(ConcordionRunner.class)
class EligibilityEvaluationWithGebGroovyAcceptanceTest {
    Browser browser = new Browser();
    String url = "http://localhost:8080"
    @Before
    public void before() {
        login()
    }

    public void isEmployeeEligible(Integer age, Double basicMonthlySalary, String niNumber) {
        browser.go(url+"/company/home.html?id=158") //Go to the company home page
        browser.go(url + "/list/employee.html") //Go to the employee list page
    }

    private void login() {
        browser = new Browser()
        browser.setDriver(new FirefoxDriver())
        browser.go("http://localhost:8080")
        browser.$("input", id: "username") << "orbitadmin"
        browser.$("input", id: "password") << "testdata"
        browser.driver.findElement(By.id('loginsubmit')).submit()
    }

    @After
    public void tear() {
        browser.close()
    }
}
