package hiker.tracking;

public class CountValleys {

	public static void main(String[] args) {
		System.out.println(countingValleys(8,"UDDDUDUU"));
	}

	/*
	 * Complete the 'countingValleys' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER steps
	 *  2. STRING path
	 */
	
	/**
	 * python : 
	 * def countingValleys(n, s): 
	 * a,b = 0,0
	 * d = {"U":1, "D":-1}
	 * for i in s:
	 *  if not a+d[i] and a<0:
	 *       b+=1
	 *  a+=d[i]
	 *  return b
	 * n,s = input(),input()
	 * print(countingValleys(n, s))
	 */

	public static int countingValleys(int steps, String path) {
		// Write your code here
		int countValey=0;
		boolean isValleyStarted=false;
		int resultStep =0;
		for(int i=0;i<steps;i++)
		{
			if(resultStep ==0)
			{
				if(path.charAt(i)=='D')
				{
					//System.out.println(" -1 = valley  started = D");
					resultStep --;
					isValleyStarted = true;
				}
				else
				{
					//System.out.println(" +1 = mountain started. = U");
					resultStep++;
				}
			}
			else 
			{
				if(path.charAt(i)=='D')
				{
					//System.out.println(" -1 =  D");
					resultStep--;
				}
				else
				{
					//System.out.println (" +1 = U");
					resultStep++;
				}
				if(isValleyStarted && resultStep ==0)
				{
					//System.out.println("  seaLevel with vally start=  = 0");
					isValleyStarted = false;
					countValey++;
				}
				else if(!isValleyStarted && resultStep ==0)
				{
					//System.out.println("  sea lelve with mountain start =0");
					isValleyStarted = false;
				}
			}

		}
		return countValey;
	}
}
