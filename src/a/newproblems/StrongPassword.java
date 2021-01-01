package a.newproblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {
	public static void main(String[] args) {
		System.out.println(minimumNumber(3,"790"));
		System.out.println(minimumNumber(3,"zss"));
		System.out.println(minimumNumber(3,"ULA"));
		System.out.println(minimumNumber(3,"##@"));
		System.out.println(minimumNumber(4,"4700"));
		
	}
	
	private static int checkPass(String s) {
		int count = 0;
		
		Pattern patternDigit = Pattern.compile("(\\d)");
		Pattern patternUpper = Pattern.compile("([A-Z])");
		Pattern patternLower = Pattern.compile("([a-z])");
		Pattern patternSpecial = Pattern.compile("(\\W)");
        
		Matcher matcherDigit = patternDigit.matcher(s);
		Matcher matcherUpper = patternUpper.matcher(s);
		Matcher matcherLower = patternLower.matcher(s);
		Matcher matcherSpecial = patternSpecial.matcher(s);
		
		if (!matcherDigit.find()) {
			count++;
		}
		if (!matcherUpper.find()) {
			count++;
		}
		if (!matcherLower.find()) {
			count++;
		}
		if (!matcherSpecial.find()) {
			count++;
		}
		if ((count+s.length())<6) {
			count = count + 6-(count+s.length());
		}
		return count;
	}

// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {
		int count =0;
		if(password.chars().filter(c -> Character.isDigit(c)).count()==0)count++;
		if(password.chars().filter(c -> Character.isLowerCase(c)).count()==0)count++;
		if(password.chars().filter(c -> Character.isUpperCase(c)).count()==0)count++;
		if(password.chars().filter(c -> !Character.isLetterOrDigit(c)).count()==0)count++;
		// Return the minimum number of characters to make the password strong
		int minLen =6-password.length();
		//System.out.println("count - "+count+" minLen - "+minLen);
		if(minLen >0) {
			if(minLen > count)
			return minLen;
			else
			{
				return minLen+(count-minLen);
			}
		}
		else return count;
	}
}
