package com.salil.lld.vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Item> items = new HashMap<>();
    private final Map<String, Integer> itemCounts = new HashMap<>();

    public void addItem(Item item, int quantity) {
        items.put(item.getName(), item);
        itemCounts.put(item.getName(), itemCounts.getOrDefault(item.getName(), 0) + quantity);
    }

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    public boolean isAvailable(String itemName) {
        return itemCounts.getOrDefault(itemName, 0) > 0;
    }

    public void reduceItem(String itemName) {
        itemCounts.put(itemName, itemCounts.get(itemName) - 1);
    }
}