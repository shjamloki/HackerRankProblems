package climb.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * from bisect import bisect_right
 * n = int(input())
 * scores = sorted(set(map(int,input().split())))
 * m = int(input())
 * alice = map(int,input().split())
 * # your code goes here
 * for i in alice:
 *     print(len(scores)-bisect_right(scores,i)+1)
 *
 */
public class ClimbTheLeaderBoard {
	
	public static void main(String[] args) {
		List<Integer>  ranks = Arrays.asList(100,90,90,80,75,60);
		List<Integer>  alice = Arrays.asList(50,65,77,90,102);
	  System.out.println(climbingLeaderboard(ranks, alice));
	}
	
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player)
	{
		List<Integer> results = new ArrayList<Integer>();

        int i = player.size()-1, j = 0, currentPlace = 1, lastScore = ranked.get(0);

        while(i >= 0 && j < ranked.size()){
            if( player.get(i) >= lastScore ){
                results.add(currentPlace);
                i--;
            }else {
                if(ranked.get(j) != lastScore){
                    currentPlace++;
                    lastScore = ranked.get(j);
                }
                j++;
            }
        }

        // Remainder
        while(i >= 0){
            if(player.get(i) >= lastScore)
                results.add(currentPlace);
            else
                results.add(currentPlace+1);
            i--;
        }

        results.sort(Comparator.reverseOrder());

        return results;
	/*	List<Integer> res = new ArrayList<Integer>();
		int i = ranks.size()-1;
        for(int score: alice) {
            while(i>=0) {
                if(score>=ranks.get(i)) i--;
                else {
                	res.add(i+2);
                	break;
                	}
            }
            if(i<0) {
            	res.add(1);
            }
        }
        return res; */
	    
	}
}
