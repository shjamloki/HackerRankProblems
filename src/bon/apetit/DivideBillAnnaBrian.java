package bon.apetit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DivideBillAnnaBrian {
	// Complete the bonAppetit function below.
	static void bonAppetit(List<Integer> bill, int k, int b) {
		int sum [] = new int[] {0};
		IntStream.range(0,bill.size()).forEach(i-> {
			if(i!=k) 
			{
				sum[0] +=bill.get(i);
			};
		});
		int diff = b - (sum[0]/2);
		if( diff != 0)
		{
			System.out.println(diff);
		}
		else
		{
			System.out.println("Bon Appetit");
		}
	}

	public static void main(String[] args) {
		Integer [] itemList = new Integer[] {72,53,60,66,90,62,12,31,36,94};
		bonAppetit(Arrays.asList(itemList), 6, 288);
	}
}
