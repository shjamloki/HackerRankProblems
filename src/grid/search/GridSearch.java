package grid.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * def gridSearch(G, P):
    h = len(P)
    w = len(P[0])
    for i,row in enumerate(G[:-h+1]):
        for j,col in enumerate(row[:-w+1]):
            if col == P[0][0]:
                if [G[k][j:j+w] for k in range(i, i+h)] == P:
                    return "YES"
    else:
        return "NO"
 *
 */
public class GridSearch {
	public static void main(String[] args) {
		/*String[] grid = new String[] { "7283455864", "6731158619", "8988242643", "3830589324", "2229505813",
				"5633845374", "6473530293", "7053106601", "0834282956", "4607924137"

		};
		
		//scenarios1 =1. normal scenario it is found and every row have only one such pattern.
		//scenario 2 = no pattern found.
		//scenario 3= found at 0 place.
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
		String[] search = new String[] { "9505", "3845", "3530" };*/
		List<String> lines =null;;
		try {
			lines = Files.readAllLines(new File("./resources/gridResourceTest.txt").toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int gridSize = Integer.parseInt(lines.get(0).split(" ")[0]);
		lines.remove(0);
		String[] grid = new String[gridSize];
		String [] search = null;
		int count =0;
		int searchIndex = 0;
		for (String string : lines) {
			if(count == gridSize)
			{
				int searchSize = Integer.parseInt(string.split(" ")[0]);
				search = new String[searchSize];
				count++;
			}
			else if(count > gridSize)
			{
				search[searchIndex]=string;
				searchIndex++;
				count++;
			}
			else
			{
			grid[count]=string;
			count++;
			}
			
		}
		System.out.println(gridSearch2(grid, search));
	}
	
	static String myGridSearch(String[] G,String[] P)
	{
		for(int i =0;i<G.length; i++)
		{
			List<Integer> indexes = findIndices(G[i],P[0]);
			if(indexes.isEmpty())continue;
			for (Integer index : indexes) {
				if(checkPresence(G,P,i,index))return "YES";
			}
		}
		return "NO";
	}
	

	private static boolean checkPresence(String[] g, String[] p, int start, Integer index) {
		return IntStream.range(start,start+p.length)
				.boxed()
				.allMatch(i -> g[i].indexOf(p[i - start], index) == index);
	}

	private static List<Integer> findIndices(String gridStr, String searchStr) {
		String str = gridStr;
		List<Integer> indecies = new ArrayList<Integer>();
		while (str.indexOf(searchStr)>0) {
			int index = str.indexOf(searchStr);
			indecies.add(index);
			str.substring(index);
		}
		return indecies;
	}

	static String gridSearch2(String[] g, String[] p) 
    {
        for(int i=0;i<=(g.length-p.length);i++)
        {
            for(int j=0;j<=(g[0].length()-p[0].length());j++)
            {
                int a=i;
                int c=0;
                if(g[i].substring(j,j+p[0].length()).equals(p[0]))
                {
                    c++;
                    for(int k=1;k<p.length;k++)
                    {
                        i++;   
                        if(g[i].substring(j,j+p[0].length()).equals(p[k]))c++;
                        else break;
                         
                    }
                    if(c==p.length)return "YES";
                }
                i=a;
            }
        }
        return "NO";
    }
}
