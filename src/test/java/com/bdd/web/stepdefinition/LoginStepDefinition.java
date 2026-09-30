package com.bdd.web.stepdefinition;

import com.bdd.hooks.BaseWeb;
import com.bdd.web.step.saucedemo.LoginStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinition extends BaseWeb {

    private LoginStep loginStep = new LoginStep();

    @Given("el usuario carga la pagina")
    public void usuarioCargaLaPagina() {
        loginStep.abrirPaginaLogin();
    }

    @When("el usuario ingresa {string} y {string}")
    public void usuarioIngresa(String usuario, String contrasena) {
        loginStep.ingresarCredenciales(usuario, contrasena);
    }

    @Then("se valida que el usuario ingresa correctamente")
    public void usuarioIngresaCorrectamente() {
        boolean loginExitoso = loginStep.realizarLogin();
        Assert.assertTrue(
                "La pagina home no cargo correctamente",
                loginExitoso
        );
    }

    @Then("se muestra mensaje de error al ingresar {string}")
    public void seMuestraMensajeDeError(String mensajeEsperado) {
        boolean mensajeValido = loginStep.validarMensajeError(mensajeEsperado);
        Assert.assertTrue(
            "El mensaje de error no coincide " + loginStep.obtenerMensajeError(),
            mensajeValido
        );
    }
}

