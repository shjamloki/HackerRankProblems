import java.io.IOException;
import java.util.stream.IntStream;

public class Solution {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
       /*int sum =0;
        for( int i = 0; i<ar.length; i++)
        {
            sum += ar[i];
           // sum = addInt(sum,ar[i]);
        }
        return sum; */
    	
    	//return IntStream.of(ar).parallel().reduce(0,(sum,current) ->sum+current);
    	return IntStream.of(ar).reduce(0,Integer::sum);
    	
    	//return IntStream.of(ar).sum();
    	}
    
    public static int addInt(int sum,int currentNumber)
    {
    	return sum+currentNumber;
    }

    public static void main(String[] args) throws IOException {
      int test[] = new int[] {1,3,4,5,6,77};
      System.out.println(simpleArraySum(test));
    }
}

