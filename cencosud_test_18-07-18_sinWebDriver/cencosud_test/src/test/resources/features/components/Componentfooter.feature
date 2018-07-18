@footerComponent
Feature: Validacion de componentes de footer en pagina paris.cl

  @footer
  Scenario: Footer
    When ingreso al homePage
    Then Valido que esxista footer en pagina

  Scenario: newletter
    Then Validar link de subscripción de Newletter

  Scenario: servicio al cliente
    Then valido numero servicio al cliente

  Scenario: numero venta telefonica
    Then Valido numero venta telefonica

  Scenario: Link facebook
    Then valido link de facebook

  Scenario: Link twiter
    Then Valido link twiter

  Scenario: Link instagram
    Then valido link instagram

  Scenario: Link contactanos
    Then valido link contactanos footer

  Scenario: Link  beneficios paris.cl
    Then valido link beneficios paris.cl

  Scenario: Link  terminos y condiciones
    Then valido link terminos y condiciones

  Scenario: link politicas y privacidad
    Then Valido link politicas de privacidad

  Scenario: link Recupera tu boleta
    Then valido link Recupera tu boleta

  Scenario: link encuesta de opinion
    Then valido link encuesta de opinion

  Scenario: link puntos cencosud
    Then valido link puntos cencosud

  Scenario: link tarjetas cencosud
    Then valido link tarjetas cencosud
    
    Scenario: link seguros cencosud
    Then valido link seguros cencosud
    
    Scenario: Link venta empresas
    And valido link venta empresas
    
    Scenario: Trabaja con nosotros
    Then valido link Trabaja con nosotros
    
    Scenario: link devoluciones y cambios 
    Then valido link devoluciones y cambios
    
    Scenario: link despacho
    Then valido link despacho
    
    Scenario: link garantia extendida
    Then valido link garantia extendida
    
    Scenario: link medios de pago
    Then valido link medios de pago
    
    Scenario: link tiendas paris
    Then valido link tiendas paris
    
    Scenario: link Easy
    Then valido link Easy
    
    Scenario: link Jumbo
    Then valido link Jumbo
    
    Scenario: link Jhonson
    Then valido link Jhonson
    
    Scenario: link santa isabel
    Then valido link Santa Isabel
    
    Scenario: link umbrale
    Then valido link Umbrale
    
    Scenario: link novios paris
    Then valido link novios paris
    
    Scenario: link bebe paris
    Then valido link bebe paris
    
    Scenario: link casa paris
    Then valido link casa paris
    
    
    
  
  
      #@homePage
      #Scenario Outline: homePage
      #When ?????
      #Then ????
      #
      #Examples:
      #|dd|
      #|""|
     #
      #@Cart
      #Scenario: carro de compras
      #
      #When ingreso al carro de compras
      #Then valido link de imagen de producto
      #And valido link de nombre de producto}
      #And validar cantidad desplegable
      #And validar precio del producto
      #And validar iconos de metodos de envios
      #And validar producto con despacho a domicilio
      #And Validar producto con tipos de entrega asociados
      #And Validar seleccion de color en producto
      #And Validar talla del producto
      #And Validar armado del producto
     #And Validar garentia del producto
     #And Validar informacion de subtotal
     #And validar dscto en producto con promocion
     #And validar informacion del total
     #And validar costo de envio
     #And validar descuento de envio
     #And validar subtotal con tarjeta cencosud
     #And validar subtotal con tarjeta cencosud
     #And validar subTotal con otro medio de pago
     #And validar link agregar a favoritos
     #And validar link editar detalle
     #And Validar agregar cupon
    #
     #
      #
      #
      #
