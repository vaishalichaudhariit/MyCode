package FunctionalProgramming;

import java.util.List;

public class StringFuncctionProgram {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
		
		printAllCoursesIndividually(courses);
		printCoursesHasWordSpring(courses);
		printCoursesHas4Letters(courses);
		printCoursesNoOfChar(courses);
	}


	private static void printAllCoursesIndividually(List<String> courses) {
		System.out.println("==================Print All Courses Individually============================");
		courses.stream()
		.forEach(System.out::println);
	}
	private static void printCoursesHasWordSpring(List<String> courses) {
		System.out.println("==================Print Courses Has word Spring============================");
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
	}
	

	private static void printCoursesHas4Letters(List<String> courses) {
		System.out.println("==================Print Courses 4 letters ============================");
		courses.stream()
		.filter(course -> course.length() >=4)
		.forEach(System.out::println);
		
	}
	
	private static void printCoursesNoOfChar(List<String> courses) {
		System.out.println("==================Print Courses 4 letters ============================");
		courses.stream()
		.map(course -> course + " " + course.length())
		.forEach(System.out::println);
		
	}
}
