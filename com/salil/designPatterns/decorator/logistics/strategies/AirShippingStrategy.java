package com.salil.designPatterns.decorator.logistics.strategies;

import com.salil.designPatterns.decorator.logistics.Shipment;

public class AirShippingStrategy implements ShippingStrategy {
    public double calculateBaseCost(Shipment shipment) {
        return 10 + 0.2 * shipment.getDistance();
    }
}