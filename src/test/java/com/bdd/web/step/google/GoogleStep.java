package com.bdd.web.step.google;

import com.bdd.web.page.saucedemo.GooglePage;

public class GoogleStep {
    GooglePage googlePage = new GooglePage();

    public void seBuscaEnGoogle(String valorBusqueda) {
        googlePage.buscoEnInputDeBusquedaDeGoogle(valorBusqueda);
    }

    public boolean seValidanResultadosRelevantesDeLaBusqueda() {
        return googlePage.seValidanResultadoRelevantesDeLaBusqueda();
    }

    public void seRealizaBusquedaConTeclaEnter() {
        googlePage.seRealizaBusquedaConTeclaEnter();
    }
}
