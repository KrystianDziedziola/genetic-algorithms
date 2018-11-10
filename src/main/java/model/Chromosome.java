package model;

class Chromosome {

    private final int value;

    private Chromosome(int value) {
        this.value = value;
    }

    static Chromosome random() {
        if (Math.random() < 0.5) {
            return new Chromosome(1);
        }

        return new Chromosome(0);
    }

    Chromosome invert() {
        if (value == 0) {
            return new Chromosome(1);
        } else {
            return new Chromosome(0);
        }
    }

    boolean isPositive() {
        return value == 1;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
