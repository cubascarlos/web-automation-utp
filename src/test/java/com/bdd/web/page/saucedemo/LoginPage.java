package com.bdd.web.page.saucedemo;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Util;

public class LoginPage extends BaseWeb {
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    public LoginPage open() {
        String baseUrl = Util.getFromConfigFile("url.saucedemo");
        driver.get(baseUrl);
        return this;
    }

    public LoginPage ingresarCredenciales(String usuario, String contrasena) {
        waitUntilElementIsVisible(usernameField, 10);
        usernameField.clear();
        usernameField.sendKeys(usuario);
        passwordField.clear();
        passwordField.sendKeys(contrasena);
        return this;
    }

    public HomePage clickLoginButton() {
        waitUntilElementIsVisible(loginButton, 10);
        loginButton.click();
        return new HomePage(driver);
    }

    /**
     * Completa el login y retorna la página home
     */
    public HomePage login(String usuario, String contrasena) {
        ingresarCredenciales(usuario, contrasena);
        return clickLoginButton();
    }

    public String obtenerMensajeError() {
        waitUntilElementIsVisible(errorMessage, 10);
        return errorMessage.getText();
    }

    /**
     * Valida si hay mensaje de error visible
     */
    public boolean validarMensajeErrorVisible() {
        return isElementVisible(errorMessage, 9);
    }
}
