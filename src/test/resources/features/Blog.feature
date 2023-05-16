Feature: Funcionamiento del Blog de Profile

  @Blog
  Scenario Outline: Experiencia de uso en el blog
    
    Given el usuario accede a la sección del Blog
    When selecciona la categoría <nombreCategoria>
      And selecciona el primer artículo
    Then se carga el contenido del artículo
    
    Examples:
    | nombreCategoria |
    | Big Data |
    | Desarrollo web |
