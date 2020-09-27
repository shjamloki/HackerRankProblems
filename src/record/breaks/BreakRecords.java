package record.breaks;

import java.util.Arrays;

public class BreakRecords {
	
	// Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
    	    int max =0;
        int min = 0;
        int [] result = new int[]{0,0};
      for(int i =0; i < scores.length; i++)
      {
          if (i==0) min = max=scores[i];
          else if(scores[i] > max)
          {
        	      max = scores[i];
                  result[0]++;
          }
          else if(scores[i] < min)
          {
        	  min = scores[i];
              result[1]++;
          }
      }
      return result;
    }
	public static void main(String[] args) {
		int [] scores = new int [] {3,4,21,36,10,28,35,5,24,42};
		System.out.println(Arrays.toString(breakingRecords(scores)));
	}

}
