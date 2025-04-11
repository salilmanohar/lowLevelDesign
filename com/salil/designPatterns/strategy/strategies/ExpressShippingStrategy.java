package com.salil.designPatterns.strategy.strategies;

import com.salil.designPatterns.strategy.Shipment;

public class ExpressShippingStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(Shipment shipment) {
        return 10 + 0.2 * shipment.getDistance();
    }
}