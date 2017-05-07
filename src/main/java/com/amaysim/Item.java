package com.amaysim;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by aiam on 5/6/2017.
 */
public class Item {
    public String code;
    public String description;
    public double amount;
    public double promoAmount;

    static Map<String, Item> itemMap = new HashMap();

    public static Item findItem(String code) {
        return itemMap.get(code);
    }

    public static Item getItem(String code, String description, double amount) {
        Item i = itemMap.get(code);
        if (i == null) {
            i = new Item(code, description, amount);
            itemMap.put(code, i);
        }
        return i;
    }

    private Item(String code, String description, double amount) {
        this.code = code;
        this.description = description;
        this.amount = amount;
        this.promoAmount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        return code.equals(item.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    public static void initializeAll() {
//        Items promo amount initialize
        System.out.println("Items Initialize");
        Set<String> keys = itemMap.keySet();
        for (String s:keys) {
            Item i = itemMap.get(s);
            i.promoAmount = i.amount;
        }
    }
}
