package a.newproblems;

public class CamelCase {
	public static void main(String[] args) {
		System.out.println(camelcase("oneTwoThree"));
	}
	
	 // Complete the camelcase function below.
    static int camelcase(String s) {
    	return (int)s.chars().filter(i-> i>=65 && i<= 90).count()+1;
    }

}
