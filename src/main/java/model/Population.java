package model;

import java.util.ArrayList;
import java.util.List;

public class Population {

    private final List<Gene> genes = new ArrayList<>();

    public Population(final int populationSize, final int geneSize) {
        for (int geneNumber = 0; populationSize < geneNumber; geneNumber++) {
            genes.add(new Gene(geneSize));
        }
    }
}
