package Crossover;

import java.util.*;
import java.util.stream.DoubleStream;

import Chromosomes.Chromosome;

public class Crossover {

	private double Pc = 0.3;
	private Chromosome chromosome;

	public Crossover(Chromosome chromosome) {
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

	public void crossoverParents() {
		String child1 = "";
		String child2 = "";
		String parent1 = this.chromosome.getSelectedParents().get(0);
		String parent2 = this.chromosome.getSelectedParents().get(1);

		Random rand = new Random();
		double randPc = randomWithRange(0.4, 0.6);
		int crossoverPoint = randomWithRange(1, this.chromosome.getNumberOfItems());
		if (0.3 <= Pc) {
			for (int i = 0; i < this.chromosome.getSelectedParents().size(); i += 2) {
				int idx = i + 1;
				for (int j = 0; j < this.chromosome.getNumberOfItems(); j++) {
					child1 = parent1.substring(0, crossoverPoint) + parent2.substring(crossoverPoint);
					child2 = parent1.substring(crossoverPoint) + parent2.substring(0, crossoverPoint);
					this.chromosome.setChildren(child1);
					this.chromosome.setChildren(child2);
					parent1 = this.chromosome.getSelectedParents().get(i);
					parent2 = this.chromosome.getSelectedParents().get(idx);
				}
			}
			this.chromosome.printChlidren();

		} else {
			System.out.println("No crossover.");
			for (int i = 0; i < this.chromosome.getSelectedParents().size(); i++) {
				this.chromosome.setChildren(this.chromosome.getSelectedParents().get(i));
			}
		}
	}
}
