package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length()>s2.length()) {
			return s1;
		}
		return s2;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		for (int i =0; i<s.length();i++) {
			if (s.contains("underscores")) {
				s = s.replace(" ", "_");
			}
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String [] s1a=s1.trim().split(" ");
		String [] s2a=s2.trim().split(" ");
		String [] s3a=s3.trim().split(" ");
		if (s1a[1].compareToIgnoreCase(s3a[1])<0&&s1a[1].compareToIgnoreCase(s2a[1])<0) {
			return s1.trim();
		}
		if (s3a[1].compareToIgnoreCase(s1a[1])<0&&s3a[1].compareToIgnoreCase(s2a[1])<0) {
			return s3.trim();
		}
		else {
			return s2.trim();
		}
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum=0;
		for (int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int cc =Character.getNumericValue(ch);
				sum = cc+sum;
			}
		}
	
		
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int count = 0;
		while (s.contains(substring)) {
				count++;
		s =	s.replaceFirst(substring, "");
		}
		return count;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
	String ss =	Utilities.encrypt(s.getBytes(), (byte)key);
		return ss;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		 String q =Utilities.decrypt(s,(byte) key);
		return q;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
	String [] n =	s.split(" ");
	int num = 0;
	for (int i =0; i<n.length;i++) {
		if (n[i].endsWith(substring)) {
			num++;
		}
	}
		return num;
		
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
	int chara =	s.indexOf(substring);
	int cha =	s.lastIndexOf(substring);
	int diff = cha-chara;
	diff = diff-substring.length();
		return diff;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String rev = "";
		String forward = "";
		for (int i=s.length()-1;i>=0;i--) {
			char letter = s.charAt(i);
			if(Character.isLetter(letter)) {
				rev = rev+letter;
				forward = letter+forward;
			}
		}	
	
		if (rev.toLowerCase().equals(forward.toLowerCase())) {
			return true;
		}
		return false;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
