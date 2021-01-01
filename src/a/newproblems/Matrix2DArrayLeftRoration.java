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
		List<Integer> line5 = new ArrayList<>();
		List<Integer> line6 = new ArrayList<>();
		List<Integer> line7 = new ArrayList<>();
		List<Integer> line8 = new ArrayList<>();
		List<List<Integer>> matrix = new ArrayList<>();
		line1.add(1);line1.add(2);line1.add(3);line1.add(4);
		line1.add(11);line1.add(22);line1.add(33);line1.add(44);line1.add(333);line1.add(444);
		line2.add(5);line2.add(6);line2.add(7);line2.add(8);
		line2.add(55);line2.add(66);line2.add(77);line2.add(88);line2.add(777);line2.add(888);
		line3.add(9);line3.add(10);line3.add(11);line3.add(12);
		line3.add(99);line3.add(101);line3.add(111);line3.add(112);line3.add(1111);line3.add(1112);
		line4.add(13);line4.add(14);line4.add(15);line4.add(16);
		line4.add(131);line4.add(141);line4.add(151);line4.add(161);line4.add(1511);line4.add(1611);
		line5.add(19);line5.add(20);line5.add(21);line5.add(22);
		line5.add(191);line5.add(201);line5.add(211);line5.add(22);line5.add(2111);line5.add(2112);
		line6.add(25);line6.add(26);line6.add(27);line6.add(28);
		line6.add(251);line6.add(261);line6.add(271);line6.add(281);line6.add(2117);line6.add(2811);
		line7.add(25);line7.add(26);line7.add(27);line7.add(28);
		line7.add(252);line7.add(262);line7.add(272);line7.add(282);line7.add(2721);line7.add(2821);
		line8.add(25);line8.add(26);line8.add(27);line8.add(28);
		line8.add(253);line8.add(263);line8.add(273);line8.add(283);line8.add(2733);line8.add(2833);
		matrix.add(line1);matrix.add(line2);matrix.add(line3);
		matrix.add(line4);matrix.add(line5);matrix.add(line6);
		matrix.add(line7);matrix.add(line8);
		matrixRotation(matrix, 40);
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
    	//it works for all the scenarios
    	for(int i=0;i< layer;i++)
    	{
    			rotate(i,matrix,r);
    	}
        for (List<Integer> list : matrix) {
			for (Integer val : list) {
				System.out.print(val+" ");
			}
			System.out.println();
		}

    }
	private static void rotate(int i, List<List<Integer>> matrix,int distance) {
		//int [][] arr = new int [matrix.size()][matrix.get(0).size()];
	// (i,i) -->(i,m-i-1) --> (n-i-1,n-i-1,1) --> (n-i-1,i) -->i,i)
		int n = matrix.size();
		int m = matrix.get(0).size();
		List<Integer> test = new LinkedList<>();
		for (int j=i;j<m-i;j++)
		{
			test.add(matrix.get(i).get(j));
		}
		for(int j=i+1;j<n-i;j++) {
			test.add(matrix.get(j).get(m-i-1));
		}
		for(int j=m-i-2;j>=i;j--) {
			test.add(matrix.get(n-i-1).get(j));
		}
		for(int j=n-i-2;j>i;j--) {
			test.add(matrix.get(j).get(i));
		}
		distance %=test.size();
		Collections.rotate(test, -distance);
		for (int j=i;j<m-i;j++)
		{
			matrix.get(i).set(j,test.get(0));
			test.remove(0);
		}
		for(int j=i+1;j<n-i;j++) {
			matrix.get(j).set(m-i-1,test.get(0));
			test.remove(0);
		}
		for(int j=m-i-2;j>=i;j--) {
			matrix.get(n-i-1).set(j,test.get(0));
			test.remove(0);
		}
		for(int j=n-i-2;j>i;j--) {
			matrix.get(j).set(i,test.get(0));
			test.remove(0);
		}
	}
}
