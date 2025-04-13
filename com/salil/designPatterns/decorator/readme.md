# ☕ Decorator Pattern

## 🧠 Definition

> The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

---

## 🧩 Key Concepts

### 1. **Composition over Inheritance**

- Instead of extending behavior through inheritance, you *compose* objects using decorators.

### 2. **Wrapper Objects**

- Decorators are wrapper objects that contain a reference to the object they decorate and add their own behavior before/after delegating to the wrapped object.

### 3. **Open/Closed Principle**

- Classes should be open for extension but closed for modification.
- Decorators allow adding behavior without changing existing code.

### 4. **Inheritance for Type Matching, Not Behavior**

- In the Decorator pattern, we use inheritance not to reuse behavior but to ensure **type compatibility**.
- For example, a `Mocha` decorator extends `Beverage` so it can be used anywhere a `Beverage` is expected.
- This allows decorators and components to be interchangeable.
- Actual behavior is extended via **composition**, not inheritance.

---

## 🍫 Example: **Starbuzz Coffee**

### Problem:

- A beverage shop sells drinks with optional condiments (milk, soy, mocha, whip).
- The price of the drink varies based on size and added condiments.

### Naive approach:

- Use inheritance to create subclasses like `HouseBlendWithSoyAndMochaAndWhip`
- Quickly becomes unmanageable with every combination.

---

## ✅ Decorator-based Solution

### Base Component

```java
public abstract class Beverage {
    String description = "Unknown Beverage";
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
```

### Concrete Component

```java
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }
    public double cost() {
        return 0.89;
    }
}
```

### Decorator Abstract Class

```java
public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
```

### Concrete Decorators

```java
public class Mocha extends CondimentDecorator {
    Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
```

### Usage

```java
Beverage beverage = new HouseBlend();
beverage = new Mocha(beverage);
beverage = new Whip(beverage);

System.out.println(beverage.getDescription() + " $" + beverage.cost());
```

---

## 💡 Design Principles Reinforced

- **Open/Closed Principle** – Add new functionality via decorators without modifying existing code.
- **Single Responsibility Principle** – Keep core components focused; decorators handle optional behavior.
- **Use inheritance for type compatibility**, not for sharing behavior.

---

## 🔍 Things to Watch Out For

- Decorators and components must share the same interface/type.
- A single object can be wrapped in multiple decorators.
- Debugging can become complex due to multiple layers of wrapping.

---

## 📦 Common Use Cases

- Java I/O Streams (`BufferedInputStream`, `DataInputStream`, etc.)
- UI Components (adding scrollbars, borders, etc.)
- Logging (adding prefixes, timestamps)
- Data compression/encryption

