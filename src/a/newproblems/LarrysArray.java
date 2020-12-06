package a.newproblems;

/**
 * num = int(input())
 * 
 * for _ in range(num):
 *  arr_num = int(input())
 *  arr = list(map(int, input().strip().split()))
 *  print("NO") if sum([1 for i in range(len(arr)) for j in range(i+1, len(arr)) if arr[i] > arr[j] ])%2 else print("YES")
 *
 */
/*
 * Inversion: Let us assume that there is an array of length n. 
 * For any index (i < j < n) if there is arr[ i ] > arr[ j ] i.e, 
 * if there is an element which is less than the current element on 
 * its right side, then there is an inversion.
 * 
 * The number of inversions on a particular element = Number of elements 
 * whose values are less than the current element and they are on the 
 * right side on the current element in the array.
 * 
 * Let p(i) = Number of inversions on ith element of an array.
 * 
 * So, the total number of inversions on 
 * complete array = p(0) + p(1) + p(2) + ..... + p(n-1).
 * 
 * you can effectively calculate the number of inversions using Merge Sort,
 *  segment Tree and Fenwick tree etc.
 *  
 *  What is parity? Parity is either even parity or odd parity.
 *  odd parity: A permutation(or set) of numbers is said to have an odd parity 
 *  if the number of inversions on array is odd and similarly for even parity.
 *  why? Because, if there are k number of inversions, then you definitely have 
 *  to swap at least k times in order to get the sorted array. If k is odd, 
 *  then even number of swaps cannot make the array sorted and similarly if k 
 *  is even, then odd number of swaps cannot make the array sorted.
 *  
 *  No matter in which order (or in any way) you swap the elements you will 
 *  always get an odd number of swaps in order to sort the array completely 
 *  if it has odd parity and similarly if there is even parity then, you will 
 *  always get even number of swaps when you sort the array.
 *  
 *  So, in this question, we have to take any 3( let us make it as R) consecutive 
 *  elements and rotate them any number of times and check whether array can be 
 *  sorted or not.
 *  
 *  If you take R consecutive elements and rotate one time, then the number of 
 *  swaps is R-1 (Ex: 3<-2<-1 if you rotate one time it will get 2<-1<-3 i.e, 
 *  you are swapping 3 with 2 and then with 1 i.e, 2 swaps). If you rotate two 
 *  times, it will be 2*(R-1).
 *  
 *  If you rotate n times, then the number of swaps = n*(R-1). hence, the number of 
 *  swaps you are making will always be a multiple of R-1.
 *  
 *  So, in order to check if the array can ever be sorted by rotating R consecutive 
 *  elements until it gets sorted, then the number of inversions should be divisible
 *  by R-1. because the number of inversions is nothing but the number of swaps you 
 *  have to make to get the array sorted. If you can make those many number of swaps
 *  using the multiple of R-1(i.e, by rotating n number of times), then we can say 
 *  that there is a value (v) exists at which our array can be sorted.
 */
public class LarrysArray {
	public static void main(String[] args) {
		// System.out.println(larrysArray(new int[] {1,6,5,2,3,4}));
		// System.out.println(larrysArray(new int[] {3,1,2,4}));
		// System.out.println(larrysArray(new int[] {3,1,2}));
		// System.out.println(larrysArray(new int[] {1,3,4,2}));
		// System.out.println(larrysArray(new int[] {1,2,3,5,4}));

		// test-2
		// System.out.println(larrysArray(new int[] {9,6,8,12,3,7,1,11,10,2,5,4})); //NO
		// System.out.println(larrysArray(new int[]
		// {17,21,2,1,16,9,12,11,6,18,20,7,14,8,19,10,3,4,13,5,15}));//YES
		// System.out.println(larrysArray(new int[]
		// {5,8,13,3,10,4,12,1,2,7,14,6,15,11,9}));//NO
		// System.out.println(larrysArray(new int[]
		// {8,10,6,11,7,1,9,12,3,5,13,4,2}));//YES
		// System.out.println(larrysArray(new int[]
		// {7,9,15,8,10,16,6,14,5,13,17,12,3,11,4,1,18,2}));//NO

		// test-3
		// System.out.println(larrysArray(new int[] {8,10,1,3,6,5,9,2,4,7})); //YES
		// System.out.println(larrysArray(new int[]
		// {17,21,2,1,16,9,12,11,6,18,20,7,14,8,19,10,3,4,13,5,15}));//YES
		// System.out.println(larrysArray(new int[]
		// {5,8,13,3,10,4,12,1,2,7,14,6,15,11,9}));//NO
		// System.out.println(larrysArray(new int[]
		// {8,10,6,11,7,1,9,12,3,5,13,4,2}));//YES
		// System.out.println(larrysArray(new int[]
		// {7,9,15,8,10,16,6,14,5,13,17,12,3,11,4,1,18,2}));//NO

		// test-
		// System.out.println(larrysArray(new int[]
		// {2,1,8,12,10,5,14,3,11,7,6,13,4,9})); //YES
		// System.out.println(larrysArray(new int[] {10,12,6,11,1,7,8,3,9,2,4,5}));//YES
		// System.out.println(larrysArray(new int[]
		// {19,8,22,7,5,13,10,2,16,27,9,1,21,3,23,4,14,15,6,20,18,12,28,25,24,26,17,11}));//YES
		// System.out.println(larrysArray(new int[] {1,9,2,7,6,8,3,5,10,4}));//NO
		// System.out.println(larrysArray(new int[]
		// {14,13,15,7,16,3,9,10,8,2,6,5,1,12,11,4}));//YES
		// System.out.println(larrysArray(new int[]
		// {16,17,23,3,13,8,15,20,2,27,10,6,29,14,24,7,9,21,22,18,12,19,26,1,28,11,25,5,4}));
		// //NO
		System.out.println(larrysArray(new int[] { 9, 8, 10, 7, 3, 5, 2, 11, 4, 6, 1 })); // NO
	}

	// Complete the larrysArray function below.
	static String larrysArray(int[] A) {
		int n = A.length;
		int inversions = 0;
		int k = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				System.out.println("(A[i] "+A[i]+"), (A[j] "+A[j]+")");
				System.out.println("current k is : "+k);
				if (A[i] > A[j]) {
					inversions++;
					k ^= 1;	
					System.out.println("after change (k ^= 1) is : "+k);
				}
				
				else {
					k ^= 0;	
					System.out.println("after change (k ^= 0) is : "+k);
				}
					
			}
		}
		System.out.println("inversions => "+inversions);
		if (k == 1)
			return "YES";
		else
			return "NO";
	}
	
	 // Complete the larrysArray function below.
    static String larrysArray2(int[] A) {
        int ret = 0;
        for(int i = 0; i < A.length; ++i) {
            for(int j = i + 1; j < A.length; ++j) {
                ret += A[i] > A[j] ? 1 : 0;
                ret %= 2;
            }
        }
        return ret == 0 ? "YES" : "NO";

    }
    
    public static void rotate(int[] arr, int a){
        int temp = arr[a];
        arr[a] = arr[a+1];
        arr[a+1] = arr[a+2];
        arr[a+2] = temp;
    }

// Complete the larrysArray function below.
static String larrysArray3(int[] ar) {
    for(int i = 0; i < ar.length; i++){
        for(int j = ar.length-3; j >=i; j--){
            while(ar[j] > ar[j+1] || ar[j] > ar[j+2]){
                rotate(ar,j);
            }
        }
    }
    return ar[ar.length-2] < ar[ar.length-1]? "YES" : "NO";

}
}
