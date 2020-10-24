package beautiful.triplet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

/**
 * python 3
 * =============================
 * n,d=map(int,input().split())
 * seq=list(map(int,input().split()))
 * print(sum([(i+d in seq and i-d in seq) for i in seq]))
 *
 */
public class BeautifulTriplet {

	public static void main(String[] args) {
		System.out.println(beautifulTriplets2(3,new int[] {1,2,4,5,7,8,10}));
	}
	
	 static int beautifulTriplets2(int d, int[] arr) {
		 List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		 return (int)list.stream().filter(j->
			 list.contains((j+d)) && list.contains((j-d))).count();
	 }
	/**
	 *  Complete the beautifulTriplets function below. 
	 *  first attempt 3 for loops. Did not Time out as well. 
	 */
    static int beautifulTriplets(int d, int[] arr) {
        int count =0;
        for(int i=0;i< arr.length;i++)
    	{
        	int [] triplet = {0,0,0};
        	triplet[0]=i;
        	for(int j=i+1;j<arr.length;j++)
    		{
        		if(arr[j]-arr[i]==d)
        		{
        			triplet[1]=arr[j];	
        			for(int k=j;k<arr.length;k++)
        			{
        				if(arr[k]-arr[j]==d)
        				{
        					triplet[2]=arr[k];
        					//System.out.println("triplet found =>"+Arrays.toString(triplet));
        					count++;
        				}
        			}
        		}
    		}
        	triplet[0]=triplet[1]=triplet[2]=0;
        	continue;
    	}
    	return count;
    }
}
