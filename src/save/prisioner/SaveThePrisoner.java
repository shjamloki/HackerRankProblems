package save.prisioner;

/**
 * #!/usr/bin/env python3
 * T = int(input().strip())
 * for _ in range(T):
 *   N,M,S = list(map(int, input().strip().split()))
 *     print(((S - 1 + M - 1) % N) + 1)
 *
 */
public class SaveThePrisoner {
	public static void main(String[] args) {
		//System.out.println(saveThePrisoner(7, 19,2));
		System.out.println(saveThePrisoner(3,7,3));
	}
	 // Complete the saveThePrisoner function below.
	/**
	 * m= 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 
	 * i= 6 5 4 3 2 1 7 6 5  4  3  2  1  7  6  5  4  3  2
	 */
    static int saveThePrisoner(int n, int m, int s) {
    	// One liner solution found on discussion :
    	//return ((M - 1) + (S - 1)) % N + 1;
    	
    	/*
    	 * It is passed this time. Trick was to do the dry run.
    	 */
    	int i=s;
    	for(;m>1;)
    	{
    		if(i<n)
    		{
    	    	int remainingInCycle = n-i;
    			int remainingCandies = m-1;// last candies you need to tell.
    		 if(remainingCandies > remainingInCycle)
    		 {
    			   i += remainingInCycle;
    	    	   m = m- remainingInCycle;
    		 }
    		 else 
    		 {
    			 i +=remainingCandies;
    			 return i;
    		 }
    		}
    		else if(m==1)
    		{
    			return i;
    		}
    		else
    		{
    			i=1;
    			m--;
    			int remainder = (m-1)% (n-i+1);
    			return i+remainder;
    		}
    	}
    	return i;
    	/**
    	 * second attempt again failed due to time out.
    	 */
     /*	int i=s;
    	for(;m>1;)
    	{
    		if(i<n)
    		{
    	    	int remainingInCycle = n-i;
    			int remainingCandies = m-1;// last candies you need to tell.
    		 if(remainingCandies > remainingInCycle)
    		 {
    			   i += remainingInCycle;
    	    	   m = m- remainingInCycle;
    		 }
    		 else 
    		 {
    			 i +=remainingCandies;
    			 return i;
    		 }
    		}
    		else if(m==1)
    		{
    			return i;
    		}
    		else
    		{
    			i=1;
    			m--;
    		}
    	}
    	return i; */
    	
    	/**
    	 * First attempt but could not finish within the time limit.
    	 */
    	/*int i=s;
    	for (;m>1;)
    	{
        if(i<n)
        {
        	i++;
        	m--;
        }
        else if(i>=n)
    	  {
    		  i=1;
    		  m--;
    	  }
    	}
    	return i;*/
    }

}
