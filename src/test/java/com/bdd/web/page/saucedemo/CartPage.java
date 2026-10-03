package com.bdd.web.page.saucedemo;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseWeb {

    @FindBy(xpath = "//span[@class='title' and text()='Your Cart']")
    private WebElement titleCart;
    @FindBy(id = "checkout")
    private WebElement btnChekout;

    public boolean validarTituloCarritoDeCompra(){
        return isElementVisible(titleCart,10);
    }

}
