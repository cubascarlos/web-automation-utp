package com.bdd.web.page.saucedemo;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseWeb {
    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement sidebarLogo;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    /**
     * Valida si la página de inventario se cargó correctamente
     */
    public boolean validarPaginaInventarioCargada() {
        return isElementVisible(pageTitle, 20);
    }

    /**
     * Obtiene el nombre de usuario que aparece en el sidebar
     */
    public String obtenerNombreUsuario() {
        try {
            return sidebarLogo.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
