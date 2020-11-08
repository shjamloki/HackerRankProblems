package mansa.stone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. 
 * She starts following the trail and notices that any two consecutive stones' numbers 
 * differ by one of two values. Legend has it that there is a treasure trove at the end of the trail. 
 * If Manasa can guess the value of the last stone, the treasure will be hers.
 *
 *For example, assume she finds 2 stones and their differences are a=2 or b=3 . We know she starts with a 0 
 *stone not included in her count. The permutations of differences for the two stones would be [2,2][2,3][3,2] or [3,3] . 
 *Looking at each scenario, stones might have [2,4],[2,5],[3,5]or[3,6] on them. The last stone might have any of 4,5 or 6
 *on its face.
 *
 *Compute all possible numbers that might occur on the last stone given a starting stone with a 0
 *on it, a number of additional stones found, and the possible differences between consecutive stones. 
 *Order the list ascending.
 *
 *n=3 a=1 b=2 =>
 *With differences 1 and 2, all possible series for the first test case are given below:
 *  0,1,2
 *  0,1,3
 *  0,2,3
 *  0,2,4
 *  Hence the answer 2 3 4.
 *  
 *  n=4 a=10 b=100
 *  0, 10, 20, 30
 *  0, 10, 20, 120
 *  0, 10, 110, 120
 *  0, 10, 110, 210
 *  0, 100, 110, 120
 *  0, 100, 110, 210
 *  0, 100, 200, 210
 *  0, 100, 200, 300
 *  
 *  Hence the answer 30 120 210 300.

*/
/*
 * from itertools import combinations_with_replacement 
 * # Complete the stones function below.
 * def stones(n, a, b):
 *  mas = []
 *  res = list(combinations_with_replacement ([a,b],n-1))
 *  for a in res:
 *        mas.append(sum(list(a)))
 *  return sorted(list(set(mas)))
 * 
 * =============
 * python 3 :
 * print (' '.join(map(str,sorted({x*a+(n-1-x)*b for x in range(n)}))))
 */
public class FindLastStoneNumber {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(stones1(4, 10, 100)));
	}

	static int[] stones2(int n, int a, int b) {

		/**
		 * if a equals b, the last stone can have only 1 value, which is (n - 1) * a.
		 * if a does not equal b, we notice that 2 consecutive stones 
		 * can have a difference of a or b. In a path, there are n-1 
		 * differences representing pairs of adjacent stones. We are not 
		 * interested in where in the path the difference between 2 stones 
		 * is a or b, since changing the order of where the differences occur 
		 * still results in the same value for the last stone. What's 
		 * important is the # of times the difference between 2 stones 
		 * is a and the # of times it's b. For a >= 0 and b >= 0, 
		 * there are n-1 ways to choose a and b such that a + b == n-1, 
		 * so there are n-1 possibilities for the last stone.
		 * 
		 * To print the n-1 possible values for the last stone, we iterate through 
		 * the n-1 combinations of a and b and calculate the value of the last stone 
		 * for each combination.
		 */
		int[] arrStones = new int[n];
		for (int i = 0; i < n; i++) {
			if(a==b) {
				return new int[] {(n-1)*a};
			}
			else{
				int temp = a * ((n - 1) - i) + b * i;
				arrStones[i] = temp;
			}
			
		}
		Arrays.sort(arrStones);
		return arrStones;

	}

	static int[] stones1(int n, int a, int b) {
		/**
		 * The key to solving this quickly is to realize that any permutation of moves
		 * containing the same amount of "a" and "b" will have the same end result. From
		 * this, we know that n stones will have n possible distinct results.
		 * 
		 * For example, if n is 4, then we have possible results: 0 + a + a + a 0 + a +
		 * a + b 0 + a + b + b 0 + b + b + b
		 */
		TreeSet<Integer> finalStones = new TreeSet<Integer>();

		for (int i = 0; i < n; i++) {
			int sum = (i * a) + ((n - 1 - i) * b);
			finalStones.add(sum);
		}
		int[] result = new int[finalStones.size()];
		int count = 0;
		for (Integer e : finalStones) {
			// System.out.print(e+" ");
			result[count] = e;
			count++;
		}
		return result;
	}

	// Complete the stones function below.
	static int[] stones(int n, int a, int b) {
		Map<Integer, Set<Integer>> stepValues = new HashMap<>();
		// first will always be 0
		// possible second
		Set<Integer> tempValues1 = new HashSet<>();
		tempValues1.add(0 + a);// 1
		tempValues1.add(0 + b);// 2
		stepValues.put(0, tempValues1);
		int[] count = new int[] { 1 };
		int[] next = new int[1];
		// set have second value so we will iterate from third value.
		Map<Integer, Set<Integer>> tempMap = new HashMap<>();
		for (next[0] = 2; next[0] < n; next[0]++) {
			stepValues.entrySet().stream().forEach(k -> {// 0
				Set<Integer> tempValues3 = new HashSet<>();
				k.getValue().stream().forEach(p -> {// 1,2
					tempValues3.add(p + a);// 2
					tempValues3.add(p + b);// 3
				});
				tempMap.put(next[0], tempValues3);// (1->2,3),(2->3,4)
				count[0]++;
			});
			System.out.println("next possible next values are " + tempMap);
			stepValues.clear();
			stepValues.putAll(tempMap);
		}
		count[0] = 0;
		Set<Integer> result = new HashSet<>();
		stepValues.entrySet().forEach(t -> {
			t.getValue().stream().forEach(l -> {
				result.add(l);
			});
		});
		;
		int[] arr = new int[result.size()];
		result.stream().forEach(m -> {
			arr[count[0]] = m;
			count[0]++;
		});
		return arr;
	}
}
