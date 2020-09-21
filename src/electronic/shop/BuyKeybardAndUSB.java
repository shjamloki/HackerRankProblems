package electronic.shop;

import java.util.Arrays;
import java.util.Collections;

public class BuyKeybardAndUSB {

	public static void main(String[] args) {
		//int [] keyboards = new int[] {3,1,5}; //1,3,5
		//int [] drives = new int[] {5,2,8}; //2,5,8
		int [] keyboards = new int[] {3,1}; //1,3
		int [] drives = new int[] {5,2,8}; //2,5,8
		System.out.println(getMoneySpent(keyboards, drives, 10));
	}
	/*
	 * Complete the getMoneySpent function below.
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		/*
		 * Write your code here.
		 */
		Arrays.sort(keyboards);// traverse in desc order order
		Arrays.sort(drives);//Ascending order
        
        int max = -1;
        for(int i = 0, j = 0; i < keyboards.length; i++){
            for(j = drives.length-1; j>=0; j--){
                if(keyboards[i]+drives[j] > b) break; //This prevents j from incrementing
                if(keyboards[i]+drives[j] > max)
                    max = keyboards[i]+drives[j];
            }
        }
       return max;
		//1st attempt
		/*
		 * int fircomb =-1; // boolean isFound=false; Arrays.sort(keyboards);
		 * Arrays.sort(drives); for(int i = keyboards.length-1;i>=0;i--) { for(int
		 * j=drives.length-1;j>=0;j--) {
		 * //System.out.println("b is ->"+b+" sum is : "+(keyboards[i]+drives[j])
		 * +" i is ->"+i+" j is "+j); int thisNum = keyboards[i]+drives[j];
		 * if(thisNum<=b && thisNum > fircomb ) { fircomb = thisNum; } } } return
		 * fircomb;
		 */
	}
}
