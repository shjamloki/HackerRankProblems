package a.newproblems;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CisearCipher {
public static void main(String[] args) {
	System.out.println(caesarCipher("middle-Outz", 2));
}
//Complete the caesarCipher function below.
static String caesarCipher(String s, int k) {
	//abcdefghijklmnopqrstuvwxyz
	//wxyz
	List<Integer> range = IntStream.rangeClosed(65,90).boxed().collect(Collectors.toList());
	List<Integer> range1 = IntStream.rangeClosed(97,122).boxed().collect(Collectors.toList());
	StringBuilder build = new StringBuilder();
	for (int i : s.chars().toArray()) {
		if(range.contains(i))
		{
		int t = range.indexOf(i);	
		int newChar = range.get((t + (range.size() + k)) % range.size());   
		build.append((char)newChar);
		}
		else if(range1.contains(i))
		{
			int t = range1.indexOf(i);	
			int newChar = range1.get((t + (range1.size() + k)) % range1.size());      
			build.append((char)newChar);	
		}
		else
		{
			build.append((char)i);
		}
	}
return build.toString();
}
}
