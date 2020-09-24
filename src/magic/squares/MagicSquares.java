package magic.squares;

import java.util.Arrays;

/**
 * This program generates magic squares.
 * create magic squares like :
 * 
 * Mirror images:
 * 4 9 2 | 2 9 4
 * 3 5 7 | 7 5 3
 * 8 1 6 | 6 1 8
 * -------------
 * 8 1 6 | 6 1 8
 * 3 5 7 | 7 5 3
 * 4 9 2 | 2 9 4
 * Rotations:
 * 8 3 4 | 4 3 8
 * 1 5 9 | 9 5 1
 * 6 7 2 | 2 7 6
 * -------------
 * 6 7 2 | 2 7 6
 * 1 5 9 | 9 5 1
 * 8 3 4 | 4 3 8
 *
 */
public class MagicSquares {
	static int formingMagicSquare(int[][] arr) {

	    int n = arr.length, start = 1;
	    int[] cost = {0, 0, 0, 0, 0, 0, 0, 0};
	    int[][] magicSquare = buildMagicSquare(n, start);
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n && n==arr[i].length; j++) {
	            if(arr[i][j]>=1 && arr[i][j]<=n*n) {
	                cost[0]+=Math.abs(arr[i][j] - magicSquare[i][j]);
	                cost[1]+=Math.abs(arr[i][j] - magicSquare[i][n-1-j]);
	                cost[2]+=Math.abs(arr[i][j] - magicSquare[j][i]);
	                cost[3]+=Math.abs(arr[i][j] - magicSquare[j][n-1-i]);
	                cost[4]+=Math.abs(arr[i][j] - magicSquare[n-1-i][j]);
	                cost[5]+=Math.abs(arr[i][j] - magicSquare[n-1-i][n-1-j]);
	                cost[6]+=Math.abs(arr[i][j] - magicSquare[n-1-j][i]);
	                cost[7]+=Math.abs(arr[i][j] - magicSquare[n-1-j][n-1-i]);
	            }
	        }
	    }

	    return Arrays.stream(cost).min().getAsInt();
	}

	public static int[][] buildMagicSquare(int n, int start){
	    int[][] arr = new int[n][n];
	    int x = 0, y = n / 2;
	    for (int i = start, j=0; j < n * n; i++, j++) {
	        arr[x--][y++] = i;
	        if (x < 0 && y >= n) {
	            x += 2;
	            y--;
	        } else if (x < 0) {
	            x = n - 1;
	        } else if (y >= n) {
	            y = 0;
	        }
	        if (arr[x][y] > 0) {
	            x += 2;
	            y--;
	        }
	    }
	    return arr;
	}
	public static void main(String[] args) {
		int [][] s = new int [][] {{5,3,4},{1,5,8},{6,4,2}};
		System.out.println(formingMagicSquare(s));
	}
}
