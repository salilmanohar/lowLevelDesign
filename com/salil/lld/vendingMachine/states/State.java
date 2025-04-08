package com.salil.lld.vendingMachine.states;

import com.salil.lld.vendingMachine.Coin;

public interface State {
    void insertCoin(Coin coin);
    void selectItem(String itemName);
    void dispense();
    void cancel();
}