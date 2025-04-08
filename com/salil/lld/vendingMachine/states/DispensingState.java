package com.salil.lld.vendingMachine.states;

import com.salil.lld.vendingMachine.Coin;
import com.salil.lld.vendingMachine.Item;
import com.salil.lld.vendingMachine.Transaction;
import com.salil.lld.vendingMachine.VendingMachineImpl;

import java.util.Map;

public class DispensingState implements State {
    private final VendingMachineImpl machine;

    public DispensingState(VendingMachineImpl machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please wait, dispensing item.");
    }

    @Override
    public void selectItem(String itemName) {
        System.out.println("Already dispensing an item.");
    }

    @Override
    public void dispense() {
        Transaction tx = machine.getTransaction();
        Item item = tx.getSelectedItem();

        if (item == null) {
            System.out.println("No item selected.");
            return;
        }

        int totalInserted = tx.getTotalInserted();
        int price = item.getPrice();
        int change = totalInserted - price;

        try {
            Map<Coin, Integer> changeCoins = machine.getChange(change);
            System.out.println("Dispensing: " + item.getName());
            if (!changeCoins.isEmpty()) {
                System.out.println("Change returned: " + changeCoins);
            }

            for (Coin coin : tx.getInsertedCoins()) {
                machine.addCoinToInventory(coin, 1);
            }

            machine.getInventory().reduceItem(item.getName());
            tx.reset();
            machine.setState(machine.getIdleState());

        } catch (Exception e) {
            System.out.println("Unable to dispense change: " + e.getMessage());
            System.out.println("Transaction cancelled. Returning inserted coins.");
            tx.reset();
            machine.setState(machine.getIdleState());
        }
    }

    @Override
    public void cancel() {
        System.out.println("Cannot cancel, item is being dispensed.");
    }
}
