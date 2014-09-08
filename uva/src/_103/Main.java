package _103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (runCase(sc)) {
			
		}
		sc.close();
	}
	
	public static boolean runCase(Scanner sc) {
		ArrayList<Box> boxes = readBoxes(sc);
		if (boxes == null) {
			return false;
		} else {
			
			return true;
		}
	}
	
	private static ArrayList<Box> readBoxes(Scanner sc) {
		if (!sc.hasNextLine()) {
			return null;
		}
		int numBox = sc.nextInt();
		int dimension = sc.nextInt();
		ArrayList<Box> result = new ArrayList<Box>();
		for (int i = 0; i < numBox; ++i) {
			ArrayList<Integer> sizeData = new ArrayList<Integer>();
			for (int j = 0; j < dimension; ++j) {
				sizeData.add(sc.nextInt());
			}
			result.add(new Box(sizeData));
		}
		return result;
	}
}

class Box implements Comparable<Box> {
	private ArrayList<Integer> dimensions;
	public Box(ArrayList<Integer> dimensions) {
		this.dimensions = new ArrayList<Integer>(dimensions);
		Collections.sort(this.dimensions);
	}
	
	public int getDimension(int index) {
		return this.dimensions.get(index);
	}
	
	public int compareTo(Box box) {
		int numThisSmaller = 0, numThisBigger = 0;
		for (int i = 0; i < this.dimensions.size(); ++i) {
			if (this.getDimension(i) < box.getDimension(i)) {
				++numThisSmaller;
			} else if (this.getDimension(i) > box.getDimension(i)) {
				++numThisBigger;
			}
		}
		
		if (numThisSmaller > 0 && numThisBigger == 0) {
			return -1;
		} else if (numThisSmaller == 0 && numThisBigger > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}