package surface.area;

public class SurfaceArea3D {
	public static void main(String[] args) {
		System.out.println(surfaceArea2(new int[][]
				{
					{1,3,4},
					{2,2,3},
					{1,2,4}
				}
		));
	}
	
	private static int surfaceArea2(int[][] A) {
		/**
		 * Step 1: A(i, j) represents the cube size of jth integer in ith line.
		 * Step 2: For individual A(i, j) the surface Area will be [ result = 4*A[i][j]+2 ].
		 * Step 3: Now we have to subtract the area for the corresponding column and row 
		 * which will be hidden after placing the nearest cubes.
		 * Step 4: So we subtract the hidden area of next column by subtracting the minimum 
		 * common area. [ result = result - min_of(A[i][j], next column element) ]
		 * Step 5: We will do the same for the next row. [ result = result - min_of(A[i][j], next row element) ]
		 */
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.println("a[i][j] is "+A[i][j]);
				result += 4 * A[i][j] + 2;
				// Check whether it is last row
				if(i != A.length - 1) {
					System.out.println("a[i][i+1] is "+A[i+1][j]);
					result -= 2 * Math.min(A[i][j], A[i + 1][j]);
				}
				// Check whether it is last column
				if(j != A[0].length - 1) {
					System.out.println("a[i][j+1] is "+A[i][j+1]);
					result -= 2 * Math.min(A[i][j], A[i][j + 1]);
				}
			}
		}
		return result;
	}

	 static int surfaceArea(int[][] A) 
	 {
	      /**
	       * 1.We need to calculate the total visible faces for the entire block. We do so by adding
	       * the visible faces contributed by the blocks placed on each cell.
	       * 
	       * 2.Let's take the 2nd testcase itself to analyze the problem.{{1,3,4},{2,2,3},{1,2,4}}. 
	       * The formula I have used for calculating visible faces at each cell is, 
	       * visibleFacesPerCell+=totalFaces-connectedFaces.
	       * 
	       * 3.Total faces=A[i][j]x6. SInce each block has 6 faces. Now connected faces due to the 
	       * blocks placed one above the other = (A[i][j]-1)x2. For example if 3 blocks are placed 
	       * one above the other, there will be (3-1)x2=4 connected faces, due to them being placed 
	       * on top of each other.
	       * 
	       * 4.Hence we initialize connectedFaces=(A[i][j]-1)x2. For each cell there can be maximum 
	       * 4 surrounding elements. For A[i][j] we can have at max A[i][j+1], A[i][j-1], A[i+1][j] 
	       * and A[i-1][j]. We need to check j-1 and i-1 for >=0. Because say for A[0][0] the elements
	       * at those i and j doesn't exist. Similarly we check for i+1<=row-1 and J+1<=column-1.
	       * 
	       * 5.Now we calculate the min value of A[i][j] with it's surrounding element , if it exists 
	       * and add it to the connectedFaces. For example for A[2][2]=2 we have 
	       * connectedfaces=(2-1)x2+min(2,3)+min(2,2)+min(2,2)+min(2,3)=10. The visible faces at cell 
	       * at index 2,2 =12-10=2. We do this for each cell and add them up. For cell at index 0,2 
	       * A[0][2]=4 it will be 24-( (4-1)x2 + min(4,3) + min(4,3)=10.
	       * 
	       */
	      int result=0;
	      int row = A.length;
	      int column = A[0].length;
	      for(int i=0;i<row;i++) {
	        int visibleFacesPerRow = 0;
	        for(int j=0;j<column;j++) {
	          int visibleFacesPerCell = 0;
	          int totalFaces=A[i][j]*6;
	          int connectedFaces=(A[i][j]-1)*2;
	          if (j + 1 <= column - 1) {
	        	connectedFaces += Math.min(A[i][j + 1], A[i][j]);
	          }
	          if (j - 1 >= 0) {
	        	connectedFaces += Math.min(A[i][j - 1], A[i][j]);
	          }
	          if (i + 1 <= row - 1) {
	        	connectedFaces += Math.min(A[i + 1][j], A[i][j]);
	          }
	          if (i - 1 >= 0) {
	        	connectedFaces += Math.min(A[i - 1][j], A[i][j]);
	          }          
	          visibleFacesPerCell = totalFaces - connectedFaces;
	          visibleFacesPerRow += visibleFacesPerCell;
	        }
	        result += visibleFacesPerRow;
	      }
	      return result;
	    }
	
}
