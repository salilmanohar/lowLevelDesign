package com.salil.lld.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<Coin> insertedCoins = new ArrayList<>();
    private Item selectedItem;

    public void addCoin(Coin coin) {
        insertedCoins.add(coin);
    }

    public int getTotalInserted() {
        return insertedCoins.stream().mapToInt(Coin::getValue).sum();
    }

    public void setSelectedItem(Item item) {
        this.selectedItem = item;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public List<Coin> getInsertedCoins() {
        return insertedCoins;
    }

    public void reset() {
        insertedCoins.clear();
        selectedItem = null;
    }
}
