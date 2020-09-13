import java.util.Arrays;
import java.util.Scanner;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

Example 
arr = [1,3,5,,7,9]
The minimum sum is 1+3+5+7=16  and the maximum sum is 3+5+7+9=24

The function prints

16 24

Function Description

Complete the miniMaxSum function in the editor below.

miniMaxSum has the following parameter(s):

    arr: an array of 

    integers

Print

Print two space-separated integers on one line: the minimum sum and the maximum sum of
of

elements.

Input Format

A single line of five space-separated integers.

Constraints 1 <= arr[i] <= 10^9

Output Format

Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

Sample Input

1 2 3 4 5

Sample Output

10 14

Explanation

The numbers are
1,2 ,3 ,4 , and 5

. Calculate the following sums using four of the five integers:

    Sum everything except 

1, the sum is
.
Sum everything except 1, the sum is 2+3+4+5 = 14.
Sum everything except 2, the sum is 1+3+4+5 = 13.
Sum everything except 3, the sum is 1+2+4+5 = 12.
Sum everything except 4, the sum is 1+2+3+5 = 11.
Sum everything except 5, the sum is 1+2+3+4 = 10.


Hints: Beware of integer overflow! Use 64-bit Integer.
 *
 */
public class MinMaxSum {
	
	 private static final Scanner scanner = new Scanner(System.in);
	 
	 
	 
	// Complete the miniMaxSum function below.
	    static void miniMaxSum(int[] arr) {
	        // array - 1 2 3 4 5
	        // combinations : {1,2,3,4}, {2,3,4,5},{3,4,5,1},{4,5,1,2},{5,1,2,3}
	       

	        long min = Arrays.stream(arr).mapToLong(f -> f).min().getAsLong();
	        long max = Arrays.stream(arr).mapToLong(f -> f).max().getAsLong();
	        long sum = Arrays.stream(arr).mapToLong(f -> f).sum();

	    System.out.println((sum - max) + " " + (sum - min));
	        //try -1
	       /*
	        long minSum = 0;
	        long maxSum = 0; 
	       for(int i=0; i< arr.length; i++)
	        {
	            int numOfEle =1;
	            long thisLoopSum =0;
	            // i =0 , j = 0,1,2,3 k -X
	            // i =1, j =1,2,3,4 K -X
	            // i =2 , j = 2,3,4 K - 0
	            // i =3 , j = 3,4 K - 0,1
	            // i =4, j = 4 K = 0,1,2
	         //j =2, j <= 4-1 =1; 0<= 4 ==> 2, 3
	         for(int j =i; j< (arr.length) && numOfEle <= 4; j++)  
	         {
	         thisLoopSum += arr[j];
	         numOfEle++;
	         }
	         for(int k=0; k < i && numOfEle <=4; k++)
	         {
	            thisLoopSum += arr[k];
	            numOfEle++;
	         }
	         if(thisLoopSum > maxSum) 
	         {
	             maxSum = thisLoopSum;
	         }
	         if(thisLoopSum <= minSum || i ==0){
	              minSum = thisLoopSum;
	         }
	        } 
	     System.out.println(minSum+" "+maxSum); */
	    }
	 
	 public static void main(String[] args) {
		 int[] arr = new int[5];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < 5; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        miniMaxSum(arr);

	        scanner.close();
	}

}
