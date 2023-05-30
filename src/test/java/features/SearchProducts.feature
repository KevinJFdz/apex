@SearchProducts
Feature: Search Products
  As a Liverpool customer
  I want to be able to search for specific products
  So that I can see the products I want to buy

  Background:
    Given the Liverpool customer is on the dashboard page

  @TCSP001
  Scenario: Search for Play Station 5
    When the Liverpool customer searches for "Play Station 5"
    Then the Liverpool application should display the search results with titles and prices for each product
    Then the Liverpool application should display search results with product titles containing "Play Station 5"

  @TCSP002
  Scenario: Displaying Size and Price Filters for Smart TV Search
    When the Liverpool customer searches for "Smart tv"
    Then the Liverpool application should display size and price filters

  @TCSP003
  Scenario: Matching Filtered Search Results Display
    When the Liverpool customer searches for "Smart tv"
    And the Liverpool customer applies the filters for size: "55" inches, price: above ten thousand, and brand: "Sony"
    Then the Liverpool application should display the same number of results as indicated by the applied filters

  @TCSP004
  Scenario: Filter Search Results for Men's Perfumes by Dior Brand
    When the Liverpool customer navigates to the categories section
    And the Liverpool customer selects the "Belleza" category
    And And the Liverpool customer chooses the "Perfumes Hombre" subcategory
    And the Liverpool customer applies a filter for the "Dior" brand on the search results
    Then the Liverpool application should display search results with product titles containing "Dior"
