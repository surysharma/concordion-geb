import geb.Browser
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.openqa.selenium.firefox.FirefoxDriver

@RunWith(ConcordionRunner.class)
class EligibilityEvaluationWithGebGroovyAcceptanceTest {
    Browser browser = new Browser();
    String url = "http://localhost:8080/testwebapp"

    @Before
    public void before() {
        browser.setBaseUrl("http://localhost:8080")
        browser.setDriver(new FirefoxDriver())
    }

    public String isEmployeeEligible(Integer age, Double basicMonthlySalary, String niNumber) {

        browser.go "/testwebapp"

        def niNumberElement = browser.$("table td", text: "$niNumber")
        assert niNumberElement.size() == 1

        def enclosingTr = niNumberElement.parent()
        assert enclosingTr.size() == 1

        def radioButtonSibling = enclosingTr.find("input", type: "radio")
        assert radioButtonSibling.size() == 1

        radioButtonSibling.click()

        def autoEnrollButton = browser.$("input", type: "submit", value: "auto-enroll")
        assert autoEnrollButton.size() == 1

        autoEnrollButton.click()

        return browser.$("span").text()
    }

    @After
    public void close() {
        browser.close()
    }
}
