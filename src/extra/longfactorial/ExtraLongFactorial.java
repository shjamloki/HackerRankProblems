package extra.longfactorial;

import java.math.BigInteger;

/*
 * python -3 
 * import math;print(math.factorial(int(input())))
 */
public class ExtraLongFactorial {
	public static void main(String[] args) {
		extraLongFactorials(25);
	}

// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {
		BigInteger result = new BigInteger("1");
		for(int i=n;i>0; i--)
		{
			result = result.multiply(BigInteger.valueOf(i)); 
		}
		System.out.println(result);
	}
	
	
}
