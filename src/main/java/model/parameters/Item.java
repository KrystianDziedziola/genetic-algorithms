package model.parameters;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {

    private static final AtomicInteger counter = new AtomicInteger();

    private final int id;
    private final double value;
    private final double weight;

    public Item(double value, double weight) {
        this.id = counter.incrementAndGet();
        this.value = value;
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", value=" + value +
                ", weight=" + weight +
                '}';
    }
}
