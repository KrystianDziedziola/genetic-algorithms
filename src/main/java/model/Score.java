package model;

import model.parameters.Item;

import java.util.List;

public class Score {

    private final double fitness;
    private final List<Item> items;
    private final Gene gene;

    Score(double fitness, List<Item> items, Gene gene) {
        this.fitness = fitness;
        this.items = items;
        this.gene = gene;
    }

    double getFitness() {
        return fitness;
    }

    Gene getGene() {
        return gene;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Score{" +
                "fitness=" + fitness +
                ", items=" + items +
                ", gene=" + gene +
                '}';
    }
}
