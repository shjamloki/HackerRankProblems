package bigger.is.greater;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *    for i in range(len(s)-1)[::-1]:
        for j in range(i+1,len(s))[::-1]:
            if s[i] < s[j]:
                li = list(s) 
                li[i],li[j]=li[j],li[i]
                return "".join(li[:i+1]+sorted(li[i+1:][::-1]))        
   return 'no answer'
 *
 */
public class BigerIsGreater {
	public static void main(String[] args) {
		System.out.println(biggerIsGreater2("dkhc")); //answer is : 
	}
	
	 static String biggerIsGreater2(String s) 
	    {
	        char charArr[] = s.toCharArray();
	        int n = charArr.length;
	        int i = 0;
	        for (i = n - 1; i > 0; i--)
	        {
	            if (charArr[i] > charArr[i - 1]) 
	            {
	                break;
	            }
	        }
	        if (i == 0) 
	        {
	            return "no answer";
	        } 
	        else 
	        {
	            int small = charArr[i - 1], next = i;

	            for (int j = i + 1; j < n; j++) 
	            {
	                if (charArr[j] > small && charArr[j] < charArr[next])
	                {
	                    next = j;
	                }
	            }
	            swap(charArr, i - 1, next);
	            Arrays.sort(charArr, i , n);
	        }
	        return new String(charArr);
	    }
	    static void swap(char charArr[], int i, int j)
	    {
	        char temp = charArr[i];
	        charArr[i] = charArr[j];
	        charArr[j] = temp;
	    }
	static String biggerIsGreater1(String wt)
	{
		char[] w = wt.toCharArray();
	    for (int i = w.length - 2; i >= 0; i--) {
	        for (int j = w.length - 1; j > i; j--) {
	            if (w[j] > w[i]) {
	                String result = "";
	                for (int k = 0; k < i; k++) {
	                    result += w[k];
	                }
	                result += w[j];
	                for (int t = w.length - 1; t > i; t--) {
	                    if (t != j) result += w[t];
	                    else result+= w[i];
	                }
	                return result;
	            }
	        }
	    }
	    return "no answer";
	}
	
	// Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
    	//Map : 0 - >a 1-> b
    	//start from last. check what is the nearest bigger number from this current one.
    	// swap with it.
    	Map<Integer,Character> maps = new HashMap<>();
    	String result = "";
		for(int i=0;i<w.length();i++)
		{
		 	maps.put(i, w.charAt(i));
		}
    	for(int i=w.length()-1;i>0;i--)
    	{
    		System.out.println("i value = "+i);
    		int pos =findNearestBiggerNeighbour(i,maps);
    		if(pos == -1)continue;
    		else
    		{
    		result = w.substring(0,pos)+w.charAt(i)
    						+w.substring(pos+1,i)
    						+w.charAt(pos)
    						+w.substring(i+1);
    		
    		//break;
    		}
    	}
    	if(result.isEmpty()) return "no answer";
    	return result;
    }

	private static int findNearestBiggerNeighbour(int location, Map<Integer, Character> maps) {
		int [] minDistance=new int[] {Integer.MAX_VALUE,0};
		if(maps.entrySet()
				.stream()
				.filter(j->j.getValue()< maps.get(location) && j.getKey() < location)
				.count()==0) return -1;
		else
		{
			maps.entrySet()
			.stream()
			.filter(j->j.getValue() < maps.get(location)&& j.getKey() < location)
			.forEach(j->{
				int distance = location - j.getKey();
				System.out.println("j.getKey() ==>"+j.getKey()
				+" j value =>"+j.getValue()+" location =>"+location+" loc char =>"+maps.get(location)+" distance is =>"+distance);
				System.out.println("min distance =>"+minDistance[0]);
				if(distance==0) {}
				else if(distance <= minDistance[0])
				{
					System.out.println("changed min distance to "+distance+" current value is : "+minDistance[0]);
					minDistance[0]=distance;
					minDistance[1]=j.getKey();
				}
			});
		}
		return minDistance[1];
	}

}
