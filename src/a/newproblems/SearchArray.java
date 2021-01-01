package a.newproblems;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * def introTutorial(V, arr):
 *  return arr.index(V)
 *
 */
public class SearchArray {
public static void main(String[] args) {
	System.out.println(searchArray(5,new int[] {1,2,3,4,5}));
}
//Complete the introTutorial function below.
//we will always get sorted array.
static int searchArray(int V, int[] arr) {
 OptionalInt o =IntStream.range(0,arr.length).filter(i->arr[i]==V).findFirst();
 if(o.isPresent())
 {
	 return o.getAsInt();
 }
 else
	 return -1;
}

//Complete the introTutorial function below.
static int searchArray2(int V, int[] arr) {
	return Arrays.binarySearch(arr,V);
}
//Complete the introTutorial function below.
static int searchArray3(int V, int[] arr) {
	int left=0;
	int right = arr.length;
	int median, index=0;
	while(left<=right)
    {
        median = (left+right)/2;
        if(arr[median]==V)
        {
            index=median;
            break;
        }
        else if(arr[median]<V)
            left = median + 1;
        else
            right = median - 1;
    }
    return index;
}
}
