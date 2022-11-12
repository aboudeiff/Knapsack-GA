package Mutation;

import Chromosomes.Chromosome;

import java.text.DecimalFormat;
import java.util.*;

public class Mutation {

	private Chromosome chromosome = new Chromosome();
	private String mutatedChromosome;
	private Random rand = new Random();
	DecimalFormat decimalFormat = new DecimalFormat("#.###");
	private double Pm = 0.012;

	public Mutation() {

	}

	public Mutation(Chromosome chromosome) {
		this.chromosome = chromosome;
	}

	int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	double randomWithRange(double min, double max) {
		double range = (max - min) + 1;
		return (double) (Math.random() * range) + min;
	}

	public void mutateChromosome() {
		double randomNumber = randomWithRange(0.001, 0.1); // compared with Pm (probability of mutation)
		randomNumber = Double.valueOf(decimalFormat.format(randomNumber));
		// Choosing which chromosome to mutate randomly
		int randomChromosome = this.rand.nextInt(this.chromosome.getChildren().size());
		if (randomNumber <= Pm) {
			this.mutatedChromosome = this.chromosome.getChildren().get(randomChromosome);
			// if first gene = 1 then replace all genes that has value 0 to 1 example:
			// if chromosome is 100 then mutated chromosome is 111
			String newChromosome = this.mutatedChromosome.replace('0', '1');
			this.chromosome.setMutatedChromosomes(newChromosome);
		}
	}

	public void mutateGenes() {

		for (int i = 0; i < this.chromosome.getChildren().size(); i++) {
			for (int j = 0; j < this.chromosome.getNumberOfItems(); j++) {
				if (this.chromosome.getChildren().get(i).charAt(j) == '1') {
					String newChromosome = this.chromosome.getChildren().get(j).replace('1', '0');
					this.chromosome.setMutatedChromosomes(newChromosome);
				} else if (this.chromosome.getChildren().get(i).charAt(j) == '0') {
					String newChromosome = this.chromosome.getChildren().get(j).replace('0', '1');
					this.chromosome.setMutatedChromosomes(newChromosome);
				}
			}
		}
	}

// Function to always mutate chromosomes	

	public void sureMutateChromosome() {

		Random rand = new Random();
		int randomChromosome = rand.nextInt(this.chromosome.getPopulation().size());
		System.out.println("Random number: " + randomChromosome);
		System.out.println("Random chromosome: " + this.chromosome.getPopulation().get(randomChromosome));

		this.mutatedChromosome = this.chromosome.getPopulation().get(randomChromosome);

		for (int i = 0; i < this.chromosome.getChildren().size(); i++) {

		}
		if (this.mutatedChromosome.charAt(0) == '1') {
			String newChromosome = this.mutatedChromosome.replace('0', '1');
			this.chromosome.setMutatedChromosomes(newChromosome);
		}

	}

}
