package utopian.tree;

/**
 * python 3
 * def utopianTree(n):
 *     if n < 3:
 *          return n + 1
 *     if n % 2 == 0:
 *         return (utopianTree(n - 2) * 2) + 1
 *     else:
 *         return (utopianTree(n - 2) + 1) * 2
 *
 */
public class UtopianTreeHeightFunction {
	// Complete the utopianTree function below.
	static int utopianTree(int n) {
		
		//aother solution :
		return ((int) Math.pow(2, (n + 3) / 2)) + (((int) Math.pow(-1, n)) - 3) / 2;
		//bit wise operator 
		//return ~(~1<<(n>>1)) << n%2;
		//1st attempt
	 /*	int height = 1;
		for (int i=1;i<=n; i++)
		{
			if(i%2 ==0)
				height += 1;
			else 
				height *= 2;
		}
		return height; */
	}
	public static void main(String[] args) {
		System.out.println(utopianTree(4));
	}
}
