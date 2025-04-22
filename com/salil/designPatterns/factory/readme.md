# 🏭 Factory Design Pattern

## 🧠 Definition

> The Factory Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. It lets a class defer instantiation to subclasses.

---

## ✅ Why Use It?

- To **encapsulate object creation logic**
- When you have a **superclass/interface**, and need to decide which **subclass to instantiate** at runtime
- Avoids tight coupling between the creator and the concrete classes

---

## 💡 Key Principles from *Head First Design Patterns*

### 1. **Encapsulate what varies**
- Object creation can vary — encapsulate it using a factory.

### 2. **Program to an interface, not implementation**
- Clients use an interface and don't depend on concrete classes.

### 3. **Follows Open/Closed Principle**
- Adding new types of products requires little/no change in existing code.

---

## 🍕 Real-world Example: Pizza Store

### 🎯 Problem:
You have a pizza store with different pizza types (`CheesePizza`, `VeggiePizza`, `ClamPizza`) and styles (`New York`, `Chicago`). Creation varies based on style.

---

## 🛠️ Solution: Use Factory Method

### Factory Method Pattern

- The **factory method** is a method that returns an instance of a class.
- The base class defines the interface and a default method.
- Subclasses override the factory method to define specific behavior.

---

## 👨‍💻 Code Example (Simplified)

### 🍕 Product Interface
```java
public abstract class Pizza {
    public abstract void prepare();
    public void bake() {
        System.out.println("Baking...");
    }
    public void cut() {
        System.out.println("Cutting...");
    }
}
```

### 🍕 Concrete Products
```java
public class CheesePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing Cheese Pizza");
    }
}

public class VeggiePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing Veggie Pizza");
    }
}
```

### 🏭 Creator (Factory)
```java
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type); // Factory Method
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        return pizza;
    }

    protected abstract Pizza createPizza(String type); // Factory Method
}
```

### 🏙️ Concrete Factory
```java
public class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if (type.equals("veggie")) {
            return new VeggiePizza();
        }
        return null;
    }
}
```

### 🧪 Main
```java
public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        nyStore.orderPizza("cheese");
    }
}
```

---

## 📦 Types of Factory Patterns

| Pattern Type        | Description |
|---------------------|-------------|
| **Simple Factory**  | Not a design pattern but a common technique. Centralized creation logic. |
| **Factory Method**  | Relies on inheritance. Subclasses decide which product to create. |
| **Abstract Factory**| Creates families of related objects without specifying concrete classes. |

---

## 🎯 Use Cases

- GUI frameworks (e.g., different OS themes)
- Parsing different file formats
- Vehicle manufacturing systems
- Notification systems (email, SMS, push)

---

## ⚠️ When **Not** to Use Factory Pattern

- When object creation is simple and unlikely to change
- When performance is critical and object creation logic is trivial

---

## 📚 Summary

- Factory Method pattern **promotes loose coupling** and **flexible architecture**.
- Helps you **scale** your system with new product types **without altering existing code**.
- A core pattern in creating **extensible object-oriented designs**.
