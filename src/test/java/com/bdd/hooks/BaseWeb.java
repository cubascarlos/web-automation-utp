package com.bdd.hooks;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ScenarioContext;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseWeb {

    protected static WebDriver driver() {
        return WebDriverManager.getWebDriver();
    }

    public BaseWeb() {
        PageFactory.
                initElements(WebDriverManager.getWebDriver(), this);
    }

    private static WebDriverWait webDriverWait(int time) {
        return new WebDriverWait(
                driver(),
                Duration.ofSeconds(time));
    }

    public static void waitUntilElementIsVisible(WebElement element, int time) {
        webDriverWait(time).
                until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickeable(WebElement element, int time) {
        webDriverWait(time).
                until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isElementVisible(WebElement element, int time) {
        try {
            webDriverWait(time).
                    until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void takeScreenShot() {
        Scenario scenario1 = ScenarioContext.getVariableOnSession("scenario");
        byte[] screenshoot = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);
        scenario1.attach(screenshoot, "image/png", "evidence");
    }

    public static void takeScreenShotOfElement(WebElement element) {
        Scenario scenario1 = ScenarioContext.getVariableOnSession("scenario");
        byte[] screenshoot = element.getScreenshotAs(OutputType.BYTES);
        scenario1.attach(screenshoot, "image/png", "evidenceOfElement");
    }

    public static void selectElementInList(List<WebElement> listElement, String target) {
        for (WebElement element : listElement) {
            if (element.getText().equals(target)) {
                element.click();
                break;
            } else Logger.getGlobal().log(Level.INFO, "No se encontro el elemento: {0} en la lista", target);
        }
    }

}
