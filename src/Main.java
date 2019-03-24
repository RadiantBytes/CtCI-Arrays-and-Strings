//import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "cat is back";
		String input2 = "tac";
		
		String input3 = "pale";
		String input4 = "pale";
		
		/* isUnique
		if (isUnique(input)) System.out.println("True, all characters are unique");
		else System.out.println("False, the characters are not unique");
		*/
		
		/* checkPermutation
		if (checkPermutation(input, input2)) System.out.println("True, " + input + " is a permutation of "
				+ input2);
		else System.out.println("False, " + input + " is not a permutation of " + input2);
		*/
		
		/* URLify
		System.out.println(URLify(input, input.length()));
		*/
		
		/* oneAway
		if (oneAway(input3, input4)) System.out.println("True, one character away");
		else System.out.println("False, not one character away");
		*/
		
		String input5 = "acbb";
		
		/* stringCompression
		System.out.println(stringCompression(input5));
		*/
	}
	
	public static boolean isUnique(String input) {
		
		char[] charArr = input.toCharArray();
		
		for (int i = 0; i < input.length(); i++) {
			
			for (int d = i; d < input.length(); d++) {
				
				if ( (charArr[i] == charArr[d]) && (i != d) ) return false;
			}
		}
		
		return true;
		
	}
	
	
	public static boolean checkPermutation(String input, String input2) {
		
		if (input.length() != input2.length()) return false;
		
		char[] charArr1 = input.toCharArray();
		char[] charArr2 = input2.toCharArray();
		
		Arrays.sort(charArr1);
		Arrays.sort(charArr2);
		
		for (int i = 0; i < input.length(); i++) {
			if (charArr1[i] != charArr2[i]) return false;
		}
		
		return true;
		
		

	}


	public static String URLify(String input, int length) {
		
		String ret = input.replaceAll(" ", "%20");
		
		return ret;
	}
	
	public static boolean oneAway(String input1, String input2) {
		boolean doozyFound = false;
		
		if (Math.max(input1.length(), input2.length()) - Math.min(input1.length(), input2.length()) > 1)
			return false;
			
		if (input1.length() != input2.length()) doozyFound = true;
			
		char[] charArr1 = input1.toCharArray();
		char[] charArr2 = input2.toCharArray();
		
		
		
		for (int i = 0; i < Math.min(charArr1.length, charArr2.length); i++) {
			
			if (charArr1[i] != charArr2[i]) {
				if (doozyFound) return false;
				else doozyFound = true;
			}
		}
		
		return true;
	}
	
	public static String stringCompression(String input) {
		
		String compressedString = "";
		char[] charArr = input.toCharArray();
		char currChar = charArr[0];
		
		boolean returnOriginal = true;
		
		compressedString += currChar;
		
		int charCount = 1;
		
		for (int i = 0 ; i < input.length() - 1; i++) {

			
			if (charArr[i] == charArr[i+1]) charCount++;
			
			else {
				compressedString += charCount;
				
				compressedString += charArr[i+1];
				
				charCount = 1;
				
			}
			
			if (charCount > 1) {
				returnOriginal = false;
			}
		}
		
		compressedString += charCount;
		
		if (returnOriginal) return input;
		else return compressedString;
		
		
	}

}
