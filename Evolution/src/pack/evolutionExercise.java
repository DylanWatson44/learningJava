package pack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import nz.ac.vuw.kol.OptimisationFunction;

public class evolutionExercise {
	private static double[] parent1 = new double[5];
	private static double[] parent2 = new double[5];
	private static double[] child1 = new double[5];
	private static double[] child2 = new double[5];
	private static double[] child3 = new double[5];
	private static Random random = new Random();
	private static double startingRandomness = Math.random();
	private static double mutationRate = Math.random()*2;
	private static double mutationRate2 = Math.random();
	private static double Generation = 0;
	private static double bestresult = Integer.MAX_VALUE;
	private static double[] parentOfbestResult;
	private static Queue<Long> resultQueue = new LinkedList<Long>();
	private static Queue<double[]> bestParents = new LinkedList<double[]>();
	private static int codon1 = 0;
	private static int codon2 = 0;
	private static int numberOfPlats = 1;

	public static void main(String[] args) {
		while(true){
		firstExperiment();
		}
		
	}

	private static double[] secondExperiment(double[] input) {
		// randomizeParents();
		// int startnum = (int)(Math.random()*10-5);
		// for(int i = 0; i < 5; i++){
		// parent1[i]=startnum;
		// }
		parent1 = input.clone();
		rollTheWheel();
		for (int j = 0; j <= 1000000; j++) {
			double initialBest = bestresult;
			resultQueue.add(Math.round(bestresult * 100000) / 100000);
			if (resultQueue.size() > 100000) {
				resultQueue.poll();
			}
			//System.out.println("Generation " + Generation);
			test(parent1);

			if (resultQueue.size() > 25 && plat()) {
				//System.out.println("Plateau detected");
				numberOfPlats++;
				//System.out.println("Changing codon and resetting child to the parent of the last best result...");
				rollTheWheel();
				//System.out.println("Changing codon " + (codon1 + 1) + " and " + (codon2 + 1));
				resultQueue = new ArrayDeque<Long>();
				
				//System.out.println();
				parent1 = parentOfbestResult.clone();
				
				// mutationRate = 1;
			}
			parent1[codon1] += rand(mutationRate2);
			parent1[codon2] += rand(mutationRate2);
			// mutationRate += 1;
			// mutationRate %= 1;
			//System.out.println("Mutation rate = " + mutationRate);
			Generation++;
			//System.out.println();
		}
		System.out.println("Second test results : ");
		System.out.println("last test result = " + test(parent1));
		System.out.println("Best result " + bestresult);
		System.out.println("Number of plateaus " + numberOfPlats);
		
		System.out.println("best parent : ");
		System.out.print("[");
		for (int k = 0; k < 4; k++) {
			System.out.print(parentOfbestResult[k] + ", ");
		}
		System.out.print(parentOfbestResult[4] + "]");
		return parentOfbestResult;
	}

	private static double[] firstExperiment() {
		randomizeParents();

		for (int j = 0; j <= 1000000; j++) {
			double initialBest = bestresult;
			resultQueue.add(Math.round(bestresult * 1000000) / 1000000);
			if (resultQueue.size() > 100000) {
				resultQueue.poll();
			}
			//System.out.println("Generation " + Generation);
			test(parent1);
			test(parent2);

			for (int i = 0; i < 5; i++) {
				child1[i] = (parent1[i] + parent2[i]) / 2;
			}
			child2 = child1.clone();
			child3 = child1.clone();
			// mutationRate *= 0.5;
			for (int i = 0; i < 3; i++) {
				child1[i] += rand(mutationRate);
				child2[i] += rand(mutationRate);
				child3[i] += rand(mutationRate);
			}
			double[] results = { OptimisationFunction.unknownFunction(child1),
					OptimisationFunction.unknownFunction(child2), OptimisationFunction.unknownFunction(child3) };

			test(child1);
			test(child2);
			test(child3);
			ArrayList<double[]> nextGen = new ArrayList<>();
			nextGen.add(child1);
			nextGen.add(child2);
			nextGen.add(child3);
			nextGen.add(parent1);
			nextGen.add(parent2);

			//System.out.println();
			ArrayList<double[]> newParents = doNextGen(nextGen);
			parent1 = newParents.get(0);
			parent2 = newParents.get(1);
			if (initialBest == bestresult) {
				// mutationRate *=3;
			}

			if (resultQueue.size() > 25 && plat()) {
				//System.out.println("Plateau detected");
				numberOfPlats++;
				if (bestParents.peek() != parentOfbestResult) {
					bestParents.add(parentOfbestResult);
				}
				if (bestParents.size() == 2) {
					System.out.println("Mixing best parents from 2 best populations");
					parent1 = bestParents.poll();
					parent2 = bestParents.poll();
				} else {
					//System.out.println("Generating new population...");
					randomizeParents();
					//mutationRate = 1;
				}
				resultQueue = new ArrayDeque<Long>();

			}

		}
		System.out.println("Best result " + bestresult);
		System.out.println("Number of plateaus " + numberOfPlats);
		System.out.println("best parent : ");
		System.out.print("[");
		for (int k = 0; k < 4; k++) {
			System.out.print(parentOfbestResult[k] + ", ");
		}
		System.out.print(parentOfbestResult[4] + "] \r\n");
		
		return parentOfbestResult;
	}

	private static double rand(double x) {

		random.nextDouble();
		if ((Math.random() * 4 + 1) > 1) {
			return random.nextDouble() * (x * 2) - x;
		} else
			return 0;
	}

	private static ArrayList<double[]> doNextGen(ArrayList<double[]> children) {
		while (children.size() > 2) {
			double highest = 0;
			int indexToRemove = 0;
			// ArrayList<Double[]> childrenlist = new ArrayList<Double[]>();
			for (int i = 0; i < children.size(); i++) {
				if (OptimisationFunction.unknownFunction(children.get(i)) > highest) {
					highest = OptimisationFunction.unknownFunction(children.get(i));
					indexToRemove = i;
				}
			}
			children.remove(indexToRemove);
		}
		Generation++;
		return children;
	}

	private static double test(double[] testarray) {
		double result = OptimisationFunction.unknownFunction(testarray);
		if (result < bestresult) {
			bestresult = result;
			parentOfbestResult = testarray;
		}

		return result;
	}

	private static boolean plat() {
		ArrayList<Long> templist = new ArrayList<Long>();
		templist.addAll(resultQueue);
		Long x = templist.get(0);
		for (Long i : templist) {
			if (i == x) {

			} else {
				return false;
			}
		}
		return true;
	}

	private static void randomizeParents() {
		for (int i = 0; i < 5; i++) {
			parent1[i] = rand(startingRandomness);
			parent2[i] = rand(startingRandomness);
		}
	}

	private static int rollTheWheel() {
		int oldcodon1 = codon1;
		int oldcodon2 = codon2;
		int newcodon1 = (int) (Math.random() * 5);
		int newcodon2 = (int) (Math.random() * 5);
		if ((oldcodon1 != newcodon1)) {
			codon1 = newcodon1;
			codon2 = newcodon2;
		} else {
			rollTheWheel();
		}
		return codon1;

	}

}
