import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

Browser.drive(baseUrl: "http://localhost:8080", driver: new FirefoxDriver()) {
    go()
    $("input", id: "username") << "orbitadmin"
    $("input", id: "password") << "testdata"
    $("#loginsubmit").submit()
}
