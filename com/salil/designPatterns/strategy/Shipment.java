package com.salil.designPatterns.strategy;

public class Shipment {
    private double weight;
    private double distance;
    private double value;

    public Shipment(double weight, double distance, double value) {
        this.weight = weight;
        this.distance = distance;
        this.value = value;
    }

    public double getWeight() { return weight; }
    public double getDistance() { return distance; }
    public double getValue() { return value; }
}
