package first

class Person {
	String firstName
	String lastName
	int age
	def address
	static main(args) {
		
		Person p = new Person()
		// use the generated access methods
		p.setFirstName("Lars")
		// this will still use the generated access method, it is not a direct access!
		p.lastName = "Vogel"
		p.address = ("Homestreet 3");
		println(p.firstName + " " + p.lastName + " "+ p.address);
		// use the generated constructor
		p = new Person(firstName: "Peter", lastName:"Mueller", address:"Pune");
		println(p.firstName + " " + p.lastName + " "+ p.address);
	}

}
