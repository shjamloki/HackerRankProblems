package a.newproblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * #bucketsort
 * n = int(input().strip())
 * unsorted = []
 * lengths = []
 * 
 * for k in range(n):
 *   number = str(input().strip())
 *    unsorted.append(number)
 *    lengths.append(len(number))
 *    
 *  biglist = zip(lengths,unsorted)
 *  
 * for i in sorted(biglist):
 *    print(i[1])
 *
 */
public class BigSorting {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(bigSorting(new String[] {"1","10","8","23","15","999","69","123"})));
	}
	 // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
    	Comparator<String> test = (x,y)-> {
    		// If the length is not the same, we return the difference.
    		// A negative # means, x Length is shorter, 0 means the same (this doesn't occur) and a postive # means Y is bigger
    		if (x.length() != y.length()) return x.length() - y.length();

    		// Now the length is the same.
    		// Compare the number from the first digit.
    		for (int i = 0; i < x.length(); i++)
    		{
    			char left = x.charAt(i);
    			char right = y.charAt(i);
    			if (left != right)
    				return left - right;
    		}

    		// Default: "0" means both numbers are the same.
    		return 0;
    	};
    	Arrays.sort(unsorted, test);
    return unsorted;
    }
}
