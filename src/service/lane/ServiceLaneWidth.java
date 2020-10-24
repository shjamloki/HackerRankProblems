package service.lane;

import java.util.Arrays;

/**
 * def serviceLane(width, cases):        
 *     return [min(width[x:y+1]) for x,y in cases]
 *
 */
public class ServiceLaneWidth {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(serviceLane(8, new int[][] {{2,3,1,2,3,2,3,3},{6,7}})));
	}

	static int[] serviceLane(int n, int[][] cases) {
		int [] widths = cases[0]; //2,3,1,2,3,2,3,3
		int [] result = new int[cases.length-1]; //1
		for(int i=1;i<cases.length;i++)
		{
		 int minWidth = Integer.MAX_VALUE;
		 for(int k = cases[i][0]; k<= cases[i][1]; k++)
		 {
			 if(widths[k]<minWidth)
			 {
				 minWidth = widths[k];
			 }
		 }
		 result[i-1]=minWidth; //2
		}
		return result;
	}

}
