package com.salil.designPatterns.strategy;

import com.salil.designPatterns.strategy.strategies.ExpressShippingStrategy;
import com.salil.designPatterns.strategy.strategies.FastDeliveryTimeStrategy;
import com.salil.designPatterns.strategy.strategies.NormalDeliveryTimeStrategy;

public class Main {
    public static void main(String[] args) {
        Shipment shipment = new Shipment(10, 150, 2000);

        ShippingService service = new ShippingService(
            new ExpressShippingStrategy(),
            new NormalDeliveryTimeStrategy()
        );

        System.out.println("Cost: $" + service.calculateCost(shipment));
        System.out.println("Estimated delivery time: " + service.estimateDeliveryTime(shipment) + " days");

        // Switch strategy
        service.setTimeStrategy(new FastDeliveryTimeStrategy());
        System.out.println("New estimated delivery time: " + service.estimateDeliveryTime(shipment) + " days");
    }
}