import model.Population;
import model.Score;
import model.parameters.Item;
import model.parameters.Parameters;

import java.util.Arrays;
import java.util.List;

public class KnapsackApplication {

    public static void main(final String[] args) {
        final Parameters parameters = createParameters();
        final int populationSize = parameters.getPopulationSize();
        final List<Item> items = parameters.getItems();
        final int knapsackCapacity = parameters.getKnapsackCapacity();

        final Population population = new Population(populationSize, items.size());
        final Score populationFitness = population.evaluate(items, knapsackCapacity);

        System.out.println(parameters);
    }

    private static Parameters createParameters() {
        final List<Item> createdItems = createItems();
        return new Parameters(createdItems, 10, createdItems.size(), 0, 0, 0);
    }

    private static List<Item> createItems() {
        return Arrays.asList(
                new Item(10, 5),
                new Item(8, 9),
                new Item(3, 1),
                new Item(3, 1),
                new Item(20, 1));
    }
}
