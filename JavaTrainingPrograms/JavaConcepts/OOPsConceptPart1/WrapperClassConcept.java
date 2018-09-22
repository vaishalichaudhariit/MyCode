package OOPsConceptPart1;

public class WrapperClassConcept {

	public static void main(String[] args) {
		
		String x = "100";
		System.out.println(x+20);
		
		//data conversion String to int:
		int i = Integer.parseInt(x);
		System.out.println(i+20);
		
		//Wrapper classes - Integer, Double, Character, Boolean, String, Long, Short, Byte,
		//In Java no primitive for String. String is wrapper class
		
		//String to double conversion:
		String y = "12.33";
		double d = Double.parseDouble(y);
		System.out.println(d+10);
		
		//String to Char
		String k="A";
		char c = k.charAt(0);
		System.out.println(c);
		
		//String to boolean
		String str = "true";
		boolean val = Boolean.parseBoolean(str);
		System.out.println(val);
		
		
		//Int to String conversion
		int j = 200;
		System.out.println(j);
		String str1 = String.valueOf(j);
		System.out.println(str1+20);
		
		String str2 = "100A";
		//int iNo = Integer.parseInt(str2);
		//System.out.println(iNo);// java.lang.NumberFormatException
		
		System.out.println(str1.getClass().getName());
		String str3 = str1.getClass().getName();
		System.out.println(str3.substring(0,1).toUpperCase());
		System.out.println(str3.substring(1,4).toUpperCase());
		
		
		
		
	}

}
