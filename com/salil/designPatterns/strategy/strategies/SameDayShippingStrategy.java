package com.salil.designPatterns.strategy.strategies;

import com.salil.designPatterns.strategy.Shipment;

public class SameDayShippingStrategy implements ShippingCostStrategy {
    @Override
    public double calculateCost(Shipment shipment) {
        return 20 + 0.5 * shipment.getDistance();
    }
}