package com.salil.designPatterns.decorator.logistics;

import com.salil.designPatterns.decorator.logistics.strategies.ShippingStrategy;

public class ShippingService {
    private ShippingStrategy strategy;

    public ShippingService(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFinalCost(Shipment shipment) {
        return strategy.calculateBaseCost(shipment);
    }
}