package chocolate.feast;


/**
 *
 *def getBars(m,n):
 *   if n < m:
 *         return 0
 *   else:
 *        return (math.floor(n/m) + getBars(m,(math.floor(n/m)+n%m)))
 *        
 *def chocolateFeast(n, c, m):
 *  return(math.floor(n/c) + getBars(m,math.floor(n/c)))
 */
public class ChocolateFeast {
	public static void main(String[] args) {
		//System.out.println(chocolateFeast(10, 2, 5));
		//System.out.println(chocolateFeast(12,4, 4));
		System.out.println(chocolateFeast(6, 2, 2));
	}

	// Complete the chocolateFeast function below.
	static int chocolateFeast(int n, int c, int m)
	{
		int result = n/c; //10 /2 = 5
		int wrappers = result; // 5
		while(wrappers >= m) //5 >= 5
		{
			int newChoc = wrappers/m; //1
			int wrappersSpend = newChoc * m; //1
			wrappers = (wrappers - wrappersSpend ) + newChoc; //5 -5+1
			result += newChoc; //5+1
		}
		return result;
	}
}
