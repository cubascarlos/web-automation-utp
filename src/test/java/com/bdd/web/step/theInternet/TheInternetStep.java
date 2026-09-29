package com.bdd.web.step.theInternet;

import com.bdd.web.page.theInternet.TheInternetPage;

public class TheInternetStep {

    TheInternetPage theInternetPage = new TheInternetPage();

    public void seleccionaModuloDeprueba(String valueModulo) {
        theInternetPage.seleccionaModuloDePruebaEspecifico(valueModulo);
    }

    public void seSeleccionaCheckBoxPorIndice(Integer indiceCheckBox) {
    }
}
