#language: en

Feature: Agregar productos a carrito

  @addProduct
  Scenario: Agregar producto
    Given el usuario carga la pagina
    And el usuario ingresa "standard_user" y "secret_sauce"
    And se valida que el usuario ingresa correctamente
    And usuario agrega producto al carrito de compras
    And el usuario se dirige al carrito de compras
    And el usuario valida que se muestra la seccion carrito de compras
