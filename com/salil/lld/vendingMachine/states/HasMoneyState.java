package com.salil.lld.vendingMachine.states;

import com.salil.lld.vendingMachine.Coin;
import com.salil.lld.vendingMachine.Item;
import com.salil.lld.vendingMachine.VendingMachineImpl;

public class HasMoneyState implements State {
    private final VendingMachineImpl machine;

    public HasMoneyState(VendingMachineImpl machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.getTransaction().addCoin(coin);
        System.out.println("Coin inserted: " + coin);
    }

    @Override
    public void selectItem(String itemName) {
        if (!machine.getInventory().isAvailable(itemName)) {
            System.out.println("Item not available.");
            return;
        }

        Item item = machine.getInventory().getItem(itemName);
        int totalInserted = machine.getTransaction().getTotalInserted();

        if (totalInserted < item.getPrice()) {
            System.out.println("Insufficient funds. Please insert more coins.");
            return;
        }

        machine.getTransaction().setSelectedItem(item);
        machine.setState(machine.getDispensingState());
        machine.dispense();
    }

    @Override
    public void dispense() {
        System.out.println("Select an item first.");
    }

    @Override
    public void cancel() {
        System.out.println("Transaction cancelled. Returning coins.");
        machine.getTransaction().reset();
        machine.setState(machine.getIdleState());
    }
}