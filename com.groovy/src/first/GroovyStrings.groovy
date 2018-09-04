package first

class GroovyStrings {

	static main(args) {
		
		String str1 = "This is String literal" +
		"This is new line";
		String str2 = new String("This is a String object");
		
		//String quote String
		def signleQuote = 'This is single quote Sting'//java.lang.String/doesn't support interpolation
		println signleQuote
		
		//triple single quote String
		
		def tripleSingleQuote = '''\
This is triple single quote 
also support multi line''' //doesn't support interpolation
		println tripleSingleQuote
		
		//Interpolation only with Double quote
		def empName = "Vaishali Chaudhari"
		
		//Double quote String
		def doubleQuote = "This is double quote String ${empName}" //java.lang.String
		println doubleQuote
		
		def doubleQuoteEx = "This is double quote String ${int a= 10;int b=30;a+b}" //java.lang.String - groovy.lang.GString
		println doubleQuoteEx
		

		//triple double quote String
		def trpleDoubleQuote = """
this is triple double quote string
line1
line2
line3
${empName}
"""
		
println trpleDoubleQuote

	//Slayshi String
	def slashyString = /-----------
	This is slashyString
	also support
	multiline
	${empName}
	----------/
	println slashyString
	
	//Doller slashy Strings
	def dollerSlashyString = $/\
--------------------------------
	this is doller slapshy String
	also support multi line
	and string interpolation
	${empName}
--------------------------------
	/$

	println dollerSlashyString
	
	String str3 = "Hello ${empName}"
	String str4 = "Hello Vaishali Chaudhari"
	
	println str3.hashCode() + "=" + str4.hashCode()
	
	println dollerSlashyString.toUpperCase()
	
	
	
	
	}

}
