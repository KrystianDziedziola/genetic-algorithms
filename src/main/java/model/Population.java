package model;

import model.parameters.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Population {

  private final List<Gene> genes = new ArrayList<>();

  public Population(final int populationSize, final int geneSize) {
    for (int geneNumber = 0; geneNumber < populationSize; geneNumber++) {
      genes.add(new Gene(geneSize));
    }
  }

  public Score evaluate(final List<Item> items, int knapsackCapacity) {
    final List<Score> scores =
        genes
            .stream()
            .map(gene -> gene.evaluate(items, knapsackCapacity))
            .collect(Collectors.toList());
    //        todo:
    return null;
  }
}
