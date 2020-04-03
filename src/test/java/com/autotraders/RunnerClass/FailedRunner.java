package com.autotraders.RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * if any scenario fails, we are storing the fail details
 * in rerun.txt and we are only calling failed scenarios.
 */


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"@target/rerun.txt",},
            glue = "com/autotraders/StepDefinitions",

            plugin = {
                    "html:target/rerun-default-cucumber-reports",
                    "json:target/cucumber_failure.json"
            }

    )
    public class FailedRunner {
    }


