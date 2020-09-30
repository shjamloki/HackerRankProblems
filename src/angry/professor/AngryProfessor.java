package angry.professor;

import java.util.Arrays;

public class AngryProfessor {

	public static void main(String[] args) {
		int [] test= new int [] {0,-1,2,1};
		System.out.println(angryProfessor(3, test));
	}
	//Complete the angryProfessor function below.
	static String angryProfessor(int k, int[] a) {
		long count =Arrays.stream(a).filter(i -> i<= 0).count();
		return (count >=k)? "NO": "YES";
	}
}
