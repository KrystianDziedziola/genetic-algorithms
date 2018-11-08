package model;

public class Chromosome {

    private final int value;

    private Chromosome(int value) {
        this.value = value;
    }

    public static Chromosome random() {
        if (Math.random() < 0.5) {
            return new Chromosome(1);
        }

        return new Chromosome(0);
    }

    public boolean isPositive() {
        return value == 1;
    }
}
