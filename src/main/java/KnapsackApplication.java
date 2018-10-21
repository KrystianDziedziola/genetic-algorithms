import model.Gene;
import model.Population;
import model.parameters.Parameters;

import java.util.ArrayList;

public class KnapsackApplication {

    public static void main(final String[] args) {
//        final Parameters parameters = InputParametersReader.read();
        final Parameters parameters = new Parameters(10, new ArrayList<>(), 0, 10, 0, 0, 0);

        final int populationSize = parameters.getPopulationSize();
        int numberOfItems = parameters.getNumberOfItems();

        final Population population = new Population(populationSize, numberOfItems);

        System.out.println(parameters);
    }
}
