# Strategy Pattern: Shipping System

This project demonstrates the use of the Strategy Design Pattern using a shipping example. It includes two distinct sets of strategies:

- Shipping Cost Strategies
- Delivery Time Estimation Strategies

## 🧠 What is the Strategy Pattern?

The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.

### 📘 Key Concepts:
- Favor composition over inheritance
- Encapsulate what varies
- Program to an interface, not an implementation
- Helps in adhering to Open/Closed Principle

## 🚚 Shipping Example

### Domain Class
- `Shipment`: Represents the package with weight, distance, and value.

### Strategy Interfaces
- `ShippingCostStrategy`: For calculating shipping costs.
- `DeliveryTimeEstimationStrategy`: For estimating delivery time.

### Concrete Strategies
**Shipping Cost:**
- `StandardShippingStrategy`
- `ExpressShippingStrategy`
- `SameDayShippingStrategy`

**Delivery Time:**
- `FastDeliveryTimeStrategy`
- `NormalDeliveryTimeStrategy`
- `SlowDeliveryTimeStrategy`

### Context Class
- `ShippingService`: Accepts both strategy types to calculate cost and time.

## 🧪 Sample Usage (Main.java)
```java
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
```

## ✅ Benefits of Using Strategy Pattern
- Clean separation of concerns
- Easy to add new algorithms without modifying existing code
- Promotes reusability and flexibility