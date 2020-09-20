package drawing.book;

public class TurnMinimumPages {
	/*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
    return Math.min(p/2,(n/2-p/2));
    /*	Map<Integer,List<Integer>> lookup = new HashMap<>();
    	int k=0;
    	for(int i =1; k<=n;i++)
    	{
    		lookup.put(i,Arrays.asList(k++,k++));
    	}
    	System.out.println(lookup);
    	int count = 0;
		if(n/2 >= p)
    	{
			boolean isFound = false;
    		for (int j = 1; j <= lookup.size()/2  && !isFound; j++)
    		{
    			for (int i =0; i<lookup.get(j).size(); i++)
    			{	
    				if(lookup.get(j).get(i)==p)
    				{
    					isFound = true;
    	    			break;
    				}
    			}
    			if(isFound)
    			{
    				break;
    			}
    			count++;
    		}
    	}
    	else
    	{
    		boolean isFound = false;
    		for (int j = lookup.size(); j > lookup.size()/2  && !isFound; j--)
    		{
    			for (int i =0; i<lookup.get(j).size(); i++)
    			{	
    				if(lookup.get(j).get(i)==p)
    				{
    					isFound = true;
    	    			break;
    				}
    			}
    			if(isFound)
    			{
    				break;
    			}
    			count++;
    		}
    	}
    	return count;*/

    }
	public static void main(String[] args) {
		System.out.println(pageCount(2,1));
		//System.out.println(pageCount(6,2));
	}
}
