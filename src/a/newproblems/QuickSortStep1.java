package a.newproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortStep1 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(quickSort(new int[] { 4, 5, 3, 7, 2 })));
	}

// Complete the quickSort function below.
	static int[] quickSort(int[] arr) {
		int pivot = arr[0];
		int[] temp = new int[arr.length];
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		List<Integer> equal = new ArrayList<>();
		equal.add(pivot);
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]<pivot)left.add(arr[i]);
			else if(arr[i]==pivot)equal.add(arr[i]);
			else right.add(arr[i]);
		}
		int count =0;
		for (Integer l : left) {
			temp[count]=l;
			count++;
		}
		for (Integer e : equal) {
			temp[count]=e;
			count++;
		}
		for (Integer r : right) {
			temp[count]=r;
			count++;
		}
		return temp;
	}
}
