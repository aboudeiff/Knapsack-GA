import java.util.*;
import Chromosomes.Chromosome;
import Evaluation.Evaluation;
import Selection.Selection;
import Crossover.Crossover;
import Mutation.Mutation;

public class Knapsack {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int knapsackCapacity = 0;
		int numberOfItems = 0;
		int population = 4;
		double itemValue = 0;
		double itemWeight = 0;
		int numberOfSelections = 4;

		int testCases = 0;
		System.out.print("Enter number of test cases: ");
		testCases = scanner.nextInt();
		while (testCases != 0) {
			System.out.print("Enter capacity of knapsack: ");
			knapsackCapacity = scanner.nextInt();

			System.out.print("Enter number of items: ");
			numberOfItems = scanner.nextInt();

			Chromosome chromosome = new Chromosome();
			chromosome.setNumberOfItems(numberOfItems);
			chromosome.setPopulationSize(population);
			chromosome.setNumberOfSelections(numberOfSelections);
			chromosome.makePopulation();
			// chromosome.showPopulation();

			System.out.println("------------------------");

			chromosome.setKnapsackCapacity(knapsackCapacity);
			Evaluation evaluation = new Evaluation(chromosome);
			System.out.println("Enter Values and Weights: ");

			for (int i = 0; i < chromosome.getNumberOfItems(); i++) {
				itemValue = scanner.nextDouble();
				itemWeight = scanner.nextDouble();

				chromosome.setValueOfItems(itemValue);
				chromosome.setWeightOfItems(itemWeight);
			}

			evaluation.evaluatePopulation();
			chromosome.printData();
			System.out.println("------------------------");

			Selection selection = new Selection(chromosome);
			selection.rankSelection();
			chromosome.printSelectedParents();

			System.out.println("------------------------");
			Crossover crossover = new Crossover(chromosome);
			crossover.crossoverParents();

			System.out.println("------------------------");
			Mutation mutation = new Mutation(chromosome);
			mutation.mutateGenes();
			chromosome.printMutatedChromosomes();

			testCases--;

		}

	}

}
