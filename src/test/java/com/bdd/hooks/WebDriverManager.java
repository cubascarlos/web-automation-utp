package com.bdd.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.Util;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverManager {
    public static WebDriver driver;

    public static void setWebDriver() {

        String browser = System.getProperty("browser") != null
                ? System.getProperty("browser")
                : Util.getFromConfigFile("browser");
        String isHeadless = System.getProperty("headless", "false");
        switch (browser) {
            case "chrome":
                ChromeDriverService service = new ChromeDriverService.Builder().build();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless.equals("true")) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                }
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--remote-allow-origins=*");
                /*System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");*/
                /*driver = new ChromeDriver(chromeOptions);*/
                driver = new ChromeDriver(service, chromeOptions);
                Logger.getGlobal().log(Level.INFO, "Iniciando navegador: ", browser);
                break;
            case "edge":
                EdgeDriverService edgeService = new EdgeDriverService.Builder().build();
                //driver = new EdgeDriver(edgeService, edgeOptions);
                /*System.setProperty("webdriver.edge.driver", "drivers/win/msedgedriver.exe");*/
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(edgeService, edgeOptions);
                Logger.getGlobal().log(Level.INFO, "Iniciando navegador: ", browser);
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.driver", "drivers/win/geckodriver.exe");
                driver = new FirefoxDriver();
                Logger.getGlobal().log(Level.INFO, "Iniciando navegador: ", browser);
                break;
            default:
                Logger.getGlobal().log(Level.WARNING, "Navegador {0} no Soportado", browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Util.getFromConfigFile("implicit.wait.general.on.seconds"))));
    }

    public static void stopWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void goTo(String url) {
        driver.get(url);
    }

}
