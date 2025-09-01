# Shopping Cart System (Java + JUnit) 🛒

A small, test-driven **Shopping Cart** implementation in Java that demonstrates clean OOP design and unit testing with **JUnit 5**.

---

## 📌 Problem Statement

**Objective:** Build a simple shopping cart that lets users **add**, **remove**, **view** items and **calculate total price**.

**Requirements**

* **Item**: each item has an **ID**, **name**, and **price**; expose getters and a readable `toString()`.
* **Shopping Cart**: add items, remove items by id, view items, and compute the cart total.
* **Tests**: cover valid/invalid item creation, getters, add/remove/view, and total calculation.
* **Constraints**: Use **Java** and **JUnit**. Follow **TDD** (write failing tests → implement → refactor).

---

## 🧱 Project Structure

```
src/
├─ main/
│  └─ java/
│     └─ com/cart/
│        ├─ Item.java
│        └─ ShoppingCart.java
└─ test/
   └─ java/
      └─ com/cart/
         ├─ ItemTest.java
         └─ ShoppingCartTest.java
```

> Packages use `com.cart`. Tests use **JUnit 5**.

---

## ✨ Features

* **Add items** to the cart
* **Remove items** by ID (throws error if not found)
* **View items** without exposing internal list (returns a **defensive copy**)
* **Calculate total** price of all items
* **Input validation** in `Item` (id > 0, name not null, price > 0)

---

## 🧩 Core Classes

### `Item`

```java
public class Item {
    private int id;
    private String name;
    private double price;
    // validation in ctor, getters, toString()
}
```

**Key behavior**

* Throws `IllegalArgumentException("Invalid input!!")` when `id <= 0`, `name == null`, or `price <= 0`.
* `displayItem()` → `Item [id=ID, name=NAME, price=PRICE]`.

### `ShoppingCart`

```java
public class ShoppingCart {
    private List<Item> list = new LinkedList<>();
    public void addItem(Item item) { /* ... */ }
    public void removeItem(int id) { /* ... */ }
    public List<Item> viewCart() { /* returns copy */ }
    public double calculateTotalAmount() { /* sums & clears */ }
}
```

**Key behavior**

* `removeItem` throws `IllegalArgumentException("Item not found!!!")` if the id does not exist.
* `viewCart` returns a **new `ArrayList`** to prevent external modification.
* `calculateTotalAmount` **empties** the cart after summing (acts like checkout).

---

## ✅ Tests (JUnit 5)

### `ItemTest`

* **Valid item** creation and getters
* **Invalid item** throws with message `"Invalid input!!"`
* `displayItem()` format check

### `ShoppingCartTest`

* **Add items** and verify total
* **Remove item** by id and verify remaining total
* **Remove non-existent** item throws with `"Item not found!!!"`
* **Empty cart total** is `0.0`

---

## ▶️ Getting Started

### Prerequisites

* **Java 17+** (or 11+ if your toolchain is set accordingly)
* **JUnit 5** (already referenced in tests)
* Any IDE (IntelliJ / Eclipse / VS Code) or **Maven/Gradle**

### Run in an IDE (easiest)

1. Import the project as a **Java project**.
2. Right‑click `test/java/com/cart` → **Run Tests**.

### Run with Maven (if you have a `pom.xml`)

```bash
mvn test
```

### Run with Gradle (if you have a `build.gradle`)

```bash
gradle test
# or
./gradlew test
```

> If you don't use a build tool yet, create a small **runner** class to manually try the API (see below), and run tests from your IDE.

---

## 🧪 Quick Manual Run (Sample)

```java
public class Demo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item(1, "Book", 200.0));
        cart.addItem(new Item(2, "Pen", 20.0));
        System.out.println("Cart items: " + cart.viewCart());
        System.out.println("Total: " + cart.calculateTotalAmount()); // 220.0
        System.out.println("Cart after checkout: " + cart.viewCart()); // []
    }
}
```

---

## 🧠 Design Notes

* **TDD**: tests were written to captu
