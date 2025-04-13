package com.salil.designPatterns.decorator.logistics.strategies;

import com.salil.designPatterns.decorator.logistics.Shipment;

public class DroneShippingStrategy implements ShippingStrategy {
    public double calculateBaseCost(Shipment shipment) {
        return 20 + 0.5 * shipment.getDistance();
    }
}