package com.salil.designPatterns.strategy.strategies;

import com.salil.designPatterns.strategy.Shipment;

public class FastDeliveryTimeStrategy implements DeliveryTimeEstimationStrategy {
    @Override
    public int estimateDeliveryTime(Shipment shipment) {
        return 1;
    }
}