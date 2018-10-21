package model.parameters;

import java.util.List;

public class Parameters {

    private final int numberOfItems;
    private final List<Item> items;
    private final int knapsackCapacity;
    private final int populationSize;
    private final int maximumGenerations;
    private final double crossoverProbability;
    private final double mutationProbability;

    public Parameters(int numberOfItems, List<Item> items, int knapsackCapacity, int populationSize, int maximumGenerations, double crossoverProbability, double mutationProbability) {
        this.numberOfItems = numberOfItems;
        this.items = items;
        this.knapsackCapacity = knapsackCapacity;
        this.populationSize = populationSize;
        this.maximumGenerations = maximumGenerations;
        this.crossoverProbability = crossoverProbability;
        this.mutationProbability = mutationProbability;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getMaximumGenerations() {
        return maximumGenerations;
    }

    public double getCrossoverProbability() {
        return crossoverProbability;
    }

    public double getMutationProbability() {
        return mutationProbability;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "numberOfItems=" + numberOfItems +
                ", items=" + items +
                ", knapsackCapacity=" + knapsackCapacity +
                ", populationSize=" + populationSize +
                ", maximumGenerations=" + maximumGenerations +
                ", crossoverProbability=" + crossoverProbability +
                ", mutationProbability=" + mutationProbability +
                '}';
    }
}
