package OOPsConceptPart1;

public class ClassObjectConcept {
	
	//class variables
	int mod;
	int wheel;

	public static void main(String[] args) {

		ClassObjectConcept car = new ClassObjectConcept();
		ClassObjectConcept car1 = new ClassObjectConcept();
		ClassObjectConcept car2 = new ClassObjectConcept();
		
		
		car.mod = 2016;
		car.wheel = 4;
		
		car1.mod = 2015;
		car1.wheel = 4;
		
		car2.mod = 2014;
		car2.wheel = 4;
		
		//Before assigning the references
		System.out.println(car.mod);
		System.out.println(car.wheel);
		
		System.out.println(car1.mod);
		System.out.println(car1.wheel);
		
		System.out.println(car2.mod);
		System.out.println(car2.wheel);
		
		//After shifting the references
		
		car=car1;
		car1=car2;
		car2=car;
		
		
		car.mod = 10;
		System.out.println(car.mod);//10
		car2.mod = 20;
		System.out.println(car.mod);
		System.out.println(car2.mod);
		

	}

}
