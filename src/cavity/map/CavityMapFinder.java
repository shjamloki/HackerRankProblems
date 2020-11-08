package cavity.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * def cavityMap(n, grid):
 *    for i in range(1,n-1):
 *         for j in range(1,n-1):
 *               if grid[i][j] > max(grid[i-1][j],grid[i+1][j],grid[i][j-1],grid[i][j+1]):
 *                    grid[i] = grid[i][:j] +'X' + grid[i][j+1:]
 *                                  
 *     return grid
 *
 */
public class CavityMapFinder {
	public static void main(String[] args) throws IOException {
		System.out.println(Arrays.toString(cavityMap(
				new String[] {
						"1112",
						"1912",
						"1892",
						"1234"}))); 
		//String [] test= new String[100];
		//Files.readAllLines(new File("/Users/sjamloki/Downloads/input.txt").toPath()).toArray(test);
		//System.out.println(Arrays.toString(cavityMap(test)));
	}
	// Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
    	
    	List<String> cells = new ArrayList<>();
    	for(int i=1;i<grid.length-1;i++)
    	{
    		for(int k=1;k<grid[i].length()-1;k++)
    		{
    			int currentCellValue = Integer.parseInt(grid[i].charAt(k)+"");
    			int upperCellValue = Integer.parseInt(grid[i-1].charAt(k)+"");
    			int lowerCellValue = Integer.parseInt(grid[i+1].charAt(k)+"");
    			int leftCellValue = Integer.parseInt(grid[i].charAt(k-1)+"");
    			int rightCellValue = Integer.parseInt(grid[i].charAt(k+1)+"");
    			if(currentCellValue > upperCellValue &&
    					currentCellValue > lowerCellValue &&
    					currentCellValue > leftCellValue &&
    					currentCellValue > rightCellValue)
    			{
    				cells.add(i+","+k);
    				//grid[i]=grid[i].replace(grid[i].charAt(k),'X');
    			}
    		}
    	}
    	cells.stream().forEach(i->{
    		int gridIndex = Integer.parseInt(i.split(",")[0]);
    		int charIndex = Integer.parseInt(i.split(",")[1]);
    		StringBuilder sb = new StringBuilder(grid[gridIndex]);
    		sb.setCharAt(charIndex,'X');
    		grid[gridIndex] = sb.toString();
    	});
    	return grid;
    }
}
