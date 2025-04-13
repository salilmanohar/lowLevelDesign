package com.salil.designPatterns.decorator.logistics;

import com.salil.designPatterns.decorator.logistics.decorator.FragileItemHandlingDecorator;
import com.salil.designPatterns.decorator.logistics.decorator.InsuranceDecorator;
import com.salil.designPatterns.decorator.logistics.decorator.WeekendDeliveryDecorator;
import com.salil.designPatterns.decorator.logistics.strategies.GroundShippingStrategy;
import com.salil.designPatterns.decorator.logistics.strategies.ShippingStrategy;

public class AdvancedShippingApp {
    public static void main(String[] args) {
        Shipment shipment = new Shipment(10, 120, 300);


        ShippingStrategy base = new GroundShippingStrategy();


        ShippingStrategy fullStrategy = new InsuranceDecorator(
                                            new WeekendDeliveryDecorator(
                                                new FragileItemHandlingDecorator(base)));


        ShippingService service = new ShippingService(fullStrategy);

        System.out.println("Total shipping cost: $" + service.calculateFinalCost(shipment));
    }
}