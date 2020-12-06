package a.newproblems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LarryArrayMine {
	public static void main(String[] args) {
		//System.out.println(larrysArray(new int[] {1,6,5,2,3,4}));
		//System.out.println(larrysArray(new int[] {3,1,2,4}));
		//System.out.println(larrysArray(new int[] {3,1,2}));
		//System.out.println(larrysArray(new int[] {1,3,4,2}));
		//System.out.println(larrysArray(new int[] {1,2,3,5,4}));
		
		//test-2
		//System.out.println(larrysArray(new int[] {9,6,8,12,3,7,1,11,10,2,5,4})); //NO
		//System.out.println(larrysArray(new int[] {17,21,2,1,16,9,12,11,6,18,20,7,14,8,19,10,3,4,13,5,15}));//YES
		//System.out.println(larrysArray(new int[] {5,8,13,3,10,4,12,1,2,7,14,6,15,11,9}));//NO
		//System.out.println(larrysArray(new int[] {8,10,6,11,7,1,9,12,3,5,13,4,2}));//YES
		//System.out.println(larrysArray(new int[] {7,9,15,8,10,16,6,14,5,13,17,12,3,11,4,1,18,2}));//NO
	
		//test-3
		//System.out.println(larrysArray(new int[] {8,10,1,3,6,5,9,2,4,7})); //YES
		//System.out.println(larrysArray(new int[] {17,21,2,1,16,9,12,11,6,18,20,7,14,8,19,10,3,4,13,5,15}));//YES
		//System.out.println(larrysArray(new int[] {5,8,13,3,10,4,12,1,2,7,14,6,15,11,9}));//NO
		//System.out.println(larrysArray(new int[] {8,10,6,11,7,1,9,12,3,5,13,4,2}));//YES
		//System.out.println(larrysArray(new int[] {7,9,15,8,10,16,6,14,5,13,17,12,3,11,4,1,18,2}));//NO
	
		//test-
		//System.out.println(larrysArray(new int[] {2,1,8,12,10,5,14,3,11,7,6,13,4,9})); //YES
		//System.out.println(larrysArray(new int[] {10,12,6,11,1,7,8,3,9,2,4,5}));//YES
		//System.out.println(larrysArray(new int[] {19,8,22,7,5,13,10,2,16,27,9,1,21,3,23,4,14,15,6,20,18,12,28,25,24,26,17,11}));//YES
		//System.out.println(larrysArray(new int[] {1,9,2,7,6,8,3,5,10,4}));//NO
		//System.out.println(larrysArray(new int[] {14,13,15,7,16,3,9,10,8,2,6,5,1,12,11,4}));//YES
		//System.out.println(larrysArray(new int[] {16,17,23,3,13,8,15,20,2,27,10,6,29,14,24,7,9,21,22,18,12,19,26,1,28,11,25,5,4})); //NO
		System.out.println(larrysArray(new int[] {9,8,10,7,3,5,2,11,4,6,1})); //NO
	}
	
	

//Complete the larrysArray function below.
	static String larrysArray(int[] A) {
		for(int i=0;i<A.length;i++)
		{
			int smallestItem = findAndRotateTriplet(i, A);
			if(smallestItem==-1) {
				System.out.println(Arrays.toString(A));
				return "NO";
			}
		}
		return "YES";
	}

	static int findAndRotateTriplet(int i, int[] A) {
		int smallestItem;
		do {
		int smallestItemIndex = findSmallestNumberIndex(A, i);
		smallestItem = A[smallestItemIndex];
		if (i == smallestItemIndex)
			return smallestItem;
		int tripletStartIndex = findTripletStartIndex(A, i, smallestItemIndex);
		if (tripletStartIndex == -1)
			return tripletStartIndex;
		do {
			int val =rotateTriplet(A, tripletStartIndex);
			if(val == -1) return -1;
		} while (isItemNotCorrectlySorted(A, smallestItem, tripletStartIndex));
		}while(A[i]!=smallestItem);
		return smallestItem;
	}
	static int findSmallestNumberIndex(int[] A,int startIndex) {
		return IntStream.range(startIndex,A.length)
	            .reduce((i,j) -> A[i] > A[j] ? j : i)
	            .getAsInt();
	}

	static int findTripletStartIndex(int[] A,int alreadySortedIndex,int smallestItemIndex) {
	    int diff = Math.abs(alreadySortedIndex-smallestItemIndex);
	    if(diff>=2)
	    {
	    	if(smallestItemIndex-2 >=0)
	    	return smallestItemIndex-2;
	    	else return -1;
	    }
	    else
	    {
	    	int compare = smallestItemIndex-diff;
	    	if(diff >=0 && diff <=2 && compare > alreadySortedIndex-1)
	    	{
	    		return compare;
	    	}
		    else return -1;
	    }
	  }

	static int rotateTriplet(int[] A, int rotationStartIndex) {
		int i, temp; 
        temp = A[rotationStartIndex]; 
        if(rotationStartIndex+2 > A.length-1)
        {
          return -1;	
        }
        for (i = rotationStartIndex; i < rotationStartIndex+2; i++) 
        {
            A[i] = A[i + 1]; 
        }
           A[i] = temp; 
           return 0;
      }
    static boolean isItemNotCorrectlySorted(int[] A,int smallestItem,int expectedIndex)
    {
    	return A[expectedIndex] !=smallestItem;
    }
	
}
