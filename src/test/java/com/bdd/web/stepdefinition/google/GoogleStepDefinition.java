package com.bdd.web.stepdefinition.google;

import com.bdd.hooks.BaseWeb;
import com.bdd.hooks.WebDriverManager;
import com.bdd.web.step.google.GoogleStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import util.ScenarioContext;

import java.util.List;

public class GoogleStepDefinition extends BaseWeb {

//    private Scenario scenario;

//    @Before()
//    public void beforeScenario(Scenario scenario) {
//        this.scenario = scenario;
//        ScenarioContext.saveVariableOnSession("scenario", this.scenario);
//    }

    GoogleStep googleStep = new GoogleStep();
    String url = "http://www.google.com.pe";

    @Dado("que se carga la pagina de google")
    public void que_cargo_la_pagina_de_google() {
        WebDriverManager.goTo(url);
        //BaseWeb.takeScreenShot();
    }

    @Dado("que se ingresa {string} en google")
    public void se_busca_en_google(String valorBusqueda) {
        googleStep.seBuscaEnGoogle(valorBusqueda);
    }

    @Entonces("valido que se muestran resultados relevantes")
    public void valido_que_se_muestran_resultados_relevantes() {
        Assert.assertTrue("No se encontraron resultado relevantes",
                googleStep.seValidanResultadosRelevantesDeLaBusqueda());
    }

    @Y("valido los siguientes datos")
    public void validoLosSiguientesDatos(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        System.out.println(data.get(0).get(0));
        System.out.println(data.get(0).get(1));
        System.out.println(data.get(1).get(0));
        System.out.println(data.get(1).get(1));
    }

    @Cuando("se realiza la busqueda con la tecla Enter")
    public void seRealizaBusquedaConTeclaEnter() {
        googleStep.seRealizaBusquedaConTeclaEnter();
    }

}
