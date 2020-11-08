package grid.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GridSearch2 {
	public static void main(String[] args) {
		String [] grid2 = new String[] {
				"8,8,8,1,2",
				"3,8,8,4,5",
				"6,8,8,7,8",
				"9,8,8,8,8",
				"8,8,8,8,8"
		};
		String search2[] = new String[] {
				"1,2,3",
				"4,5,6",
				"7,8,9"
		};
		System.out.println(gridSearch(grid2,search2));
	}
	

	static String gridSearch(String[] G, String[] P) {
        for (int row = 0; row <= G.length - P.length; row++) {
                List<Integer> list = findIndices(G[row], P[0]);
                if (list.isEmpty()) continue;
                for (int index: list) {
                        if (checkPresenceAt(G, P, row, index)) return "YES";
                }
        }
        return "NO";
}

private static List<Integer> findIndices(String source, String toFind) {
        int index = 0;
        List<Integer> result = new ArrayList<>();
        while (index < source.length()) {
                int a = source.indexOf(toFind, index);
                if (a > -1) {
                        result.add(a);
                        index = a + 1;
                }
                else break; 
        }
        return result;
}

private static boolean checkPresenceAt(String[] G, String[] P, int startrow, int index) {
        return IntStream.range(startrow, startrow + P.length)
                .boxed()
                .allMatch(i -> G[i].indexOf(P[i - startrow], index) == index)
        ;
}
}
