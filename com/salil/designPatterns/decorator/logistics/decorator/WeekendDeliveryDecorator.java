package com.salil.designPatterns.decorator.logistics.decorator;

import com.salil.designPatterns.decorator.logistics.Shipment;
import com.salil.designPatterns.decorator.logistics.strategies.ShippingStrategy;

public class WeekendDeliveryDecorator extends ShippingDecorator {
    public WeekendDeliveryDecorator(ShippingStrategy strategy) {
        super(strategy);
    }
    public double calculateBaseCost(Shipment shipment) {
        return strategy.calculateBaseCost(shipment) + 10;
    }
}