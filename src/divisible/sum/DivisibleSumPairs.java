package divisible.sum;

public class DivisibleSumPairs {
	// Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
     	int result =0;
    	for (int i = 0; i < ar.length; i++) {
			
    		for(int j=i+1; j < ar.length;j++)
			{
			 if((ar[i]+ar[j]) %k ==0)
			 {
				 result++;
			 }
			}
		}
    	return result;
    } 
    	/*long result[] = new long[] {0};
    	IntStream.range(0,n).forEach(i->{
    		result[0] = IntStream.range(i,n).filter(j->(ar[i]+ar[j])%k ==0).count();
    		}); */
    
	public static void main(String[] args) {
		int [] ar = new int[] {1,3,2,6,1,2};
		System.out.println(divisibleSumPairs(ar.length, 3, ar));
	}
}
