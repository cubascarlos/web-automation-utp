package com.bdd.web.step.saucedemo;

import com.bdd.hooks.BaseWeb;
import com.bdd.web.page.saucedemo.CartPage;
import com.bdd.web.page.saucedemo.HomePage;

public class CompraStep {

    private HomePage homePage = new HomePage();
    private CartPage cartPage = new CartPage();


    public void agregarProductoAlCarrito() {
        homePage.clicAddToCartOnProduct();
    }

    public void usuarioSedirigeAlCarritoDeCompras() {
        homePage.clicCarritoDeCompras();
    }

    public boolean usuarioValidaSeMuestraSeccionCarritoDeCompras() {
        return cartPage.validarTituloCarritoDeCompra();
    }
}
