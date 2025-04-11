package com.salil.designPatterns.strategy.strategies;

import com.salil.designPatterns.strategy.Shipment;

public interface ShippingCostStrategy {
    double calculateCost(Shipment shipment);
}
