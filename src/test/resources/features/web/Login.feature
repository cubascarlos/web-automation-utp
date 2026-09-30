#language: en

Feature: Login en Saucedemo

  Background:
    Given el usuario carga la pagina

  @login @smoke
  Scenario Outline: Login exitoso con multiples usuarios
    When el usuario ingresa "<usuario>" y "<contraseña>"
    Then se valida que el usuario ingresa correctamente
    Examples:
      | usuario       | contraseña   |
      | standard_user | secret_sauce |

  @loginFail @smoke
  Scenario: Failed login with invalid credentials
    When el usuario ingresa "invalid_user" y "claveerrada"
    Then se muestra mensaje de error al ingresar "Epic sadface: Username and password do not match any user in this service"


