package com.salil.designPatterns.decorator.logistics.decorator;

import com.salil.designPatterns.decorator.logistics.Shipment;
import com.salil.designPatterns.decorator.logistics.strategies.ShippingStrategy;

public class FragileItemHandlingDecorator extends ShippingDecorator {
    public FragileItemHandlingDecorator(ShippingStrategy strategy) {
        super(strategy);
    }
    public double calculateBaseCost(Shipment shipment) {
        return strategy.calculateBaseCost(shipment) + 8;
    }
}