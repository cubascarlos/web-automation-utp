package com.bdd.hooks;

import com.bdd.runner.RunnerTest;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.ScenarioContext;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.bdd.hooks.WebDriverManager.*;

public class Hooks {
    Scenario scenario;

    @Before
    public void beforeTest(Scenario scenario) throws IOException {
        this.scenario = scenario;
        ScenarioContext.saveVariableOnSession("scenario", this.scenario);
        Logger.getLogger(RunnerTest.class.getName()).log(Level.INFO, "BEFORE SCENARIO ---->");
        setWebDriver();
    }

    /**
     * Notacion @Before especificamente para controlar una prueba mobile.
     * Los escenarios que necesiten esta implementacion deberan tener el tag @MobileTest.
     */
    /*@Before("@MobileTest")
    public void setUpMobile() {
        Logger.getLogger(RunnerTest.class.getName()).log(Level.INFO, "BEFORE SCENARIO MOBILE---->");
        setWebDriver();
    }*/
    @After
    public void afterTest() {
        if (getWebDriver() != null) {
            Logger.getLogger(RunnerTest.class.getName()).log(Level.INFO, "AFTER SCENARIO---->");
            stopWebDriver();
        }
    }

    @AfterStep
    public void isFailedAddScreenShoot(Scenario scenario) {
        this.scenario = scenario;
        if (this.scenario.isFailed()) {
            byte[] screenShoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShoot, "image/png", "evidence");
        }
    }


}
