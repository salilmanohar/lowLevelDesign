package com.salil.lld.vendingMachine.states;

import com.salil.lld.vendingMachine.Coin;
import com.salil.lld.vendingMachine.VendingMachineImpl;

public class IdleState implements State {
    private final VendingMachineImpl machine;

    public IdleState(VendingMachineImpl machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.getTransaction().addCoin(coin);
        System.out.println("Coin inserted: " + coin);
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void selectItem(String itemName) {
        System.out.println("Insert coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("Insert coin and select item first.");
    }

    @Override
    public void cancel() {
        System.out.println("Nothing to cancel.");
    }
}