package com.bdd.web.page.google;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ScenarioContext;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GooglePage extends BaseWeb {

    @FindBy(name = "q")
    WebElement inputBusqueda;
    @FindBy(css = "div.v7W49e  div.yuRUbf a h3")
    List<WebElement> listResultadoBusquedaGoogle;

    public void buscoEnInputDeBusquedaDeGoogle(String valorBusqueda) {
        Logger.getGlobal().log(Level.INFO, "BUSCANDO EN GOOGLE...");
        ScenarioContext.saveVariableOnSession("parameterToSearch", valorBusqueda);
        inputBusqueda.sendKeys(valorBusqueda);
        takeScreenShot();
    }

    public boolean seValidanResultadoRelevantesDeLaBusqueda() {
        boolean flagResults = false;
        for (WebElement element : listResultadoBusquedaGoogle) {
            Logger.getGlobal().log(Level.INFO, element.getText());
            if (element.getText().contains(ScenarioContext.getVariableOnSession("parameterToSearch"))) {
                flagResults = true;
            } else Logger.getGlobal().log(Level.INFO, "Se encontraron resultados no relevantes");
        }
        takeScreenShot();
        return flagResults;
    }

    public void seRealizaBusquedaConTeclaEnter() {
        inputBusqueda.sendKeys(Keys.ENTER);
        takeScreenShot();
        takeScreenShotOfElement(inputBusqueda);
    }

}
