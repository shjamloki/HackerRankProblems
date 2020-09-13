import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountMaxValue {

	public static void main(String[] args) {
		int a [] = {1,2,3,4,4};
		System.out.println(countMax(a));
	}

	static int countMax(int[] a) {
		
		  int [][] ar = {{1,2},{1,2}};
		    int n[] = {0};
		    int k[] = {0};
		    Arrays
	        .stream(ar)
	        .flatMapToInt(x -> Arrays.stream(x))
	        .filter(i -> n[0]++ % 2 == 0)
	        .filter(i -> k[0]++ % 2 == 0)
	        .forEach(t->System.out.println());
		    
	    return Arrays.stream(a)
	                 .boxed()
	                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	                 .entrySet()
	                 .stream()
	                 .max(Map.Entry.comparingByKey())
	                 .map(Map.Entry::getValue)
	                 .orElse(0L)
	                 .intValue();
	    
	    
	  
}
}
