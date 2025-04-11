package com.salil.designPatterns.strategy.strategies;

import com.salil.designPatterns.strategy.Shipment;

public class NormalDeliveryTimeStrategy implements DeliveryTimeEstimationStrategy {
    @Override
    public int estimateDeliveryTime(Shipment shipment) {
        return 3;
    }
}