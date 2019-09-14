package viosystems.digitaltest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.fluentlenium.configuration.FluentConfiguration;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features"
        , glue = "viosystems.digitaltest.steps"
        , snippets = CucumberOptions.SnippetType.CAMELCASE
        , strict = false
        , plugin = { "pretty", "html:target/cucumber/" }
        ,monochrome = true
)
public class AcceptanceTest {




}
