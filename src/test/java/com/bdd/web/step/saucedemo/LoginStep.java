package com.bdd.web.step.saucedemo;

import com.bdd.hooks.BaseWeb;
import com.bdd.web.page.saucedemo.HomePage;
import com.bdd.web.page.saucedemo.LoginPage;
import util.ScenarioContext;

public class LoginStep extends BaseWeb {

    private LoginPage loginPage;
    private HomePage homePage;

    public void abrirPaginaLogin() {
        loginPage = new LoginPage(driver());
        loginPage.open();
        BaseWeb.takeScreenShot();
    }

    public void ingresarCredenciales(String usuario, String contrasena) {
        ScenarioContext.saveVariableOnSession("usuario", usuario);
        loginPage.ingresarCredenciales(usuario, contrasena);
        BaseWeb.takeScreenShot();
    }

    public boolean realizarLogin() {
        loginPage.clickLoginButton();
        homePage = new HomePage(driver());
        BaseWeb.takeScreenShot();
        return homePage.validarPaginaInventarioCargada();
    }

    public boolean validarMensajeError(String mensajeEsperado) {
        loginPage.clickLoginButton();
        BaseWeb.takeScreenShot();
        if (!loginPage.validarMensajeErrorVisible()) {
            return false;
        }
        String mensajeActual = loginPage.obtenerMensajeError();
        return mensajeEsperado.equals(mensajeActual);
    }

    public String obtenerMensajeError() {
        return loginPage.obtenerMensajeError();
    }
}
