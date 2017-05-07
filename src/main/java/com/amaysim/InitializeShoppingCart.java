package com.amaysim;

import com.amaysim.rule.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aiam on 5/6/2017.
 */
public class InitializeShoppingCart {
    ShoppingCart shop;

    public ShoppingCart getShop() {
        return shop;
    }

    public InitializeShoppingCart() {
        List<AbstractRuleEngine> rules = new ArrayList();
        rules.add(new EachCountPromoRuleEngine("3 for 2 Unlimited 1GB Sims", Constants.itemSmall, 3, 2));
        rules.add(new BulkDiscountPromoRuleEngine("Bulk Unlimited 5GB", Constants.itemLarge, 3, 39.9));
        rules.add(new BundleChargePromoRuleEngine("Bundle Free 1GB Data", Constants.itemMedium, Constants.item1GB));
        rules.add(new PromoCodeAcrossRuleEngine("I<3AMAYSIM", 10));

        shop = ShoppingCart.newCart(rules);
        Item.initializeAll();
    }

    public void buyItem(Item item, int count) {
        shop.add(item, count);
    }

    public void applyDiscount(String discount) {
        shop.add(null, 0, discount);
    }
}
