package com.bdd.web.step.saucedemo;

import com.bdd.hooks.BaseWeb;
import com.bdd.web.page.saucedemo.CartPage;
import com.bdd.web.page.saucedemo.HomePage;

public class CompraStep extends BaseWeb {

    private HomePage homePage;
    private CartPage cartPage;


    public void agregarProductoAlCarrito() {
        homePage = new HomePage(driver());
        homePage.clicAddToCartOnProduct();
    }

    public void usuarioSedirigeAlCarritoDeCompras() {
        homePage.clicCarritoDeCompras();
    }

    public boolean usuarioValidaSeMuestraSeccionCarritoDeCompras() {
        cartPage =  new CartPage();
        return cartPage.validarTituloCarritoDeCompra();
    }
}
