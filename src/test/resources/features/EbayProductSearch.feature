@AllTestCase
Feature: Ebay Product Search Validation

  Background: Preconditions for all the scenario and scenario outline
    Given Navigate to Ebay Home page

  @Smoke @Sanity @Regression
  Scenario: Search Product by hard coding from step definition
    When Search the product and Select the catagory
    And Click on submit button
    Then Product search result should appear
   # And Close the browser

  @Sanity @Regression
  Scenario Outline: Search multiple Product by hard coding from feature file using scenario outline
    When Search the multiple product as <ProductName> and Select the catagory as <ProductCatagory>
    And Click on submit button
    Then Product search result should appear
   # And Close the browser

    @Data1
    Examples: 
      | ProductName | ProductCatagory               |
      | Selenium    | Books                         |
      | Cricket Bat | Sporting Goods                |
      | T-shirt     | Clothing, Shoes & Accessories |

    @Data2
    Examples: 
      | ProductName | ProductCatagory |
      | Java        | Books           |
      | Basket Ball | Sporting Goods  |

