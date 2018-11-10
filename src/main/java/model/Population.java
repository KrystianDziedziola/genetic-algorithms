package model;

import model.parameters.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Population {

    private final List<Gene> genes = new ArrayList<>();

    public Population(final int populationSize, final int geneSize) {
        IntStream.range(0, populationSize)
                 .forEach(geneNumber -> genes.add(new Gene(geneSize)));
    }

    private Population() {
    }

    static Population empty() {
        return new Population();
    }

    public static Population createFromPrevious(
            final Population previousPopulation,
            final List<Item> items,
            final int knapsackCapacity,
            final double crossoverProbability,
            final double mutationProbability) {
        final Population newPopulation = new Population();

        final Tournament tournament = new Tournament(previousPopulation.genes, items, knapsackCapacity);
        previousPopulation.genes.forEach(score -> {
            final Gene firstGene = tournament.select();
            final Gene secondGene = tournament.select();
            final Gene crossedGene = firstGene.crossWith(secondGene, crossoverProbability);
            final Gene mutatedGene = crossedGene.mutate(mutationProbability);

            newPopulation.addGene(mutatedGene);
        });

        return newPopulation;
    }


    public Score evaluateAndGetBest(final List<Item> items, int knapsackCapacity) {
        return evaluate(items, knapsackCapacity)
                .stream()
                .max(Comparator.comparing(Score::getFitness))
                .orElseThrow(() -> new RuntimeException("Score not found"));
    }

    private List<Score> evaluate(final List<Item> items, int knapsackCapacity) {
        return genes
                .stream()
                .map(gene -> gene.evaluate(items, knapsackCapacity, gene))
                .collect(Collectors.toList());
    }

    void addGene(final Gene gene) {
        genes.add(gene);
    }
}
