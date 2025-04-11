package com.salil.designPatterns.strategy;

import com.salil.designPatterns.strategy.strategies.DeliveryTimeEstimationStrategy;
import com.salil.designPatterns.strategy.strategies.ShippingCostStrategy;

public class ShippingService {
    private ShippingCostStrategy costStrategy;
    private DeliveryTimeEstimationStrategy timeStrategy;

    public ShippingService(ShippingCostStrategy costStrategy, DeliveryTimeEstimationStrategy timeStrategy) {
        this.costStrategy = costStrategy;
        this.timeStrategy = timeStrategy;
    }

    public double calculateCost(Shipment shipment) {
        return costStrategy.calculateCost(shipment);
    }

    public int estimateDeliveryTime(Shipment shipment) {
        return timeStrategy.estimateDeliveryTime(shipment);
    }

    public void setCostStrategy(ShippingCostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

    public void setTimeStrategy(DeliveryTimeEstimationStrategy timeStrategy) {
        this.timeStrategy = timeStrategy;
    }
}