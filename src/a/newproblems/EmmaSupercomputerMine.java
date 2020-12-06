package a.newproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmmaSupercomputerMine {
	public static void main(String[] args) {
		System.out.println(twoPluses(new String[] {
				"GGGGGG",
				"GBBBGB",
				"GGGGGG",
				"GGBBGB",
				"GGGGGG"
		}));
	System.out.println("=================================");
	System.out.println(twoPluses(new String[] {
				"BGBBGB",
				"GGGGGG",
				"BGBBGB",
				"GGGGGG",
				"BGBBGB",
				"BGBBGB"
		}));
	System.out.println("=================================");	
	System.out.println(twoPluses(new String[] {
				"GGGGGGG",
				"BGBBBBG",
				"BGBBBBG",
				"GGGGGGG",
				"GGGGGGG",
				"BGBBBBG"
		}));
	System.out.println("=================================");	
	System.out.println(twoPluses(new String[] {
			"GGGGGGGGGG",
			"GBBBBBBGGG",
			"GGGGGGGGGG",
			"GGGGGGGGGG",
			"GBBBBBBGGG",
			"GGGGGGGGGG",
			"GBBBBBBGGG",
			"GBBBBBBGGG",
			"GGGGGGGGGG"
			
			/**
			 *	"GGGGGGG  G GG",
				"GBBBBBB  G GG",
				"GGGGGG G G G G",
				"GGGGGGG  G GG",
				"GBBBBBB  G GG",
				--------------
				"GGGGGGGG G G",
				"GBBBBBBG G G",
				"GBBBBBBG G G",
				"GGGGGGGGGG"
			 */
	}));
	}
	 // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
    	Map<Set<String>,Integer> plusMap = new HashMap<>(); 
    	for(int i =1;i<grid.length-1;i++)
    	{
    		for(int j=1;j<grid[i].length()-1;j++)
    		{
    		//System.out.println("checking for point : ("+i+","+j+")");	
    		 if(grid[i].charAt(j)=='G')
    		 {
    			//left
    			 int leftcount=0;
    			 int rightcount=0;
    			 int upcount=0;
    			 int downcount=0;
    			 int temp=i-1;
    			 while(temp>=0)
    			 {
    				 if(grid[temp].charAt(j)=='G') {
    					 upcount++;
    					 temp--;
    				 }
    				 else break;
    			 }
    			 temp=i+1;
    			 while(temp <grid.length)
    			 {
    				 if(grid[temp].charAt(j)=='G') {
    					 downcount++;
    					 temp++;
    				 }
    				 else break;
    			 }
    			 temp=j-1;
    			 while(temp >=0)
    			 {
    				 if(grid[i].charAt(temp)=='G') {
    					 leftcount++;
    					 temp--;
    				 }
    				 else break;
    			 }
    			 temp=j+1;
    			 while(temp <grid[i].length())
    			 {
    				 if(grid[i].charAt(temp)=='G') {
    					 rightcount++;
    					 temp++;
    				 }
    				 else break;
    			 }
    			 int hz=Math.min(leftcount, rightcount);
    			 int vt = Math.min(upcount, downcount);
    			 int minSiz = Math.min(hz, vt);
    			 if(minSiz !=0)
    			 {
    				Set<String> points = new HashSet<>();
    			  	 for(int k=1;k<=minSiz;k++)
    				 {
    					 points.add((i-k)+","+j);
    					 points.add((i+k)+","+j);
    					 points.add(i+","+(j-k));
    					 points.add(i+","+(j+k));
    				 }
    				 points.add(i+","+j);
    				 if(plusMap.isEmpty())
    				 {
    					System.out.println("adding to the map -->("+i+","+j+") size "+((4*minSiz)+1));
						plusMap.put(points, (4*minSiz)+1);
    				 }
    				for (Set<String> m : plusMap.keySet())
    				{
					    int n = plusMap.get(m);
    					int p = (4*minSiz)+1;
    					long count = m.stream()
    					  .distinct()
    					  .filter(points::contains)
    					  .count();
    					System.out.println("count = "+count+" for point => ("+i+","+j+")");
    					if(n<p &&  count >0)
    					 {
    						 System.out.println("removing m,n "+m+" "+n+" from the map");
    						 System.out.println("adding to the map -->("+i+","+j+") size "+((4*minSiz)+1));
    						 plusMap.put(points, (4*minSiz)+1);
    						 plusMap.remove(m);
    						 break;
    					 }
						else if(count ==0)
						{
							System.out.println("adding to the map -->("+i+","+j+") size "+((4*minSiz)+1));
							plusMap.put(points, (4*minSiz)+1);
							break;
		    			}
    				 };
    			 }
    		 }
    		}
    		
    	}
    	int[] count = new int[] {0};
    	int []result = new int[] {1};
    	System.out.println(plusMap);
    	plusMap.entrySet()
    			.stream()
    			.sorted(Map.Entry.<Set<String>, Integer>comparingByValue().reversed())
    			.forEach(j->{
    				if(count[0]>1) {
    				//ignore
    					}
    				else
    				{
    				 result[0] *= j.getValue();
    				 count[0]++;
    				}
    			});
    	return result[0];
    }
	
}
