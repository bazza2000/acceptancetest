package viosystems.digitaltest.gui;

import org.fluentlenium.core.FluentControl;
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

    private static final String URL = "http://localhost:3000/EnterUsername";
    private static final String SUCCESS_TEXT = "HTTP 200 OK";

    private static final String SUBMIT_BTN_NEXT = "button__submit-btn--next";
    private static final String ALERT_RESULT_CSS = ".alert-success";

    @SuppressWarnings("Duplicates")
    @Test
    public void ajaxCallTest() {
        goTo(URL);
        await().until(el(By.className(SUBMIT_BTN_NEXT))).clickable();
        el(By.id("username")).write("BillyBob12");
        el(By.id("password")).write("BillyBob12");
        takeScreenshot();
        el(By.className(SUBMIT_BTN_NEXT)).click();
        await().until(el(By.id("firstName")));
        takeScreenshot();

        //await().atMost(5, TimeUnit.SECONDS).untilPredicate(ajaxCallCompleted);
        //assertThat(el(ALERT_RESULT_CSS).text()).isEqualTo(SUCCESS_TEXT);
    }

    private Predicate<FluentControl> ajaxCallCompleted = fluent -> {
        final JavascriptExecutor driver = (JavascriptExecutor) getDriver();
        return (Boolean) driver
                .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
    };

}

