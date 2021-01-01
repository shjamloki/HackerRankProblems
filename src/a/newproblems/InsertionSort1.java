package a.newproblems;

public class InsertionSort1 {
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
		
		insertionSort1(10,arr1);
	}

//Complete the insertionSort1 function below.
	static void insertionSort1(int n, int[] arr) {
		/**
		 * 	2 4 6 8 8 
			2 4 6 6 8 
			2 4 4 6 8 
			2 3 4 6 8 
		 */
		int val = arr[n-1];
		boolean isDone=false;
        for(int i = n-1; i-1 >= 0;i--)// i =4,3,2,1
        {
            if(arr[i-1]>val) //8>3 -y,6>3 -y,4>3 -y,2>3 -n
            {
                arr[i]=arr[i-1];//a[4] = 8,a[2]=6,a[1]=4
            }
            else //2>3
            {
              arr[i]= val;//a[1]=3
              isDone = true;
            }
            for (int j : arr) {
                System.out.print(j+" ");
            }
            System.out.println();
            if(isDone) break;
        }  
        if(!isDone) {
        	arr[0]=val;
        	for (int j : arr) {
                System.out.print(j+" ");
            }
        }
	}
}
