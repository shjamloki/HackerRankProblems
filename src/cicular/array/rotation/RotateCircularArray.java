package cicular.array.rotation;

import java.util.Arrays;

/***
 * python 3
 * 
 * return map(lambda x: a[x-k % len(a)], queries)
 * 
 * python dequeue
 * 
 * from collections import deque
 * # Complete the circularArrayRotation function below.
 * def circularArrayRotation(a, k, queries):
 *  dq = deque(a, len(a))
 *  dq.rotate(k)
 *  return [dq[num] for num in queries]
 *
 *
 *def circularArrayRotation(a, k, queries):
 *  a = a[-k:] + a[:-k]
 *    return [a[i] for i in queries]
 */
public class RotateCircularArray {
	public static void main(String[] args) {
		/* Scanner in = new Scanner(System.in);
		    int n, k ,q;
		    n = in.nextInt();
		    k = in.nextInt();
		    q = in.nextInt();

		    int[] arr = new int[n];
		    for(int i=0; i<n; i++) {
		        arr[(i+k)%n] = in.nextInt();
		    }
		    for(int i=0; i<q; i++) {
		        System.out.println(arr[in.nextInt()]);
		    }	*/
		System.out.println(Arrays.toString(circularArrayRotation(new int[] {1,2,3}, 2,new int[] {2})));
	}
	
	 static int[] circularArrayRotation(int[] a, int k, int[] queries) {

         int arr[] = new int[a.length];
						
         for(int i=0 ; i<a.length ; i++)
             arr[(i+k)%a.length] = a[i];
								
         for(int i=0 ; i<queries.length ; i++)
             queries[i] = arr[queries[i]];
								
         return queries;    

 }

}
