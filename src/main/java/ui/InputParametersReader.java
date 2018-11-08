package ui;

import model.parameters.Item;
import model.parameters.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Copied from someone on Github
 */
public class InputParametersReader {

    public static Parameters read() {
        String input;
        int numberOfItems = 0;
        List<Item> items = new ArrayList<>();
        int knapsackCapacity = 0;
        int populationSize = 0;
        int maximumGenerations = 0;
        double crossoverProbability = 0;
        double mutationProbability = 0;


        // Initialize console for user input
        Scanner sc = new Scanner(System.in);

        // Number of items
        System.out.println("Enter the number of items: ");
        input = sc.nextLine();
        if (isInteger(input)) {
            numberOfItems =
                    Integer.parseInt(input);
        } else {
            System.out.println("Not a number. Please try again.");
            System.exit(1);
        }

        // Value and weight of each item
        for (int i = 0; i < numberOfItems; i++) {
            double value = 0;
            System.out.println("Enter the value of item " + (i + 1) + ": ");
            input = sc.nextLine();
            if (isDouble(input)) {
                value = Double.parseDouble(input);
            } else {
                System.out.println("Not a number. Please try again.");
                System.exit(1);
            }

            double weight = 0;
            System.out.println("Enter the weight of item " + (i + 1) + ": ");
            input = sc.nextLine();
            if (isDouble(input)) {
                weight = Double.parseDouble(input);
            } else {
                System.out.println("Not a number. Please try again.");
                System.exit(1);
            }

            items.add(new Item(value, weight));
        }

        // Capacity of knapsack
        System.out.println("Enter the knapsack capacity: ");
        input = sc.nextLine();
        if (isInteger(input)) {
            knapsackCapacity = Integer.parseInt(input);
        } else {
            System.out.println("Not a number. Please try again.");
            System.exit(1);
        }

        // Population size
        System.out.println("Enter the population size: ");
        input = sc.nextLine();
        if (isInteger(input)) {
            populationSize = Integer.parseInt(input);
        } else {
            System.out.println("Not a number. Please try again.");
            System.exit(1);
        }

        // Maximum number of generations
        System.out.println("Enter the maximum number of generations: ");
        input = sc.nextLine();
        if (isInteger(input)) {
            maximumGenerations = Integer.parseInt(input);
        } else {
            System.out.println("Not a number. Please try again.");
            System.exit(1);
        }

        // Crossover probability
        System.out.println("Enter the crossover probability: ");
        input = sc.nextLine();
        if (isDouble(input)) {
            crossoverProbability = Double.parseDouble(input);
        } else {
            System.out.println("Not a number. Please try again.");
            System.exit(1);
        }

        // Mutation probability
        System.out.println("Enter the mutation probability: ");
        input = sc.nextLine();
        if (isDouble(input)) {
            mutationProbability = Double.parseDouble(input);
        } else {
            System.out.println("Not a number. Please try again.");
            System.exit(1);
        }

        return new Parameters(items, knapsackCapacity, populationSize, maximumGenerations, crossoverProbability, mutationProbability);
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
