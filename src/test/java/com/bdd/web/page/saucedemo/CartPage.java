package com.bdd.web.page.saucedemo;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseWeb {

    @FindBy(css = "span.title")
    private WebElement titleCart;

    public boolean validarTituloCarritoDeCompra(){
        return isElementVisible(titleCart,10);
    }

}
