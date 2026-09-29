package com.bdd.web.page.theInternet;

import com.bdd.hooks.BaseWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TheInternetPage extends BaseWeb {

    @FindBy(xpath = "//ul/li/a")
    List<WebElement> listModulosDePrueba;

    public void seleccionaModuloDePruebaEspecifico(String valueModulo) {
        selectElementInList(listModulosDePrueba, valueModulo);
    }
}
