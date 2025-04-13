package com.salil.designPatterns.decorator.logistics.strategies;

import com.salil.designPatterns.decorator.logistics.Shipment;

public class GroundShippingStrategy implements ShippingStrategy {
    public double calculateBaseCost(Shipment shipment) {
        return 5 + 0.1 * shipment.getDistance();
    }
}