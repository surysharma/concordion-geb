import geb.Browser
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

@RunWith(ConcordionRunner.class)
class EligibilityEvaluationWithGebGroovyAcceptanceTest {
    Browser browser = new Browser();
    String url = "http://localhost:8080"

    @Before
    public void before() {
        login()
    }

    public String isEmployeeEligible(String expectedFirstName, String expectedSurname, Integer age, Double basicMonthlySalary) {
        browser.go("/company/home.html?id=158")
        browser.$("#employeeSection a", title: "List Employees").click()


        def tableRows = browser.$("table tbody tr")
        tableRows.find { tr ->

            def radioButton = tr.find("td")[0]
            println radioButton

            def surname = tr.find("td")[1].text()
            println "expectedSurname:$expectedSurname surname: $surname"

            def firstName = tr.find("td")[2].text()
            println "expectedFirstName:$expectedFirstName firstName: $firstName"

            def dob = tr.find("td")[3].text()
            println "dob: $dob"

            if (surname.trim() == expectedSurname.trim()
                && firstName.trim() == expectedFirstName.trim()
            ) {
                radioButton.click()
                //TODO: Should exit closure once the radio button is clicked. But How?
            }


        }


        return "Eligible"
    }

    private void login() {
        browser = new Browser()
        browser.setDriver(new ChromeDriver())
        browser.setBaseUrl("http://localhost:8080")
        browser.go()
        browser.$("input", id: "username") << "orbitadmin"
        browser.$("input", id: "password") << "testdata"
        browser.driver.findElement(By.id('loginsubmit')).submit()
    }

    @After
    public void tear() {
        browser.close()
    }
}
