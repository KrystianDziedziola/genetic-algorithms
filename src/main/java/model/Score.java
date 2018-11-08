package model;

import model.parameters.Item;

import java.util.List;

public class Score {

    private final double fitness;
    private final List<Item> items;

    public Score(double fitness, List<Item> items) {
        this.fitness = fitness;
        this.items = items;
    }

    public double getFitness() {
        return fitness;
    }

    public List<Item> getItems() {
        return items;
    }
}
