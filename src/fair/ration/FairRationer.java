package fair.ration;

/*
 * def fairRations(B):
 *    loaves = 0
 *     for i in range(len(B)-1):
 *       	if B[i]%2 == 1:
 *          	  B[i+1] += 1
 *            	loaves += 2
 *     return loaves if B[-1]%2 == 0 else "NO"
 */
public class FairRationer {
	public static void main(String[] args) 
	{
		//System.out.println(String.valueOf(fairRations(new int[] {2,3,4,5,6})));
		//System.out.println(String.valueOf(fairRations(new int[] {3,8,4,6,1,9,8,8,6,7,5,2,1,5,8,6,1,3,3,9,3,7,8,5,5,4,7,2,9,8,7,7,4,4,7,1,5,3})));
		//int val = fairRations(new int[] {1,2});
		int val = fairRations(new int[] {
				2,4,6,8	
		});
		String result = (val == -1)? "NO":val+"";
		System.out.println(result);
	}
	// Complete the fairRations function below.
	static int fairRations(int[] B) {
		int sum = 0;
		for (int B_i = 0; B_i < B.length; B_i++) {
			sum += B[B_i];
		}

		int count = 0;
		if (sum % 2 == 1) {
			return -1;
		} else {
			for (int i = 0; i < B.length; i++) {
				if (B[i] % 2 != 0)
				{
					B[i] = B[i] + 1;
					B[i + 1] = B[i + 1] + 1;
					count += 2;
				}
			}
		}
		return count;
	}
	 static String fairRations1(int[] B) {
	        int count = 0;
	        for (int i = 0; i < B.length-1; i++) {
	            if (B[i]%2!=0){
	                B[i]++;
	                B[i+1]++;
	                count++;
	            }
	        }
	        if (B[B.length-1]%2!=0) return "NO";
	        return String.valueOf(count*2);
	    }
}
