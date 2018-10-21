package model;

import java.util.ArrayList;
import java.util.List;

public class Gene {

    final List<Chromosome> chromosomes = new ArrayList<>();

    public Gene(final int size) {
        for (int chromosome = 0; chromosome < size; chromosome++) {
            chromosomes.add(Chromosome.random());
        }
    }
}
