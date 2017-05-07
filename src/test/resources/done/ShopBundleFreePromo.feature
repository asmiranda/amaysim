# feature/ShopBundleFreePromo.feature
Feature: Bundle Free Promo Cucumber
@ShoppingCart

Scenario Outline: Unlimited 2GB Sim Bundle Free 1 GB Data-pack
    Given customer logged in
    When customer bought <count> Unlimited 2GB Sims
    Then the customer will pay only <total_price> for total price
    And the customer will have free <free_item_count> <free_item>

    Examples:
    | count | total_price | free_item | free_item_count |
    | 3     | 89.70       | 1gb       | 3               |


