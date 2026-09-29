package com.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = {"com.bdd.web.stepdefinition", "com.bdd.hooks"},
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/build/cucumber.json",
                "rerun:target/failed_scenarios.txt"},
        tags = "@NTLC-1"
)
public class RunnerTest {

    @BeforeClass
    public static void beforeExecution() {
        Logger.getLogger(RunnerTest.class.getName()).log(Level.INFO, "BEFORE EXECUTION ---->");
    }

    @AfterClass
    public static void afterExecution() {
        Logger.getLogger(RunnerTest.class.getName()).log(Level.INFO, "AFTER EXECUTION ----->");
    }

}
