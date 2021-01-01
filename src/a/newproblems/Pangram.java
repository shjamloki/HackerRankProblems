package a.newproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pangram {
	public static void main(String[] args) {
		System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
		System.out.println(checkStringForAllLetterUsingRegex("We promptly judged antique ivory buckles for the next prize"));
	}
	
	static String pangrams1(String s) {
	    s=s.toLowerCase();
	    String pan = "qwertyuiopasdfghjklzxcvbnm";
	    for(char c : pan.toCharArray()){
	        if(!s.contains(""+c))
	            return "not pangram";
	    }
	    return "pangram";
	    }
	
	static String pangrams2(String s) {
		   Set<Character> set = new HashSet<>();
		    s = s.toLowerCase();
		    for (int i = 0; i < s.length(); i++) {

		        set.add(s.charAt(i));
		    }        
		    if (set.size() == 27) return "pangram";
		    return "not pangram";
		}

	static String pangrams3(String s) {
		   return (s.toLowerCase().chars()
	                  .filter(i -> (i >= 'a' && i <= 'z'))
	                  .distinct()
	                  .count() == 26 ? "pangram" : "not pangram");
	}
	
	public static boolean checkStringForAllLetterUsingRegex(String input) {
		/*
		 * we are first eliminating all the characters except alphabet 
		 * letters from the input. Then we are removing duplicate characters.
		 * Finally, we are counting letters and making sure we have all of them, 26.
		 */
	    return input.toLowerCase()
	      .replaceAll("[^a-z]", "")
	      .replaceAll("(.)(?=.*\\1)", "")
	      .length() == 26;
	}
	// Complete the pangrams function below.
    static String pangrams(String s) {
    	Character[] ch1 = new Character[] {'a','b','c','d','e','f','g','h','i','j'
				,'k','l','m','n','o','p','q','r','s','t',
				'u','v','w','x','y','z',' '};
    	String yes = "pangram";
    	String no ="not pangram";
    	Set<Character> st = new HashSet<>(Arrays.asList(ch1));
    	char[] test = s.toLowerCase().toCharArray();
    	for (char ch : test) {
			if(st.contains(ch))
			{
				st.remove(ch);
			}
		}
    	if(st.isEmpty())return yes;
    	return no;
    }

}
