package FunctionalProgramming;

import java.util.List;

public class StreamProgram {

	public static void main(String[] args) {

		//printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
		//printEvenNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
		//printEvenNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
		//printOddNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
		printEvenSquarNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
		printOddCubeNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));

	}

	/*
	 * private static void print(int number) { System.out.println(number); }
	 */

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {

		for(int number : numbers) {
			if(number %2 ==0) {
				System.out.println(number);
			}
		}

	}
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream()
		//.forEach(StreamProgram::print);//Method Reference
		.forEach(System.out::println);
	}

	//Functional Programming  - for each, stream, filter, lambda, method reference
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream()
		.filter(number -> number %2 ==0)//Filter only allow even number with Lambda expression
		.forEach(System.out::println); //Method Reference to print even number

	}

	private static void printOddNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream()
		.filter(number -> number %2 !=0)//Filter only allow even number with Lambda expression
		.forEach(System.out::println); //Method Reference to print even number

	}

	private static void printEvenSquarNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("==============Print Even number's Squar================");
		numbers.stream()
		.filter(number -> number %2 ==0)//Filter only allow even number with Lambda expression
		.map(number -> number * number)
		.forEach(System.out::println); //Method Reference to print even number

	}

	private static void printOddCubeNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("==============Print Odd number's cube================");
		numbers.stream()
		.filter(number -> number %2 !=0)//Filter only allow even number with Lambda expression
		.map(number -> number * number * number)
		.forEach(System.out::println); //Method Reference to print even number

	}
}
