package a.newproblems;

import java.util.Arrays;
import java.util.Collections;

public class LeftRotateArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotLeft(new int[] {1,2,3,4,5}, 5)));
		//2,3,4,5,1  --->3,4,5,1,2
	}
	
	 // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
     int b[] = new int[a.length];
     for(int i =0;i<a.length;i++)
     {
    	 int newLocation = (i + (a.length - d)) % a.length;
    	 b[newLocation]=a[i]; 
     }
     return b;
    }
}
