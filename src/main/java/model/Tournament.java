package model;

import model.parameters.Item;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class Tournament {

    private static final int TOURNAMENT_SIZE = 3;

    private final List<Gene> genes;
    private final List<Item> items;
    private final int knapsackCapacity;

    Tournament(List<Gene> genes, List<Item> items, int knapsackCapacity) {
        this.genes = genes;
        this.items = items;
        this.knapsackCapacity = knapsackCapacity;
    }

    Gene select() {
        final Population tournament = Population.empty();

        IntStream
                .range(0, TOURNAMENT_SIZE)
                .forEach(gene -> {
                    final Gene randomGene = getRandomGene(genes);
                    tournament.addGene(randomGene);
                });

        return tournament
                .evaluateAndGetBest(items, knapsackCapacity)
                .getGene();
    }

    private static Gene getRandomGene(final List<Gene> genes) {
        return genes.get(new Random().nextInt(genes.size()));
    }
}
