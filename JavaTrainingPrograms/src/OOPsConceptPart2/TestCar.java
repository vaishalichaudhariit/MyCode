package OOPsConceptPart2;

public class TestCar {

	public static void main(String[] args) {
		// Create a object of sub class
		BMW b = new BMW(); // Method overriding
		
		//Compile time \ static polymorphism 
		b.start(); //common method in Parent and Child class. Preference will be Child class. Java compiler take child method  
		b.stop();
		b.refuel();
		b.theftSafetly();
		b.engine();

		System.out.println("**************");
		
		Car c = new Car();
		c.start();
		c.stop();
		c.refuel();
		c.engine();
		//c.theftSafetly; Not able to access any child method
		
		System.out.println("**************");
		//child class object can be referred by parent class reference variable - dynamic polymorphism - Run time polymorphism
		//Top casting
		Car c1= new BMW(); // new BMW(); - Create object inside the memory
		c1.start();// Access child method - overridden method
		c1.stop();
		c1.refuel();
		c1.engine();
		//c1.theftSafetly; Not able to access using run time polymorphism. Security issue. Access only compile time polymorphism 
		
		//Down casting is possible, code get compiled but gives runtime exception - ClassCastException
		BMW b1 = (BMW) new Car(); //ClassCastException at runtime- > java.lang.ClassCastException
		b1.engine();
		b1.start();
		b1.stop();
		b1.theftSafetly();
	}

}
