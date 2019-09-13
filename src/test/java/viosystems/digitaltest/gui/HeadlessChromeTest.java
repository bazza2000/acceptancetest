package viosystems.digitaltest.gui;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import viosystems.digitaltest.gui.HeadlessChromeConfig;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See more at http://www.awesome-testing.com/2017/05/headless-testing-with-google-chrome.html
 */
public class HeadlessChromeTest extends HeadlessChromeConfig {

    private static final String URL = "https://demo.viosystems.com/EnterUsername";
    private static final String SUCCESS_TEXT = "HTTP 200 OK";

    private static final String SUBMIT_BTN_NEXT = "button__submit-btn--next";
    private static final String ALERT_RESULT_CSS = ".alert-success";

    @SuppressWarnings("Duplicates")
    @Test
    public void ajaxCallTest() throws InterruptedException {
        goTo(URL);
        await().until(el(By.className(SUBMIT_BTN_NEXT))).clickable();
        el(By.id("username")).write("BillyBob12");
        el(By.id("password")).write("BillyBob12");
        el(By.className(SUBMIT_BTN_NEXT)).click();
        final FluentWebElement firstName = el(By.id("firstName"));
        await().until(firstName).present();
        assertThat(firstName.value()).isEqualTo("Jim");
    }



}

