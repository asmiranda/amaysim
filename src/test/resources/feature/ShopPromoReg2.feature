# feature/ShopPromoReg1.feature
Feature: Shop Promo Reg 2
@ShoppingCart

Scenario Outline: Promo Test 2
    Given customer logged in
    When customer bought <count> Unlimited 1GB Sims
    And customer bought <count_5gb> Unlimited 5GB Sims
    Then the customer will pay only <total_price> for total price

    Examples:
    | count | count_5gb | total_price |
    | 3     | 4         | 209.40      |
