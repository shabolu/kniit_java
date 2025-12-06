package solutions.lab5.task8;

import java.util.Objects;

public class ShopItem {
    private String name;
    private double price;
    private int quantity;

    public ShopItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("ShopItem{name='%s', price=%.2f, qty=%d}", name, price, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;

        return Double.compare(shopItem.price, price) == 0 &&
                quantity == shopItem.quantity &&
                Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}