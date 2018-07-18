@homePage
Feature: Se Valida Componentes Home Page 

  @tag1
  Scenario: Validad existencia carrusel
    Then Se valida carrusel de manera correcta

  @tag2
  Scenario Outline: Validad pausa y play en carrusel 
    When Selecciono estado stop o play del carrusel <estado>
    Then Se valida funcionamiento correcto del carrusel segun estado

    Examples: 
      | estado  |
      | "play"  |
      | "stop"  |

  @tag2
  Scenario Outline: Validad direccion del carrusel adelante y atras  
    When Selecciono trayecto adelante y atras del carrusel <trayecto>
    Then Se valida funcionamiento correcto del carrusel segun trayecto

    Examples: 
      | trayecto  |
      | "adelante"|
      | "atras"   |
      
      
      