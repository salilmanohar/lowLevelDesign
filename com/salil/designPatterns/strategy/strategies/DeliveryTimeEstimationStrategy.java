package com.salil.designPatterns.strategy.strategies;

import com.salil.designPatterns.strategy.Shipment;

public interface DeliveryTimeEstimationStrategy {
    int estimateDeliveryTime(Shipment shipment);
}