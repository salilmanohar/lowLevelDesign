package com.salil.lld.vendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachineImpl vm = new VendingMachineImpl();

        vm.getInventory().addItem(new Item("Coke", 100), 5);
        vm.getInventory().addItem(new Item("Pepsi", 85), 3);
        vm.getInventory().addItem(new Item("Soda", 60), 2);

        System.out.println("--- Test 1: Buying Coke ---");
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.selectItem("Coke");

        System.out.println("\n--- Test 2: Insufficient funds ---");
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        vm.selectItem("Pepsi");

        System.out.println("\n--- Test 3: Cancel transaction ---");
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.cancel();

        System.out.println("\n--- Test 4: Buy Soda with extra coins ---");
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.selectItem("Soda");
    }
}