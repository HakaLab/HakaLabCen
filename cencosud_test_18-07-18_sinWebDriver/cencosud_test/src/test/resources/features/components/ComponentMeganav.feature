@ComponentMeganav
Feature: se validan componentes meganav de paris.cl

  @meganav
  Scenario Outline: Meganav
   # Given ingresi pagina paris.cl
    Then valido que se visualicen 13 categorias
    And validar mouse sobre categoria <categoria>
    And validar Url de categoria. <categoria>

    Examples: 
      | categoria      |
      | "Belleza"      |
      | "Deco"         |
      | "Deportes"     |
      | "Dormitorio"   |
      | "Electro"      |
      | "Juguetes"     |
      | "Línea Blanca" |
      | "Moda"         |
      | "Muebles"      |
      | "Mujer"        |
      | "Niños"        |
      | "Tecno"        |
      | "Zapatos"      |
