@ComponentSearch
Feature: se validan componentes Header de paris.cl

  @search
  Scenario: Buscador
    When ingreso HomePage Buscador
    Then Valido Barra de buscador desplegada

  Scenario Outline: ingreso con 2 caracteres
    When Ingreso Sku minimo<skuMinimo>
    Then Validar buscador con 2 caracteres no se visualice sugerencia

    Examples: 
      | skuMinimo |
      | ""        |

  Scenario Outline: Imagen Coincidencia
    When ingreso Sku coincidencia <skuCoincidencia>
    Then validar imagen de coincidencia
    And validar nombre para coincidencia del producto
    And validar precio para coincidencias del producto
    And validar paginas para coincidencias que pueden ser interesantes

    Examples: 
      | skuCoincidencia |
      | ""              |

  Scenario Outline: Perdida de foco sugerencias
    When ingreso sku sugerencia <skuSugerencias>
    Then validar redireccionamiento de suguerencias que pueden ser interesantes

    Examples: 
      | skuSugerencias |
      | ""             |

  Scenario Outline: Busqueda por sku incorrecto
    When ingreso Sku sin coincidencia <skuMal>
    Then Validar que busqueda no tiene coincidencias
    And validar que muestre la palabra buscada
    And validar que puedo escribir una nueva busqueda

    Examples: 
      | skuMal |
      | ""     |
