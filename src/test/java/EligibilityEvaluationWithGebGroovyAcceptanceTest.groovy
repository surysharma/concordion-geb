import geb.Browser
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.runner.RunWith
import org.openqa.selenium.firefox.FirefoxDriver

@RunWith(ConcordionRunner.class)
class EligibilityEvaluationWithGebGroovyAcceptanceTest {
    Browser browser = new Browser();
    String url = "http://localhost:8080/testwebapp"
//    @Before
    //    public void before() {
    //        login()
    //    }

    public void isEmployeeEligible(Integer age, Double basicMonthlySalary, String niNumber) {
        Browser.drive(baseUrl: "http://localhost:8080", driver: new FirefoxDriver()) {
            go "/testwebapp"

            def niNumberElement = $("table td", text: "$niNumber")
            assert niNumberElement.size() == 1

            def enclosingTr = niNumberElement.parent()
            assert enclosingTr.size() == 1

            def radioButtonSibling = enclosingTr.find("input", type: "radio")
            assert radioButtonSibling.size() == 1

            radioButtonSibling.click()

            def autoEnrollButton = $("input", type: "submit", value: "auto-enroll")
            assert autoEnrollButton.size() == 1

            autoEnrollButton.click()
        }.quit()
    }

//
    //    private void login() {
    //        browser = new Browser()
    //        browser.setDriver(new FirefoxDriver())
    ////        browser.go(url)
    ////        browser.$("input", id: "username") << "orbitadmin"
    ////        browser.$("input", id: "password") << "testdata"
    ////        browser.driver.findElement(By.id('loginsubmit')).submit()
    //    }
    //
    //    @After
    //    public void tear() {
    //        browser.close()
    //    }
}
