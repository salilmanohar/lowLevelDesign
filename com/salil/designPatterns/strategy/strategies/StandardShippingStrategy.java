package com.salil.designPatterns.strategy.strategies;

import com.salil.designPatterns.strategy.Shipment;

public class StandardShippingStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(Shipment shipment) {
        return 5 + 0.1 * shipment.getDistance();
    }
}