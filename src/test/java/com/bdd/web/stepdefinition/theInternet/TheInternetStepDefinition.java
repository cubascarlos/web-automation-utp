package com.bdd.web.stepdefinition.theInternet;

import com.bdd.hooks.WebDriverManager;
import com.bdd.web.step.theInternet.TheInternetStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import util.Util;

import java.io.IOException;

public class TheInternetStepDefinition {

    TheInternetStep theInternetStep = new TheInternetStep();

    @Dado("que se carga la web the internet")
    public void que_se_carga_la_web_the_internet() throws IOException {
        WebDriverManager.goTo(Util.getFromConfigFile("url.the.internet"));
    }
    @Cuando("selecciono el modulo de prueba {string}")
    public void selecciono_el_modulo_de_prueba(String valueModulo) {
        theInternetStep.seleccionaModuloDeprueba(valueModulo);
    }
    @Cuando("se selecciona el checkbox {int}")
    public void se_selecciona_el_checkbox(Integer indiceCheckBox) {
        theInternetStep.seSeleccionaCheckBoxPorIndice(indiceCheckBox);
    }
    @Entonces("valido que ya no se encuentra seleccionado")
    public void valido_que_ya_no_se_encuentra_seleccionado() {

    }

}
