package first

class StringFunctions {

	static main(args) {
		def name="Vaishali"
		println('I am ${name}\n')
		
		println("I am $name\n")
		
		def multiString = '''I am a 
				String that goes on
				from many lines ''';
				
		println(multiString);
		println("3rd Index of Name " + name[3]);
		println("Index of r" +name.indexOf('r'));
		
		println("3rd Index of Name" + name[3]);
	}
}
