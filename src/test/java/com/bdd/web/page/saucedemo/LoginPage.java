package com.bdd.web.page.saucedemo;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Util;

public class LoginPage extends BaseWeb {

    protected WebDriver driver = driver();

    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public void open() {
        String baseUrl = Util.getFromConfigFile("url.saucedemo");
        driver.get(baseUrl);
    }

    public void ingresarCredenciales(String usuario, String contrasena) {
        waitUntilElementIsVisible(usernameField, 10);
        usernameField.clear();
        usernameField.sendKeys(usuario);
        passwordField.clear();
        passwordField.sendKeys(contrasena);
    }

    public void clickLoginButton() {
        waitUntilElementIsVisible(loginButton, 10);
        loginButton.click();
    }

    public String obtenerMensajeError() {
        waitUntilElementIsVisible(errorMessage, 10);
        return errorMessage.getText();
    }

    public boolean validarMensajeErrorVisible() {
        return isElementVisible(errorMessage, 9);
    }
}
