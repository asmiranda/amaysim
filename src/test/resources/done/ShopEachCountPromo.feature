# feature/ShopEachCountPromo.feature
Feature: Each Count Promo Cucumber
@ShoppingCart

Scenario Outline: 3 for 2 Unlimited 1GB Sims
    Given customer logged in
    When customer bought <count> Unlimited 1GB Sims and bought another <another>
    Then the customer will pay only <reduce_count> Unlimited 1GB Sims with only <total_price> total price

    Examples:
    | count | another | reduce_count | total_price |
    | 3     | 1       | 2            | 74.70       |


