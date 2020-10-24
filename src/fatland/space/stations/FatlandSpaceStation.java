package fatland.space.stations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * def flatlandSpaceStations(n, c):
 * c.sort()
 * maxd = max(c[0], n-1 - c[-1])
 * for i in range(len(c)-1):
 *  	maxd = max((c[i+1]-c[i])//2, maxd)
 * return maxd
 *
 */
public class FatlandSpaceStation {
	public static void main(String[] args) {
		//System.out.println(flatlandSpaceStations(5, new int[] {0,4}));
		System.out.println(flatlandSpaceStations2(6, new int[] {0,1,2,3,4,5}));
	}
	// Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
    	Map<Integer, Integer> mapCityToDistanceNearestStation = new HashMap<>();
    	IntStream.range(0,n) //0,1,2,3,4
    					.forEach(i->{//0,1,2
    							int minDistance = Integer.MAX_VALUE;//minD =99999
    							for(int j = 0; j<c.length;j++)//i=0,j=0,1 i=1,j=0,1 i=2
    							{
    								int thisDistance = Math.abs(i-c[j]); //0->(0,4) 1->(1,3) 2->(2,2
    								if(thisDistance< minDistance) //0->(yes,no), 1->(yes,no) 2->(yes,
    									{
    										minDistance = thisDistance;//minD=0, minD = 0->0,1->1,2->2
    									}
    							}
    							mapCityToDistanceNearestStation.put(i,minDistance);//0->0,1->1
    					});;
    		System.out.println(mapCityToDistanceNearestStation);			
    	return mapCityToDistanceNearestStation.entrySet().stream().mapToInt(i->i.getValue()).max().getAsInt();
    }
    private static int flatlandSpaceStations2(int n,int[] arr){
        Arrays.sort(arr);
        int maxDistance = arr[0];
        for(int i = 1; i < arr.length; i++){
            int distance = (arr[i] - arr[i-1]) / 2;
            if(maxDistance < distance) maxDistance = distance;
        }
        int lastGap = (n-1) - arr[arr.length - 1];
        return (lastGap < maxDistance) ? maxDistance : lastGap;
    }
}
