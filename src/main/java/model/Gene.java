package model;

import model.parameters.Item;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Gene {

    private static final int MINIMUM_FITNESS = 0;

    private final List<Chromosome> chromosomes;

    Gene(final int size) {
        this.chromosomes = new ArrayList<>();

        for (int chromosome = 0; chromosome < size; chromosome++) {
            this.chromosomes.add(Chromosome.random());
        }
    }

    private Gene(final List<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    Score evaluate(final List<Item> items, int knapsackCapacity, Gene gene) {
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
        return new Score(fitness, activeItems, gene);
    }

    Gene crossWith(final Gene gene, double crossoverProbability) {
        final double randomProbability = new Random().nextDouble();
        if (crossoverProbability < randomProbability) {
            return this;
        }

        final int size = this.chromosomes.size();
        final int boundary = size / 2;
        final List<Chromosome> firstPart = this.chromosomes.subList(0, boundary);
        final List<Chromosome> secondPart = gene.chromosomes.subList(boundary, size);

        final List<Chromosome> crossedChromosomes = ListUtils.union(firstPart, secondPart);
        return new Gene(crossedChromosomes);
    }

    private double createFitness(double totalWeight, double totalValue, int knapsackCapacity) {
        if (totalWeight > knapsackCapacity) {
            return MINIMUM_FITNESS;
        }

        return totalValue;
    }

    Gene mutate(final double mutationProbability) {
        final List<Chromosome> newChromosomes = new ArrayList<>();

        for (Chromosome chromosome : this.chromosomes) {
            final double randomProbability = new Random().nextDouble();
            if (mutationProbability > randomProbability) {
                chromosome = chromosome.invert();
            }
            newChromosomes.add(chromosome);
        }
        return new Gene(newChromosomes);
    }

    @Override
    public String toString() {
        return "Gene{" +
                "chromosomes=" + chromosomes +
                '}';
    }
}
