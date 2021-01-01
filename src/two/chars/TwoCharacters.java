package two.chars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TwoCharacters {
	public static final int NUM_LETTERS = 26;
	public static void main(String[] args) {
      System.out.println(alternate("beabeefeab"));
	}
	
	
	static int alternate1(String s)
	{
		HashSet<Character> h = new HashSet<Character>();
		List<Character> g = new ArrayList<Character>();

		for(int i = 0; i < s.length(); i++)
		    h.add(s.charAt(i));

		for(Character i: h)
		    g.add(i);

		int n = g.size(), max = 0, k = 0;    

		for(int i = 0; i < n; i++)
		{
		    for(int j = i+1; j < n; j++)
		    {
		        String temp = "[^" + g.get(i) + g.get(j) + "]";
		        String f = s.replaceAll(temp,"");

		        for(k = 0; k < f.length()-1; k++)
		        {
		            if(f.charAt(k) == f.charAt(k+1))
		              break;
		        }

		        if(k == f.length()-1)
		          max = Math.max(f.length(),max);
		    }
		}
		    return max;
	}

	static int alternate(String str)
	{
		/* Edge case */
        if (str.length() <= 1) {
            return 0;
        }
        
        /* Create arrays representing the 26^2 subproblems */
        int [][] pair  = new int[NUM_LETTERS][NUM_LETTERS];
        int [][] count = new int[NUM_LETTERS][NUM_LETTERS];
        
        for (int i = 0; i < str.length(); i++) {
            char letter   = str.charAt(i);
            int letterNum = letter - 'a';
            
            /* Update row */
            for (int col = 0; col < NUM_LETTERS; col++) {
                if (pair[letterNum][col] == letter) {
                    count[letterNum][col] = -1;
                }
                if (count[letterNum][col] != -1) {
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }
            
            /* Update column */
            for (int row = 0; row < NUM_LETTERS; row++) {
                if (pair[row][letterNum] == letter) {
                    count[row][letterNum] = -1;
                }
                if (count[row][letterNum] != -1) {
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }
        System.out.println("========pairs==========");
        for (int[] p : pair) {
			System.out.println(Arrays.toString(p));
		}
        System.out.println("==========counts======");
        for (int[] c : count) {
			System.out.println(Arrays.toString(c));
		}
        
        /* Find max in "count" array */
        int max = 0;
        for (int row = 0; row < NUM_LETTERS; row++) {
            for (int col = 0; col < NUM_LETTERS; col++) {
                max = Math.max(max, count[row][col]);
            }
        }
        return max;
	}
}
