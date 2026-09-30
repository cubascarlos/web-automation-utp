#language: en

@NTLC-2
Feature: Busqueda en Google

  Background: Iniciación de la web
    Given que se carga la pagina de google

  @NTLC-1 @smoke
  Feature: Login saucedemo
    Dado que se ingresa "Performance" en google
#    Cuando se realiza la busqueda con la tecla Enter
#    Entonces valido que se muestran resultados relevantes
    