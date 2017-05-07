package com.amaysim.rule;

import com.amaysim.CartItem;
import com.amaysim.Item;

/**
 * Created by aiam on 5/6/2017.
 */
public class EachCountPromoRuleEngine extends AbstractRuleEngine {
    public int eachOrderItemCount;
    public int promoEachOrderItemCount;

    public EachCountPromoRuleEngine(String ruleName, Item item, int eachOrderItemCount, int promoEachOrderItemCount) {
        this.ruleName = ruleName;
        this.item = item;
        this.eachOrderItemCount = eachOrderItemCount;
        this.promoEachOrderItemCount = promoEachOrderItemCount;
    }

    @Override
    public CartItem processCartItems(CartItem item) {
        CartItem promo = new CartItem();
        promo.item = item.item;
        if (item.count >= this.eachOrderItemCount) {
            promo.count = this.promoEachOrderItemCount;
        }
        else {
            promo.count = item.count;
        }
        return promo;
    }
}
