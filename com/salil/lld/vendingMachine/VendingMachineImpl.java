package com.salil.lld.vendingMachine;

import com.salil.lld.vendingMachine.states.DispensingState;
import com.salil.lld.vendingMachine.states.HasMoneyState;
import com.salil.lld.vendingMachine.states.IdleState;
import com.salil.lld.vendingMachine.states.State;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
    private final Inventory inventory = new Inventory();
    private final Transaction transaction = new Transaction();
    private final Map<Coin, Integer> coinInventory = new HashMap<>();

    private final State idleState;
    private final State hasMoneyState;
    private final State dispensingState;

    private State currentState;

    public VendingMachineImpl() {
        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState;

        for (Coin coin : Coin.values()) {
            coinInventory.put(coin, 10);
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    @Override
    public void selectItem(String itemName) {
        currentState.selectItem(itemName);
    }

    @Override
    public void dispense() {
        currentState.dispense();
    }

    @Override
    public void cancel() {
        currentState.cancel();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getDispensingState() {
        return dispensingState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Map<Coin, Integer> getCoinInventory() {
        return coinInventory;
    }

    public void addCoinToInventory(Coin coin, int count) {
        coinInventory.put(coin, coinInventory.getOrDefault(coin, 0) + count);
    }

    public Map<Coin, Integer> getChange(int amount) throws Exception {
        if (amount == 0) return Collections.emptyMap();

        Map<Coin, Integer> changeMap = new HashMap<>();
        int remaining = amount;
        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a, b) -> b.getValue() - a.getValue());

        for (Coin coin : coins) {
            int coinValue = coin.getValue();
            int coinCount = coinInventory.getOrDefault(coin, 0);

            if (coinValue <= remaining && coinCount > 0) {
                int needed = remaining / coinValue;
                int toUse = Math.min(needed, coinCount);
                if (toUse > 0) {
                    changeMap.put(coin, toUse);
                    remaining -= toUse * coinValue;
                }
            }
        }

        if (remaining != 0) {
            throw new Exception("Not enough change available");
        }

        for (Map.Entry<Coin, Integer> entry : changeMap.entrySet()) {
            coinInventory.put(entry.getKey(), coinInventory.get(entry.getKey()) - entry.getValue());
        }

        return changeMap;
    }
}