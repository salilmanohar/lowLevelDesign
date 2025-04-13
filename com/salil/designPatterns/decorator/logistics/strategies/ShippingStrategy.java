package com.salil.designPatterns.decorator.logistics.strategies;

import com.salil.designPatterns.decorator.logistics.Shipment;

public interface ShippingStrategy {
    double calculateBaseCost(Shipment shipment);
}