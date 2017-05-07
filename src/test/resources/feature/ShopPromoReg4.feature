# feature/ShopPromoReg4.feature
Feature: Shop Promo Reg 4
@ShoppingCart

Scenario Outline: Promo Test 4
    Given customer logged in
    When customer bought <count> Unlimited 1GB Sims
    And customer bought <count_1gb_data> 1 GB Data-pack
    And customer apply the promo code <promo>
    Then the customer will pay only <total_price> for total price

    Examples:
    | count | count_1gb_data | total_price | promo      |
    | 1     | 1              | 31.32       | I<3AMAYSIM |
