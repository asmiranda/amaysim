package com.amaysim.steps;

import com.amaysim.CartItem;
import com.amaysim.Constants;
import com.amaysim.InitializeShoppingCart;
import com.amaysim.ShoppingCart;
import com.amaysim.util.Util;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShoppingSteps {
    InitializeShoppingCart cart;

    @Before("@ShoppingCart")
    public void initializeCart() {
        cart = new InitializeShoppingCart();
    }

    @Given("^customer logged in")
    public void customerLoggedIn() throws Throwable {
        assertNotNull(cart);
    }

    @When("^customer bought (\\d+) Unlimited 1GB Sims and bought another (\\d+)$")
    public void customerBoughtAnother_1GBSims(int count, int another) throws Throwable {
        cart.buyItem(Constants.itemSmall, count);
        cart.buyItem(Constants.itemSmall, another);
    }

    @Then("^the customer will pay only (\\d+) Unlimited 1GB Sims with only (\\d+)\\.(\\d+) total price$")
    public void getPromoItemsAndAmount(int reduce, int total_price, int total_price_cents) throws Throwable {
        double total = Util.round(cart.getShop().total(), 2);
        double testTotal = Util.round(total_price + total_price_cents/100d, 2);
        assertEquals(testTotal, total, 0);
    }

    @When("^customer bought (\\d+) Unlimited 5GB Sims$")
    public void buy5GBSim(int count) throws Throwable {
        cart.buyItem(Constants.itemLarge, count);
    }

    @Then("^the customer will pay only (\\d+)\\.(\\d+) for total price$")
    public void payForBulk5GB(int total_price, int total_price_cents) throws Throwable {
        double total = Util.round(cart.getShop().total(), 2);
        double testTotal = Util.round(total_price + total_price_cents/100d, 2);
        assertEquals(testTotal, total, 0);
    }

    @When("^customer bought (\\d+) Unlimited 2GB Sims$")
    public void buy2GBSim(int count) throws Throwable {
        cart.buyItem(Constants.itemMedium, count);
    }

    @Then("^the customer will have free (\\d+) (\\d+)gb$")
    public void freeBundle(int freeItemCount, String freeItem) throws Throwable {
        List<CartItem> items = cart.getShop().freeItem();
        for (CartItem item:items) {
            if (freeItem.equals(item.item.code)) {
                assertEquals(item.count, freeItemCount, 0);
            }
        }
    }

    @When("^customer apply the promo code ([^\"]+)")
    public void applyAccrossPromoCode(String promo) throws Throwable {
        cart.applyDiscount(promo);
    }

    @When("^customer bought (\\d+) Unlimited 1GB Sims$")
    public void customerBought1GBSims(int count) throws Throwable {
        cart.buyItem(Constants.itemSmall, count);
    }

    @When("^customer bought (\\d+) 1 GB Data-pack$")
    public void customer_bought_count__gb_data(int count) throws Throwable {
        cart.buyItem(Constants.item1GB, count);
    }
}
