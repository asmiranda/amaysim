# feature/ShopBulkDiscountPromo.feature
Feature: Bulk Discount Promo Cucumber
@ShoppingCart

Scenario Outline: Unlimited 5GB Sim Bulk
    Given customer logged in
    When customer bought <count> Unlimited 5GB Sims
    Then the customer will pay only <total_price> for total price

    Examples:
    | count | total_price |
    | 4     | 159.60      |


