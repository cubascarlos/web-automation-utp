package com.bdd.web.stepdefinition;

import com.bdd.web.step.saucedemo.CompraStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class CompraStepDefinition {

    private final CompraStep compraStep = new CompraStep();

    @And("usuario agrega producto al carrito de compras")
    public void usuarioAgregaProductoAlCarritoDeCompras() {
        compraStep.agregarProductoAlCarrito();
    }

    @And("el usuario se dirige al carrito de compras")
    public void elUsuarioSeDirigeAlCarritoDeCompras() {
        compraStep.usuarioSedirigeAlCarritoDeCompras();
    }

    @And("el usuario valida que se muestra la seccion carrito de compras")
    public void elUsuarioValidaQueSeMuestraLaSeccionCarritoDeCompras() {
        Assert.assertTrue("No se muestra la seccion de carrito de compra",
                compraStep.usuarioValidaSeMuestraSeccionCarritoDeCompras());
    }

    @And("el usuario realiza checkout")
    public void elUsuarioRealizaCheckout() {
        compraStep.usuarioRealizaCheckout();
    }
}
