package pick.numbers;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * python 3:
 * def pickingNumbers(a):
 *	print(max([a.count(i) + a.count(i+1) for i in a]))
 * ============================	
 *	max(list(map(lambda x: a.count(x) + a.count(x - 1), a)))
 *  ===========================
 * python code :
 *n=int(input())
 *l=[int(i) for i in input().split()]
 *maximum=0
 *for i in l:
 *  c=l.count(i)
 *    d=l.count(i-1)
 *    c=c+d
 *    if c > maximum
 *      maximum=c
 * print(maximum) 
 *
 */
public class PickNumbers {
	public static void main(String[] args) {
		//System.out.println(pickingNumbers(Arrays.asList(98,3,99,1,97,2)));
		System.out.println(pickingNumbers(Arrays.asList(4,4,4,4,4,4)));
	}
	public static int pickingNumbers(List<Integer> numlist) {
		//2nd attemp : : - why i natively think this way. to have an array with 
		// frequency.
		int frequency[] = new int[101];
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < numlist.size(); i++) {
			int index=numlist.get(i);
			frequency[index]++; //frequency[index]=frequency[index]+1
		}

		for (int i = 1; i <= 100; i++) {
			result = Math.max(result, frequency[i] + frequency[i - 1]);
		}
		return result;
		// 1st attempt :
		/*Collections.sort(numlist);
		int resultSize =0;
		int prevres = 0;
		int currentNum = 0;
		ArrayList<Integer> res = new ArrayList<>();
		for(int i =0; i<numlist.size(); i++)
		{
			if(i==0)
			{
				currentNum = numlist.get(i);
			}
			if(numlist.get(i)== currentNum || numlist.get(i) == currentNum+1)
			{
				res.add(numlist.get(i));
				prevres++;
			}
			else
			{
				currentNum = numlist.get(i);
				if(prevres > resultSize)
					{
					resultSize = prevres;
					}
				res.clear();
				res.add(numlist.get(i));
				prevres = 1;
			}
		}
		if(resultSize ==0)
		{
			resultSize=prevres;
		}
		return resultSize; */
	}

}
