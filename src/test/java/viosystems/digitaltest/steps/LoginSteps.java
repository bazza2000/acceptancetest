package viosystems.digitaltest.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;


import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

public class LoginSteps extends FluentCucumberTest {

    private static final String SUBMIT_BTN_NEXT = "button__submit-btn--next";

    @Given("^the system is running at \"([^\"]*)\"$")
    public void theSystemIsRunningAt(String url) throws Throwable {

        goTo(url);
        await().until(el(By.className(SUBMIT_BTN_NEXT))).clickable();

    }

    @When("^the user submits valid username and password credentials$")
    public void theUserEntersTheCredentialsForUser() throws Throwable {
        el(By.id("username")).write("jimbo");
        el(By.id("password")).write("anything");
        el(By.className(SUBMIT_BTN_NEXT)).click();

    }

    @When("^the user submits unknown username and password credentials$")
    public void theUserEntersUnknownCredentials() throws Throwable {
        el(By.id("username")).write("anything");
        el(By.id("password")).write("anything");
        el(By.className(SUBMIT_BTN_NEXT)).click();

    }

    @Then("^I expect them to be authenticated and allowed access to their profile$")
    public void iExpectToBeGreetedWith() throws Throwable {
        final FluentWebElement firstName = el(By.id("firstName"));
        await().until(firstName).present();
        assertThat("Jim").isEqualTo(firstName.value());
        assertThat("Lack").isEqualTo(el(By.id("surname")).value());
    }

    @Then("^I expect them to be denied access$")
    public void iExpectThemToBeDeniedAccess() throws Throwable {
        takeScreenshot();
        final FluentWebElement firstName = el(By.id("firstName"));
        await().until(firstName).present();
        assertThat("Unknown").isEqualTo(firstName.value());
    }

    @Before
    public void beforeTest() {
        this.initFluent(newWebDriver());
    }

    @After
    public void after(Scenario scenario) {

        WebDriver augmentedDriver = new Augmenter().augment(getDriver());
        byte[] s = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(s, "image/png");
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
