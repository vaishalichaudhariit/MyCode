package SingletonPack;

public class Singleton {
	
	/*~~Singleton Class in Java:
		In object-oriented programming, a singleton class is a class that can have only one object (an instance of the class) at a time.
		How to design singleton class:
		1. Make constructor as private
		2. Write a public static method that has return type of object of this singleton class (Lazy Initialization)
	 */
	
	
	private static Singleton singleton_instace = null;
	public String str;
	
	private Singleton(){
		str = "Hey, I am using singleton class pattern";
	}
	
	public static Singleton getInstance(){
		if(singleton_instace == null)
			singleton_instace = new Singleton();
		return singleton_instace;
	}
	public static void main(String[] args) {
		
		Singleton st = Singleton.getInstance();
		Singleton st1 = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		
		st.str = (st.str).toUpperCase();
		
		System.out.println(st.str);
		System.out.println(st1.str);
		System.out.println(st2.str);
		
		st1.str = (st1.str).toLowerCase();
		
		System.out.println(st.str);
		System.out.println(st1.str);
		System.out.println(st2.str);
	}

}
