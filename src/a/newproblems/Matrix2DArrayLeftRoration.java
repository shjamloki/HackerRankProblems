package a.newproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Matrix2DArrayLeftRoration {

	/**
	 * 
     * 1 -Think queues. They can be your friend.
     * 2- Work on one layer at a time. Knowing it's length and offset 
     * from the matrix edge is necessary.
     * 3 -Consider if you must really rotate all of R. Think of a circle
     *  and is there any difference between rotating the circle 360-degrees 
     *  or 720-degrees? What does it mean to rotate a 6x6 with r=1000000, for instance?
     * 4 -Do you have to iterate through all cells on a layer when rotating?
     *  Is there anyway the symmetry of a layer can help cut your loops in half?
     * 5 - Watch your variables. It’s easy to be off by 1 or some other mistake 
     * when calculating the from/to coordinates.

	 */
	public static void main(String[] args) {
		List<Integer> line1 = new ArrayList<>();
		List<Integer> line2 = new ArrayList<>();
		List<Integer> line3 = new ArrayList<>();
		List<Integer> line4 = new ArrayList<>();
		List<List<Integer>> matrix = new ArrayList<>();
		line1.add(1);line1.add(2);line1.add(3);line1.add(4);
		line2.add(5);line2.add(6);line2.add(7);line2.add(8);
		line3.add(9);line3.add(10);line3.add(11);line3.add(12);
		line4.add(13);line4.add(14);line4.add(15);line4.add(16);
		matrix.add(line1);matrix.add(line2);matrix.add(line3);matrix.add(line4);
		matrixRotation(matrix, 1);
	}
	
	static void matrixRotation2(List<List<Integer>> matrix, int r) {
        int[][] arr=new int[matrix.size()][matrix.get(0).size()];
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                arr[i][j]=matrix.get(i).get(j);
            }
        }
        int rows=arr.length;
        int cols=arr[0].length;
        int layers=(int)Math.min(rows,cols)/2;
        int x=0;
        int s=r;
        int y=cols-1;
        int z=rows-1;
    for(int q=0;q<layers;q++){
        int v=(rows+cols-2)*2-8*q;
        int rot=s%v;
        while(rot>0){
            rot--;
            int p=arr[x][x];
  
            for(int j=x;j<y;j++){
                arr[x][j]=arr[x][j+1];             
            }
            for(int i=x;i<z;i++){
                arr[i][y]=arr[i+1][y];
            }
            for(int j=y;j>x;j--){
                arr[z][j]=arr[z][j-1];
            }
            for(int i=z;i>x+1;i--){
                arr[i][x]=arr[i-1][x];
            }
            arr[x+1][x]=p;
    }
    x++;y--;z--;
    s=r;
    }
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
    }
	
	// Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
    	int layer = Math.min(matrix.size(),matrix.get(0).size())/2;
    	for(int i=0;i< layer;i++)
    	{
    			rotate(i,matrix,r);
    	}

    }
	private static void rotate(int i, List<List<Integer>> matrix,int distance) {
	// (i,i) -->(i,n-i-1) --> (n-i-1,n-i-1,1) --> (n-i-1,i) -->i,i)
		int n = matrix.size();
		Queue<String> test = new LinkedList<>();
		for (int j=i;j<n-i;j++)
		{
			test.add(""+i+","+j+" >"+matrix.get(i).get(j));
		}
		for(int j=i+1;j<n-i;j++) {
			test.add(""+j+","+(n-i-1)+" >"+matrix.get(j).get(n-i-1));
		}
		for(int j=n-i-2;j>=i;j--) {
			test.add(""+(n-i-1)+","+j+" >"+matrix.get(n-i-1).get(j));
		}
		for(int j=n-i-2;j>i;j--) {
			test.add(""+j+","+i+" >"+matrix.get(j).get(i));
		}
		System.out.println(test);
		//Collections.rotate(test, -distance);
		System.out.println("after rotate -> "+test);
		System.out.println("----------");
		for (String val : test) {
			String []token = val.split(">");
			System.out.print(Arrays.toString(val.split(">")));
			String []indexes = token[0].split(",");
			int iIndex = Integer.parseInt(indexes[0].trim());
			int jIndex = Integer.parseInt(indexes[1].trim());
			int newVal = Integer.parseInt(token[1].trim());
			System.out.println("current value at "+iIndex+","+jIndex+" is ->"+
			matrix.get(iIndex).get(jIndex)+"\n"
					+ "it is going to be replaced by : "+newVal);
			matrix.get(iIndex).set(jIndex,newVal);
		}
	}
}
