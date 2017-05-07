# feature/ShopAccrossDealPromo.feature
Feature: Accross Deal Promo Cucumber
@ShoppingCart

Scenario Outline: Accross Deal Promo
    Given customer logged in
    When customer bought <count> Unlimited 2GB Sims
    And customer apply the promo code <promo>
    Then the customer will pay only <total_price> for total price
    And the customer will have free <free_item_count> <free_item>

    Examples:
    | count | promo      | total_price | free_item | free_item_count |
    | 3     | I<3AMAYSIM | 80.73       | 1gb       | 3               |


