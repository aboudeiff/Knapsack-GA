
import Chromosomes.Chromosome;
import Mutation.Mutation;
import Selection.Selection;
import Evaluation.Evaluation;
import Crossover.Crossover;
import Mutation.Mutation;

import java.util.*;

public class Test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// --------------------------------------------------------------------------//

		// --------------------------------------------------------------------------//

		// --------------------------------------------------------------------------//
		Chromosome chromosome = new Chromosome();
		chromosome.setNumberOfItems(3);
		chromosome.setPopulationSize(4);
		chromosome.setKnapsackCapacity(10);
		chromosome.setNumberOfSelections(3);
		chromosome.makePopulation();
		chromosome.printPopulation();

		Evaluation evaluation = new Evaluation(chromosome);

		System.out.println("Enter Values and Weights: ");

		for (int i = 0; i < chromosome.getNumberOfItems(); i++) {
			double itemValue = scanner.nextDouble();
			double itemWeight = scanner.nextDouble();

			chromosome.setValueOfItems(itemValue);
			chromosome.setWeightOfItems(itemWeight);
		}

		evaluation.evaluatePopulation();
		chromosome.printData();

		Selection s = new Selection(chromosome);
		s.rankSelection();
		chromosome.printRates();
		chromosome.printRateRanges();
		chromosome.printSelectedParents();

    	Crossover c = new Crossover(chromosome);
		c.crossoverParents();

		/*Mutation m = new Mutation();
		m.mutateGenes();
		chromosome.printMutatedChromosomes();*/

		// --------------------------------------------------------------------------//

	}

}
