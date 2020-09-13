package number.grade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HackerLand University has the following grading policy: 
 * -> Every student receives a grade in the inclusive range from 0 to 100. 
 * -> Any less than 40 is a failing grade.  
 * Sam is a professor at the university and likes to round each student' grade 
 * according to these rules:  
 *  -> If the difference between the grade and the next multiple of 5 is less
 *   than 3, round grade up to the next multiple of 5.
 *  -> If the value of is grade less than 38, no rounding occurs as the result 
 * will still be a failing grade.
 *
 */

public class NumberGrading {
	/*
	 * Complete the 'gradingStudents' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts INTEGER_ARRAY grades as parameter.
	 */

	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		List<Integer> result = new ArrayList<Integer>();
		for (Integer grade : grades) {
			if(grade < 38)
			{
				result.add(grade);
			}
			else if(grade % 5 >= 3)
			{
				int newmultiple = (int)grade/5;
				result.add((newmultiple+1)*5);
			}
			else
			{
				result.add(grade);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(gradingStudents(Arrays.asList(new Integer[] {73,67,38,33})));
	}
}
