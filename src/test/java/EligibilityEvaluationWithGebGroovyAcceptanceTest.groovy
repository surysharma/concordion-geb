import geb.Browser
import org.concordion.api.ResultSummary
import org.concordion.internal.ConcordionBuilder
import org.junit.Test
import org.junit.runner.RunWith
import org.concordion.integration.junit4.ConcordionRunner

@RunWith(ConcordionRunner.class)
class EligibilityEvaluationWithGebGroovyAcceptanceTest {

    public void isEmployeeEligible(Integer age, Double basicMonthlySalary, String niNumber) {
        Browser.drive{
            go "http://google.co.uk"
        }
    }
}
