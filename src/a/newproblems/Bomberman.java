package a.newproblems;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bomberman {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(bomberMan(5,new String[] {
				".......", //1
				"...O...", //2
				"....O..", //3
				".......",//4
				"OO.....",//5
				"OO.....",//6
		})));
	}

	// Complete the bomberMan function below.
	static String[] bomberMan(int n, String[] grid) {

		// find initial state where the bombs are put it in the set of Point class with
		// value in that cell. ?
		// have a variable second for counter and loop till n.
		// have a fixed enum where decides action of bomber man every second
		// for second second it is given so we can do n %2 == ENUM value. first step is
		// initialize step and second is wait step and they are non repeating.

		/*
		 * Trick here is to find the active cell after each OBSERVE_BLAST. find which is
		 * the closest second near n that will have blast. find at that closest second
		 * how many blast might have happened ? in that second how many will blast and
		 * which cell will survive ? or after that closest second if there is a PLANT
		 * step is coming which can have state like all active bombs.
		 * 
		 * There is possibility of blast when he is planting the bomb in each cell. so
		 * he should plant them too.
		 * 
		 */
		Set<Point> values = new HashSet<>();
		// step 1 initialize initial values
		initiazePointValues(grid, values);
		int seconds = 3; // first second initialize value and second second wait. so start with third
							// second
		while (seconds <= n) {
			if(seconds==5)
			{
				System.out.println("break point");
			}
			if (seconds % 2 == 0) // only two repeatable steps. at first he plant bomb in each non-active cell.
			{
				plantbombOnInactiveCells(grid, values);

			} else // otherwise wait for bomb to blast.
			{
				detonating(grid,values);
			}
			System.out.println("after "+seconds+" seconds grid is => "+Arrays.toString(grid));
			seconds++;
			values.clear();
		}
		// step three after coming out return grid.
		// now loop through
		return grid;
	}

	private static void detonating(String[] grid,Set<Point> points) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				if (grid[i].charAt(j) == '1') {
					updateGridAfterDetonating(grid, i, j,points);
				} else {
					if (grid[i].charAt(j)!='0' && !points.contains(new Point(i,j))) {
						StringBuilder sb = new StringBuilder(grid[i]);
						int s = sb.charAt(j) - 1;
						sb.setCharAt(j, (char) s);
						grid[i] = sb.toString();
						points.add(new Point(i,j));
					}
				}
			}
		}
	}

	private static void updateGridAfterDetonating(String[] grid, int i, int j,Set<Point> points) {
		// 1 - i
		StringBuilder sb = new StringBuilder(grid[i]);
		sb.setCharAt(j, '0');
		grid[i] = sb.toString();
		points.add(new Point(i,j));
		// 2 - i+1
		if (i + 1 < grid.length) {
			sb = new StringBuilder(grid[i + 1]);
			if(sb.charAt(i+1)!='1')
			{
			sb.setCharAt(j, '0');
			grid[i + 1] = sb.toString();
			points.add(new Point(i+1,j));
			}
		}
		// 3 - i-1
		if ((i - 1) >= 0) {
			sb = new StringBuilder(grid[i - 1]);
			sb.setCharAt(j, '0');
			grid[i - 1] = sb.toString();
			points.add(new Point(i-1,j));
		}
		// 4 - j+1
		if (j + 1 < grid[i].length()) {
			sb = new StringBuilder(grid[i]);
			if(sb.charAt(j+1)!='1')
			{
			sb.setCharAt(j + 1, '0');
			grid[i] = sb.toString();
			points.add(new Point(i,j+1));
			}
		}
		// 5 - j-1
		if ((j - 1) >= 0) {
			sb = new StringBuilder(grid[i]);
			sb.setCharAt(j - 1, '0');
			grid[i] = sb.toString();
			points.add(new Point(i,j-1));
		}
	}

	private static void plantbombOnInactiveCells(String[] grid, Set<Point> points) {
		/*
		 * it should plant bomb on all points where value is . or 1. so in this third
		 * second it was suppose to blast. so blasting and planting happening
		 * simultaneously.
		 */
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				if (grid[i].charAt(j) == '1') {
					updateGridAfterDetonating(grid, i, j,points);
				} else if (grid[i].charAt(j) =='0')
					 {
						StringBuilder sb = new StringBuilder(grid[i]);
						sb.setCharAt(j, '3');
						grid[i] = sb.toString();
						points.add(new Point(i,j));
					 }
				else
				{
					StringBuilder sb = new StringBuilder(grid[i]);
					if(sb.charAt(j)!='0')
					{
					int s = sb.charAt(j) - 1;
					sb.setCharAt(j, (char) s);
					grid[i] = sb.toString();
					points.add(new Point(i,j));
					}
				}
			}
		}
	}

	private static void initiazePointValues(String[] grid, Set<Point> values) {
		for (int i = 0; i < grid.length; i++) {
			StringBuilder sb = new StringBuilder(grid[i]);
			for (int j = 0; j < sb.length(); j++) {
				if (Character.valueOf(sb.charAt(j)).compareTo(Character.valueOf('O'))==0) {
					values.add(new Point(i, j));
					sb.setCharAt(j, '1');
					grid[i] = sb.toString();
				} else {
					values.add(new Point(i, j));
					sb.setCharAt(j, '3');
					grid[i] = sb.toString();
				}
			}
		}
	}
}
