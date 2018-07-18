@Cart
Feature: Validar componente cart

  @validationDisplayedObjects
  Scenario Outline: Ingreso sku a carro de compra para validaciones
    Given ingreso url
    When ingreso sku <sku>
    And selecciono detalles de producto <tipoProducto><cantidad><conArmado><conGarantia>
    And se agrega producto al carro

    Examples: 
      | sku           |tipoProducto|cantidad|conArmado|conGarantia|
      | "123421-999-" | "standard" | "2"    | ""      | ""        |
  @tag1
  Scenario: Titulo de pagina carro de compra
    Then Se valida titulo de carro de compra

  @tag1
  Scenario: Numero de producto en carro de compra
    Then Se valida el numero de la cantidad de productos en el carro de compras

  @tag1
  Scenario: Funcionamiento correcto de la imagen del producto en carro de compra
    When Se Selecciona la imagen del producto en el carro de compra
    Then Se verifica redireccionamiento al hacer click a la imagen del producto pdp

  @tag1
  Scenario: Funcionamiento correcto del nombre del producto en carro de compra
    When Se Selecciona el nombre del producto en el carro de compra
    Then Se verifica redireccionamiento al hacer click nombre del producto pdp

  @tag1
  Scenario: Codigo de producto SKU
    Then Se valida el codigo sku en carro de compra

  @tag1
  Scenario: Cantidad desplegable del producto
    Then Se valida la cantidad desplegable del producto en carro de compra

  @tag1
  Scenario: Precios totales segun el precio del producto
    Then Se valida los precios totales segun el precio del producto

  @tag1
  Scenario: Despliege de Precios segun regla de negocio
    Then Se valida precios segun regla de  negocio

  @tag1
  Scenario: Iconos de metodos de envio
    Then Se valida iconos de metodos de envios

  @tag1
  Scenario: Producto con despacho a domicilio asociado
    Then Se valida producto con despacho a domicilio asociado

  @tag1
  Scenario: Producto con retiro en tienda asociado
    Then Se valida producto con retiro en tienda asociado

  @tag1
  Scenario: Producto con ambos atributos de entrega asociados
    Then Se valida producto con ambos atributos de entrega asociado

  @tag1
  Scenario: Producto con cualquier atributo de entrega asociado
    Then Se valida producto con cualquier atributo de entrega asociado

  @tag1
  Scenario: Mostrar color del producto seleccionado en el carro de compras
    Then Se valida el color del producto en el carro de compras

  @tag1
  Scenario: Mostrar talla del producto seleccionado en el carro de compras
    Then Se valida la talla del producto en el carro de compras

  @tag1
  Scenario: Mostrar producto con armado en el carro de compras
    Then Se valida la opcion de armado del producto en el carro de compras

  @tag1
  Scenario: Mostrar producto con garantia en el carro de compras
    Then Se valida la opcion de garantia del producto en el carro de compras

  @tag1
  Scenario: Mostrar informacion sub total
    Then Se valida la informacion del sub total en el carro de compra

  @tag1
  Scenario: Mostrar informacion de descuento del producto en promocion
    Then Se valida la informacioon de descuento del producto en promocion
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
