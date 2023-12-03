package FunctionalProgramming;

import java.util.List;

public class ForEachProgram {

	public static void main(String[] args) {

		printAllNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));

	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		
		//Structured way
		for(int number:numbers){
			System.out.println(number);

		}

	}
}
