package between.sets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * You will be given two arrays of integers and asked to determine all 
 * integers that satisfy the following two conditions:
 *   The elements of the first array are all factors of the integer being considered 
 *   The integer being considered is a factor of all elements of the second array 
 * These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.
 *
 *For example, given the arrays a=[2,26] and b=[24,36], there are two numbers between them:
 * 6 and 12. 6%2=0,6%6=0 ,24%6=0 and 36%6=0for the first value. Similarly 12%2=0, 12%6=0, and 24%12=0,36%12=0 . 
 * 
 * Function Description 
 * Complete the getTotalX function in the editor below. It should return the number of integers that 
 * are between the sets.  getTotalX has the following parameter(s):
 *   a: an array of integers
 *   b: an array of integers
 *   
 *   
 * Input Format
 * The first line contains two space-separated integers 
 * n and m, the number of elements in array a and b the number of elements in array.
 * The second line contains distinct n space-separated integers describing a[i] where 0<=i<=n .
 * The third line contains distinct space-separated integers describing b[j] where  0<=j<=m.
 * Constraints
 * 
 * 1<=n,m <= 10
 * 1<=a[i]<= 100
 * 1 <=b[j]<= 100
 * 
 * Output Format
 * Print the number of integers that are considered to be between a and b.
 * Sample Input
 * 2 3
 * 2 4
 * 16 32 96
 * Sample Output
 * 3
 * Explanation 
 * 2 and 4 divide evenly into 4, 8, 12 and 16.
 * 4, 8 and 16 divide evenly into 16, 32, 96.
 * 4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b. 
 */
public class BetweenTwoSets {
	
	public static void main(String[] args) {
		Integer [] first = new Integer [] {2,4};
		Integer [] second = new Integer[] {16,32,96};
		
		System.out.println(getTotalX(Arrays.asList(first),Arrays.asList(second)));
		
	}
	/*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    	int lcmVal = getLcm(a);
        int count =0;
        int [] lcm = new int[]{lcmVal};
        Collections.sort(b); 
        for (int j=1;lcm[0]<=b.get(0);)
        {
            long test =b.stream().filter(k-> k%lcm[0]==0).count();
            if(test==b.size())
            {
                System.out.println(lcm[0]);
                count++;
            }
            j++;
            lcm[0] = lcmVal*j;
        }
        return count;
    }
    
    private static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

    public static int gcd(int... numbers) {
        return Arrays.stream(numbers).reduce(0, (x, y) -> gcd(x, y));
    }

    public static int getLcm(List<Integer> numbers) {
        return numbers.stream().reduce(1, (x, y) -> x * (y / gcd(x, y)));
    }


}
