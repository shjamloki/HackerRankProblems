package array.minimum.distance;

import java.util.HashMap;
import java.util.Map;

/**
 *# Complete the minimumDistances function below.
 *def minimumDistances(a):
 *
 *  length = len(a)
 *  min_dis = length
 *  dict  = {}
 *  
 *  for i in range(length)
 *          if a[i] in dict:
 *              min_dis = min(min_dis , i - dict[a[i]])
 *          dict[a[i]] = i
 *          
 *  if min_dis != length 
 *     return min_dis
 *  return -1 
 *
 */
public class MinimumDistanceInArray {
	public static void main(String[] args) {
		//System.out.println(minimumDistances(new int[] {7,1,3,4,1,7}));
		System.out.println(minimumDistances2(new int[] {7,1,2,3,4,5}));
		
	}
	
	// Complete the minimumDistances function below.
    static int minimumDistances2(int[] arr) {
    	 Map<Integer, Integer> hm = new HashMap<>();
    	 int minDist= Integer.MAX_VALUE;
    	 for(int i=0; i < arr.length; i++){
    	        if(hm.containsKey(arr[i])) {
    	            int x=hm.get(arr[i]);
    	            int dist = i - x;
    	            if(dist < minDist) minDist = dist;
    	        }
    	        else hm.put(arr[i],i);            
    	    }
    	    if(minDist == Integer.MAX_VALUE) minDist=-1;
    	    return minDist;
    }
	// Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
    	int minDistance = -1;
    	for(int i=0; i< a.length; i++)
    	{
    		for(int j=i+1;j<a.length;j++)
    		{
    			if(a[i]==a[j] && (minDistance == -1 || Math.abs(i-j)< minDistance))
    			{
    				minDistance = Math.abs(i-j);
    				break;
    			}
    		}
    	}
    	return minDistance;
    }
}
