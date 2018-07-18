@MiniCart
Feature: Validar componente mini cart

  @validationDisplayedObjects
  Scenario Outline: Ingreso sku a mini carro para validaciones
    Given ingreso url miniCart
    When ingreso sku miniCart<sku>
    And selecciono detalles de producto miniCart<tipoProducto><cantidad><conArmado><conGarantia>
    And se agrega producto al carro miniCart
    And se cancela producto bonificacion para mostrar miniCart

    Examples: 
      | sku           |tipoProducto|cantidad|conArmado|conGarantia|
      | "123421-999-" | "standard" | "2"    | ""      | ""        |
  @tag1
  Scenario: Titulo de pagina mini carro
    Then Se valida titulo de mini carro
    
  @tag1
  Scenario: Imagen de sku del mini carro
    Then Se valida imagen de sku en mini carro
    
   @tag1
  Scenario: Nombre de sku del mini carro
    Then Se valida nombre de sku en mini carro

  @tag1
  Scenario: Cantidad de producto en mini carro
    Then Se valida el numero de la cantidad de productos en el mini carros

  @tag1
  Scenario: Funcionamiento correcto de la imagen del producto en mini carro
    When Se Selecciona la imagen del producto en el mini carro
    
    #Then Se verifica redireccionamiento al hacer click a la imagen del producto pdp

 