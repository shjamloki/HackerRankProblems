package a.newproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *#!/bin/python3

for _ in range(int(input().strip())):
    n, k = [int(x) for x in input().strip().split(' ')]
    if k != 0 and n % k != 0:
        print(-1)
        continue

    arr = [None] * (n+1) # initialize iterable
    for i in range(1,len(arr)):
        if arr[i] is None:
            arr[i] = i + k
            arr[i+k] = i

    print(' '.join([str(j) for j in *arr[1:]]))
    
    ====================
    def absolutePermutation(n, k):
    if k==0:
        return [i for i in range(1,n+1)]
    else:
        i=1
        store=[0]*(n+1)
        while i<=n:
            if i<=n and k+i<=n:
                store[i]=(k+i)
                store[k+i]=i
            else:
                return [-1]
            try:
                i=store.index(0,i)
            except:
                return (store[1:])
        return store[1:]
    
    
 *
 */

public class AbsolutePermutation {
	public int[] absolutePermutation1(int n, int k)
	{
		return null;
	}

	public static void main(String[] args) {
		//System.out.println(Arrays.toString(absolutePermutation(2, 1)));
		System.out.println(Arrays.toString(absolutePermutation(98,7)));
	}

	// Complete the absolutePermutation function below.
	static int[] absolutePermutation(int n, int k) {
		int[] result = new int[n];
		Set<Integer> s = new HashSet<>();
		IntStream.range(1, n + 1).forEach(i -> s.add(i));
		for (int i = 1; i <= n; i++) {
			int possibleNum1 = i+k;
			int possibleNum2 = i-k;
			 if(s.contains(possibleNum2)) {
					result[i-1]=possibleNum2;
					s.remove(possibleNum2);
				}
			 else if (s.contains(possibleNum1)) {
			    result[i-1]=possibleNum1;
			    s.remove(possibleNum1);
			}
			else
			{
				return new int[] {-1};
			}
		}
		return result;
	}
}
