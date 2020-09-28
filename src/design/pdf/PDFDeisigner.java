package design.pdf;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 
 * python 3: 
 * max([h[ord(c)-97] for c in word])*len(word)
 * python 2: 
 * size = [int(i) for i in input().split()] 
 * word = [size[ord(c)-ord('a')] for c in input()]
 * print(max(word)*len(word))
 *
 */
public class PDFDeisigner {
	// Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
    	Map<Character,Integer> mapHeight = new HashMap<>();
    	IntStream.range(0,h.length).forEach(i->{
    		mapHeight.put(new Character((char)(97+i)), h[i]);
    	});
    	int maxHt = 0;
    	for (char ch : word.toCharArray()) {
			if (mapHeight.get(ch) > maxHt)
			{
				maxHt = mapHeight.get(ch);
			}
		}
    	return maxHt * word.length();
    }
public static void main(String[] args) {
	int [] h = new int[] {1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
	System.out.println(designerPdfViewer(h,"abc"));
}
}
