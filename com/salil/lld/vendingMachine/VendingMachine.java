package com.salil.lld.vendingMachine;

public interface VendingMachine {
    void insertCoin(Coin coin);
    void selectItem(String itemName);
    void dispense();
    void cancel();
}