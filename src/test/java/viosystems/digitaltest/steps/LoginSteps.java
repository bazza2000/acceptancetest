package viosystems.digitaltest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class LoginSteps extends FluentCucumberTest {

    private static final String URL = "https://demo.viosystems.com/EnterUsername";
    private static final String SUBMIT_BTN_NEXT = "button__submit-btn--next";

    @Given("^the system is running at \"([^\"]*)\"$")
    public void theSystemIsRunningAt(String arg1) throws Throwable {

        goTo(URL);
        await().until(el(By.className(SUBMIT_BTN_NEXT))).clickable();

    }

    @When("^the user submits the credentials for user \"([^\"]*)\"$")
    public void theUserEntersTheCredentialsForUser(String arg1) throws Throwable {
        el(By.id("username")).write("BillyBob12");
        el(By.id("password")).write("BillyBob12");
        el(By.className(SUBMIT_BTN_NEXT)).click();

    }

    @Then("^I expect them to be shown the profile for \"([^\"]*)\"$")
    public void iExpectToBeGreetedWith(String arg1) throws Throwable {
        takeScreenshot("target/dump.png");
        final FluentWebElement firstName = el(By.id("firstName"));
        await().until(firstName).present();
        assertThat(firstName.value()).isEqualTo("Jim");
    }

    @Before
    public void beforeTest() {
        this.initFluent(newWebDriver());
    }

    private static final String HEADLESS = "headless";



    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver(getChromeCapabilities());
    }

    private DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        return capabilities;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getChromeSwitches());
        return options;
    }

    private List<String> getChromeSwitches() {
        List<String> chromeSwitches = new ArrayList<>();
        chromeSwitches.add(HEADLESS);
        return chromeSwitches;
    }


}
