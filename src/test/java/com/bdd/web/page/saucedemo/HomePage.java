package com.bdd.web.page.saucedemo;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseWeb {
    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement sidebarLogo;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement itemMochila;
    @FindBy(xpath = "//a[@data-test=\"shopping-cart-link\"]")
    private WebElement btnCarrito;


    public boolean validarPaginaHomeCargada() {
        return isElementVisible(pageTitle, 20);
    }

    public void clicAddToCartOnProduct(){
        waitUntilElementIsVisible(itemMochila,10);
        itemMochila.click();
    }

    public void clicCarritoDeCompras(){
        waitUntilElementIsVisible(btnCarrito,10);
        btnCarrito.click();
    }
}
