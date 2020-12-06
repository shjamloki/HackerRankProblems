package a.newproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class Bomberman2 {
	
	public static void main(String[] args) {
		char[][] result = bomberMan(11,new char[][] {
				".......".toCharArray(), //1
				"...O...".toCharArray(), //2
				"....O..".toCharArray(), //3
				".......".toCharArray(),//4
				"OO.....".toCharArray(),//5
				"OO.....".toCharArray(),//6
		});
		
		for (int i = 0; i < result.length; i++) {
	        for(int j=0;j<result[0].length;j++){
	            System.out.print(result[i][j]);
	        }
	        System.out.println();
		}
	}

	// Complete the bomberMan function below.
	static char[][] bomberMan(int n, char[][] grid) {
	    if(n==1){
	        return grid;
	    }
	    if(n%2==0){ //n%4==2 or n%4==0
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                grid[i][j] = 'O';
	            }
	        }
	        return grid;
	    }
	    if(n%4==3) return explode(grid);
	    return explode(explode(grid));  //if(n%4==1)
	}

	static char[][] explode(char[][] grid){
	    ArrayList<int[]> bombs = new ArrayList<int[]>();
	    for(int i=0;i<grid.length;i++){
	        for(int j=0;j<grid[0].length;j++){
	            if(grid[i][j]=='O'){
	                int[] a = {i,j};
	                bombs.add(a);
	            }
	        }
	    }
	    for(int i=0;i<grid.length;i++) Arrays.fill(grid[i],'O');
	    for(int[] i:bombs){
	        grid[i[0]][i[1]] = '.';
	        try{
	            grid[i[0]+1][i[1]] = '.';
	        }catch(ArrayIndexOutOfBoundsException e){ }
	        try{
	            grid[i[0]-1][i[1]] = '.';
	        }catch(ArrayIndexOutOfBoundsException e){ }
	        try{
	            grid[i[0]][i[1]+1] = '.';
	        }catch(ArrayIndexOutOfBoundsException e){ }
	        try{
	            grid[i[0]][i[1]-1] = '.';
	        }catch(ArrayIndexOutOfBoundsException e){ }
	    }
	    return grid;
	}

}
