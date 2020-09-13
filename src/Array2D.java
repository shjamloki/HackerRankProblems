import java.util.ArrayList;
import java.util.Arrays;

public class Array2D {

	
	public static void main(String[] args) {
		int [] [] arr = {{10,20},{30,40}};
		
		ArrayList<int [][]> rowsData = new ArrayList<>();
		int[] n = {0};
		int [] k = {0};
		
		
		//set before image of pkcol : 
		Arrays.stream(arr).flatMapToInt(x ->Arrays.stream(x)).filter(i->n[0]++ % 2==0).filter(i->k[0]++ % 2==0).forEach(t -> {
			System.out.println("setting before image for pkcol = "+t);
		});

		//set after image of pkcol : 
		Arrays.stream(arr).flatMapToInt(x ->Arrays.stream(x)).filter(i->n[0]++ % 2==0).filter(i->k[0]++ % 2==0).forEach(t -> {
			System.out.println("setting after image for pkcol = "+t);
		});

		//set before image of intcol : 
		Arrays.stream(arr).flatMapToInt(x ->Arrays.stream(x)).filter(i->n[0]++ % 2==0).filter(i->k[0]++ % 2==0).forEach(t -> {
			System.out.println("setting before image for intcol = "+t);
		});

		//set after  image of intcol : 
		Arrays.stream(arr).flatMapToInt(x ->Arrays.stream(x)).filter(i->n[0]++ % 2==0).filter(i->k[0]++ % 2==0).forEach(t -> {
			System.out.println("setting after image for intcol = "+t);
		});
		
		
	/*	Arrays.stream(arr).flatMapToInt(x ->Arrays.stream(x)).filter(i->n[0]++ % 2==0).forEach(t->{
			// update before image
			if(k[0]++ %2 ==0)
			{
				System.out.println("setting before image for pkcol = "+t);
			}
			else 
			{
				System.out.println("setting after  image for pkcol = "+t);
			}
		});
		
		k[0]=0;
		
		Arrays.stream(arr).flatMapToInt(x ->Arrays.stream(x)).filter(i->n[0]++ % 2==1).forEach(t->{
			//update after image
			if(k[0]++ %2 ==0)
			{
				System.out.println("setting before image for intcol = "+t);
			}
			else 
			{
				System.out.println("setting after  image for intcol = "+t);
			}
		}); */
		
	
		/*
		 * Arrays.stream(arr).flatMapToInt(x ->
		 * Arrays.stream(x)).filter(i->i%2==0).forEach(t->{
		 * System.out.println("  ty ->"+t); });
		 */}
}
