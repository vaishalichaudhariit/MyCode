package ScenarioBase;

import java.util.Base64;

public class EncrptionAndDecryptionPWDTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encrptData= "Vaishali23";

		byte[] encodedBytes = Base64.getEncoder().encode(encrptData.getBytes());

		System.out.println("encodedBytes --------------->" + new String(encodedBytes));
		
		String decrptData  ="VmFpc2hhbGkyMw==";
		
		byte[] decodeBytes = Base64.getDecoder().decode(decrptData.getBytes());
				
		System.out.println("decodedBytes --------------->" + new String(decodeBytes));
	}

}
