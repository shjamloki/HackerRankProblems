package equalise.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EqualiseArray {
	
	// Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
    	long result = Arrays.stream(arr)
    	           .boxed()
    	           .collect(Collectors.groupingBy(i->i,Collectors.counting()))
    	           .values()
    	           .stream()
    	           .max(Comparator.comparingLong(i->i))
    	           .orElseThrow(RuntimeException::new);
    	
    	return (int) (arr.length - result); 
    	/*int len = arr.length;
		int aux[] = new int[101];
		for (int i = 0; i < len; i++) {
			int index = arr[i];
			aux[index]++;
		}

		int maxFreqCount = getMaxFreqCount(aux);
		return len - maxFreqCount; */
	}
    
    private static int getMaxFreqCount(int[] aux) {
		int maxFreqCount = Integer.MIN_VALUE;
		for (int freqCount : aux) {
			if (freqCount > maxFreqCount) {
				maxFreqCount = freqCount;
			}
		}
		return maxFreqCount;
	}
	
public static void main(String[] args) {
	int[] i = new int [] {
			//total - 78
			//24 -11, 29-6,70-12,43-15,12-5,27 -10,41-7,100-5,59-5,62-3
			24,29,70,43,12,27,29,24,41,12,41,43,24,70,24,100,41,43,43,100,
			29,70,100,43,41,27,70,70,59,41,24,24,29,43,24,27,70,24,27,70,
			24,70,27,24,43,27,100,41,12,70,43,70,62,12,59,29,62,41,100,43,
			43,59,59,70,12,27,43,43,27,27,27,24,43,43,62,43,70,29};
	System.out.println(equalizeArray(i));
	
}
}
