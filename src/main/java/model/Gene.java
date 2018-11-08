package model;

import model.parameters.Item;

import java.util.ArrayList;
import java.util.List;

class Gene {

    private static final int MINIMUM_FITNESS = 0;

    private final List<Chromosome> chromosomes = new ArrayList<>();

    Gene(final int size) {
        for (int chromosome = 0; chromosome < size; chromosome++) {
            chromosomes.add(Chromosome.random());
        }
    }

    Score evaluate(final List<Item> items, int knapsackCapacity) {
        double totalWeight = 0;
        double totalValue = 0;

        final List<Item> activeItems = new ArrayList<>();
        for (int chromosomeNumber = 0; chromosomeNumber < chromosomes.size(); chromosomeNumber++) {
            if (chromosomes.get(chromosomeNumber).isPositive()) {
                final Item item = items.get(chromosomeNumber);
                activeItems.add(item);
                totalWeight += item.getWeight();
                totalValue += item.getValue();
            }
        }

        final double fitness = createFitness(totalWeight, totalValue, knapsackCapacity);
        return new Score(fitness, activeItems);
    }

    private double createFitness(double totalWeight, double totalValue, int knapsackCapacity) {
        if (totalWeight > knapsackCapacity) {
            return MINIMUM_FITNESS;
        }

        return totalValue;
    }
}
