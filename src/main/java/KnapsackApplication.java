import model.Population;
import model.parameters.Item;

import java.util.Arrays;
import java.util.List;

public class KnapsackApplication {

    public static void main(final String[] args) {
        final List<Item> items = createItems();
        final int populationSize = items.size();
        final int knapsackCapacity = 35;
        final int maximumGenerations = 10;
        final double crossoverProbability = 0.3;
        final double mutationProbability = 0.1;

        Population population = new Population(populationSize, items.size());
        logScore(population, 0, items, knapsackCapacity);

        for (int generation = 1; generation <= maximumGenerations; generation++) {
            population = Population.createFromPrevious(population,
                                                       items,
                                                       knapsackCapacity,
                                                       crossoverProbability,
                                                       mutationProbability);

            logScore(population, generation, items, knapsackCapacity);
        }
    }

    private static void logScore(final Population population, final int generation, final List<Item> items, final int knapsackCapacity) {
        System.out.format("%d. generation score: %s\n", generation, population.evaluateAndGetBest(items, knapsackCapacity));
    }

    private static List<Item> createItems() {
        return Arrays.asList(
                new Item(5, 5),
                new Item(8, 9),
                new Item(3, 2),
                new Item(3, 3),
                new Item(1, 1),
                new Item(20, 5),
                new Item(13, 18),
                new Item(20, 20),
                new Item(2, 1));
    }
}
