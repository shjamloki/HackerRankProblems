package acm.icpc.teams;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * python -3
 * from collections import Counter
 * from itertools import combinations
 * 
 * def acmTeam(topic)
 *  f=[]
 *  lst = list(combinations(topic, 2))
 *  for j in lst:
 *      c = str(int(j[0])+int(j[1]))
 *          f.append(len(c)-Counter(c)['0'])
 *  return(max(f),f.count(max(f))) 
 *
 *
 * ===> This is real elegant.
 * python bit wise :
 *   A = [str(bin(int(x,2)|int(y,2))).count('1') for x,y in combinations(topic, 2)]
 *   return [max(A), A.count(max(A))]
 */
public class AcmTeam {

	public static void main(String[] args) {
		String[] test = new String[] {
				"10101",
				"11100",
				"11010",
				"00101"
		};
		System.out.println(Arrays.toString(acmTeam(test)));
	}
	// Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
    	//bit wise : 
    	BigInteger[] familiarity = new BigInteger[topic.length];
    	 for(int i=0; i<topic.length; i++) {
    		 // the 2 is radix very important here.
    	        familiarity[i] = new BigInteger(topic[i],2);
    	    }
    	 BigInteger score;
    	 int maxBitCount = 0;
    	 int maxScoreCount = 0;
    	for(int i=0; i<familiarity.length-1; i++) {
            for(int j=i+1; j<=familiarity.length-1; j++) {
                score = familiarity[i].or(familiarity[j]);
                int bitCount = score.bitCount();
                if(bitCount > maxBitCount) {
                    maxBitCount = bitCount;
                    maxScoreCount = 1;
                } else if(bitCount == maxBitCount) {
                    maxScoreCount++;
                }
            }
        }
    	int result[] = new int[] {maxBitCount,maxScoreCount};
    	
    	/**
    	 * My attempt worked well except the expected time limt for two test when 
    	 * I did the calculation for result outside
    	 * the loop. When I moved them inside all tests passed.
    	 */
    /*	int numOfTeams = topic.length;
    	int [] result = new int[] {0,0};
    	for(int i=0;i<numOfTeams;i++)
    	{
    		for(int j=i+1; j<numOfTeams;j++)
    		{
    			int topicKnownsforThisTeam = 0;
    			for(int k=0;k<topic[i].length();k++)
    			{
    				int first = Integer.parseInt(topic[i].charAt(k)+"");
    				int second = Integer.parseInt(topic[j].charAt(k)+"");
    				if((first | second)==1)topicKnownsforThisTeam++;
    			}
    			if(topicKnownsforThisTeam > result[0])
    			{
    				result[1] =1;
    				result[0]=topicKnownsforThisTeam;
    			}
    			else if (topicKnownsforThisTeam== result[0])
    			{
    				result[1]++;
    			}
    		}
    	}*/
    	return result;
    }
}
