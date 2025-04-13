package com.salil.designPatterns.decorator.logistics.decorator;

import com.salil.designPatterns.decorator.logistics.strategies.ShippingStrategy;

public abstract class ShippingDecorator implements ShippingStrategy {
    protected ShippingStrategy strategy;
    public ShippingDecorator(ShippingStrategy strategy) {
        this.strategy = strategy;
    }
}