package a.newproblems;

import java.util.Collections;

public class InsertionSort2 {
	public static void main(String[] args) {
		int []arr = new int[] {
				2,4,8,12,15,19,21,24,26,29,30,32,35,
				36,41,44,49,52,57,58,59,64,65,68,73,
				77,80,82,85,88,93,97,101,105,108,111,
				115,118,122,127,130,131,132,134,135,
				136,138,141,144,146,151,153,158,160,
				165,169,171,176,179,184,187,190,194,
				197,200,205,210,215,217,222,225,230,
				231,236,239,243,244,246,248,253,254,
				256,258,262,263,267,272,274,277,280,
				284,285,289,291,295,297,301,305,310,
				312,279};
		int []arr1 = new int[] {2,3,4,5,6,7,8,9,10,1};
		int [] arr2 = new int[] {1,4,3,5,6,2};
		int [] arr3 = new int[] {3,4,7,5,6,2,1};
		insertionSortPart2(arr2);
	}
	
	public static void insertionSortPart2(int[] array) {
	    for (int i = 1; i < array.length; i++) {
	        int j = i;
	        int value = array[i];
	        while (j >= 1 && array[j-1] > value) {
	            array[j] = array[j-1];
	            j--;
	        }
	        array[j] = value;
	        for (int t : array) {
                System.out.print(t+" ");
            }
	        System.out.println();
	    }
	}

//Complete the insertionSort1 function below.
	static void insertionSort2(int n, int[] arr) {
		/**
		 * 1 4 3 5 6 2 
		   1 3 4 5 6 2 
		   1 3 4 5 6 2 
		   1 3 4 5 6 2 
		   1 2 3 4 5 6 
			
		 */
		for(int i=1;i<arr.length;i++)
		{
			int loc=i;
			int val = arr[i];
			for(int j=0;j<i;j++)
			{
				if(arr[i]<arr[j])
				{
					loc =j;
					break;
				}
			}
			if(loc !=i)
			{
				int temp=0;
				for(int k =loc;k<i;k++)
				{
					if(temp ==0)
					{
					temp=arr[k+1];
					arr[k+1]=arr[k];
					}
					else {
						int temp2 = arr[k+1];
						arr[k+1]=temp;
						temp = temp2;
					}
					if(k+1==i) {
						arr[loc]=val;
					}
				}
			}
			 for (int j : arr) {
	                System.out.print(j+" ");
	            }
	            System.out.println();
	   }
	}
}
