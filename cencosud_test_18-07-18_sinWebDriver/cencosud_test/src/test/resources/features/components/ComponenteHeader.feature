@headerComponent
Feature: se validan componentes Header de paris.cl

  @header
  Scenario: Redireccionamiento TopBanner
    Then Valido redireccionamiento de TopBanner

  Scenario: redireccionamiento top navigation
    Then Valido redireccionamiento Top Navigation

  Scenario: visualizacion de icono de ubicacion
    When doy click en tiendas
    Then valido icono de ubicacion de tiendas

  Scenario Outline: valido seleccion manual de region
    Then valido como accion pre marcada <region>

    Examples: 
      | region                 |
      | "Región Metropolitana" |

  Scenario: valido funcionamiento locacion
    When doy click en icono de locacion
    Then valido que muestre ubicacion actual con formato nombre numero y comuna

  Scenario Outline: validar select de region al utilizar Geolocalizacion
    Then valido que por defecto se visualice region <region>

    Examples: 
      | region   |
      | "Región" |

  Scenario: Validar tiendas
    Then Valido tiendas segun busqueda

  Scenario: Detalle de tiendas
    Then valido numero telefonico
    Then valido link mapa
    Then valido direccion
    Then valido horario

  Scenario: link ayuda
    Then Valido link ayuda

  Scenario: link ayuda-llamanos
    Then Valido link ayuda-llamanos

  Scenario: link imagen cencosud
    Then valido link imagen cencosud

  Scenario Outline: Link ordenes titulo
    When click en link ordenes
    Then Validar se muestra el título <mensajeTitutlo>

    Examples: 
      | mensajeTitutlo                              |
      | "PLEASE INTRODUCE RUT TO CHECK YOUR ORDERS" |

  Scenario: Link ordenes campo rut
    Then Validar que se despliega campo rut

  Scenario: validar texto boton búscar
    Then Validar que se encuentre tilde en boton Búscar

  Scenario Outline: validar funcionamiento de la opcion buscar errores
    When ingreso rut ordenes<rut>
    Then Validar respuesta segun rut ingresado<mensaje>

    Examples: 
      | rut     | mensaje                      |
      | "12345" | "Formato de RUT incorrecto." |
      | ""      | "Formato de RUT incorrecto." |

  Scenario Outline: validar pedidos por rut correcto
    When ingreso rut <rut>
    Then Validar orden de muestra de los pedidos
    And Validar boton para colapsar producto
    And validar fecha visualizada en formato dd/mm/aa
    And validar total del pedido con separadores de mil
    And Validar estado del pedido
    And Validar imagen
    And validar metodo de entrega
    And validar descripcion del producto
    And Validar metodo de pago
    And Validar direccion

    Examples: 
      | rut |
      | "18116472-7"  |

  Scenario: Paginacion con mas de 10 paginas
    Then valido la paginacion de las paginas

  Scenario Outline: Paginacion valido navegacion entre paginas
    When selecciono el numero de pagina <npagina>
    Then valido la navegacion entre paginas

    Examples: 
      | npagina |
      | "2"     |
      | "6"     |
      | "8"     |
      | "10"    |

  Scenario: link servicio al cliente
    Then valido link servicio al cliente

  Scenario: link venta telefonica
    Then valido link venta telefonica

  Scenario: buscador
    Then valido buscador

  Scenario: icono carro de compras
    Then valido icono carro de compras

  Scenario: productos en icono carro de compras
    Then valido productos en el icono del carro
