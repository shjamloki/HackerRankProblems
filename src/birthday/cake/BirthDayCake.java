package birthday.cake;

import java.util.Arrays;
import java.util.List;

public class BirthDayCake {
	
	 // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
    	//2nd attempt 
    	int length = s.size();
    	    int numWays = 0, sum = 0;

    	    for(int i = 0 ; i <= (length - m) ; i++){
    	        for(int j = 0 ; j < m ; j++){
    	            sum = sum + s.get(j+i);
    	        }
    	        if(sum == d){
    	            numWays++;
    	        }
    	        sum = 0;
    	    }
    	    return numWays;
    	//1st attempt
    	/*int result = 0;
    	for(int i =0; i< s.size();i++)
    	{
    		if(s.get(i) > d) continue;
    		int sum = s.get(i);
    		int count =1;
    		if(sum ==d && count ==m) 
    			{
    			result++;
    			continue;
    			}
    		for(int j =i+1;j < s.size() && sum < d && count < m;j++)
    		{ 
    		   sum += s.get(j);	
    		   count++;
    	       if(sum ==d && count == m)
    			   {
    			   result++ ;
    			   break;
    		    }
    		   else if (sum > d)
    		   {
    			   break;
    		   }
    	    }
    	}
    	return result;*/
    }

	public static void main(String[] args) {
		Integer square [] = new Integer[] {1,2,1,3,2};
		int birthday = 3;
		int birthmonth = 2;
		System.out.println(birthday(Arrays.asList(square),birthday,birthmonth));
	}
}
