package balls.in.container;

import java.util.Arrays;

/**
 * def organizingContainers(container):
 *     r = sorted([sum(x) for x in container])
 *     c = sorted([sum(x) for x in zip(*container)])
 *     return "Possible" if r == c else "Impossible"
 *
 *
 * => let use list p=[[1,2,3] , [4,5,6] , [7,8,9]] print(zip(* p)) [(1,4,7) , (2,5,8) , (3,6,9)]
 */
public class OrganiseBallsInContainer {
	public static void main(String[] args) {

		/*
		 *     | 0 |  1 |  2   |
		 * ------------------------     
		 *   0 | 1 |  3 |  1   |
		 * -----------------------  
		 *   1 | 2 |  1 |  2   |
		 * ----------------------  
		 *   2 | 3 |  3 |  3   |
		 * ----------------------  
		 * 
		 *   1   4   0
		 *   2   3   0
		 *   3   0   6    -- X
		 *   
		 *   
		 *   0 1 2
		 *   1 1 1
		 *   2 0 0
		 */
		int [][] test = new int[][] {
				{0,1,2},
				{1,1,1},
				{2,0,0}
		};
		int [][] test2 = new int[][] {
			{1,3,1},
			{2,1,2},
			{3,3,3}
		};
	   int [][] test3 = new int [][] {
		   {46243313,92616295,67710591,64815435,54972858,72243452,43981963,98839842},
		   {92051933,89794374,13448199,23493279,82268795,11069706,82550576,19654929},
		   {81743395,56456242,80407875,99464396,95594850,44919631,12483256,54576390},
		   {31379865,35550507,13850344,82310457,35039216,11977132,44906966,58819635},
		   {10544893,81324309,69520528,81983330,45347555,78383273,77715274,86346533},
		   {78482611,37125744,47756688,70062813,86629089,81735741,38208033,80479682},
		   {59164275,5441347,85517562,78736923,59124243,51404960,24474089,27179427},
		   {48097170,61680833,13467922,1371525,59776803,85694885,96662368,52983154},
	   };
	
		System.out.println(organizingContainers(test3));
	}
	  // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
    	/**
    	 * 1. Swaps that happen between any 2 buckets are always of equal value 
    	 * (you can exchange 1 for 1 but not 2 for 1, ratio should always be 1:1), 
    	 * therefore the number of balls in each bucket will always remain the same. 
    	 * 
    	 * 2. We need to make sure that the total number of balls in each container 
    	 * should equal the number of balls of any type 't' for a fair trade(1:1 ratio).
    	 * This is done to check whether there are any type 't' balls that satisfy the
    	 * requirements of the solution (i.e. we want all balls of a single type 't' 
    	 * in only one container).
    	 * 
    	 * 3. Calculate the number of balls in each container(sum of rows) and store it
    	 * in a list.
    	 * 
    	 * 4. Calculate the number of balls of each type(sum of columns) and store it in
    	 * a list.
    	 * 
    	 * 5. Sort the two lists and compare them. If they are equal then a solution exists 
    	 * otherwise, no solution exists.
    	 * 
    	 * Try theses cases to see and understand the pattern: 
    	 * Note: For more test cases try Solved Sudoku puzzles.
    	 * 
    	 * The way to approach these kind of problems is to see what thinks remain constant 
    	 * between the sample input and sample solution. 
    	 */
        //array to count amount amount of each ball, it's position is a type and value the amount
        int[] ballsCount = new int[container[0].length];

        //array to count how many balls are currently in each basket
        int[] basketCapacity = new int[container[0].length];

        //iterate through every array and then every value in it
        for(int i = 0; i < container.length; i++){
            for(int j = 0; j < container.length; j++){
                basketCapacity[i] += container[i][j];
                ballsCount[j] += container[i][j];
            }
        }

        Arrays.sort(ballsCount);
        Arrays.sort(basketCapacity);


        if(Arrays.equals(ballsCount, basketCapacity)){
            return "Possible";
        }else{
            return "Impossible";
        }
    	
    	/**
    	 * below my try do not work for all solutions
    	 */
    	// step 1 find the row(s) with maximum elements. 
    /*	int[] maxSum = new int[] {-1};
    	Map<Integer,Integer> rows = new HashMap<>();
    	List<Integer> tt = new ArrayList<>();
    	for ( int i =0; i< container.length;i++)
    	{
    		 	rows.put(i,Arrays.stream(container[i]).sum());
    	}
    	System.out.println("rows = > "+rows);
    	rows.entrySet().forEach(i -> {
    		if(i.getValue()>maxSum[0])
    			{
    			maxSum[0] =i.getValue();
    			tt.clear();
    			tt.add(i.getKey());
    			}
    		else if(i.getValue()==maxSum[0])
    		{
    			tt.add(i.getKey());
    		}
    			
    	});
    	System.out.println("tt => "+tt);
    	int sumOfColorType = 0;
    	int restSum = 0;
    	int colorType =0;
    	int[] maxEle= new int[] {-1};
		
		for(int k=0; k< tt.size(); k++) {
			// find max element. and then the sum of rest
    		//int maxEle = Arrays.stream(container[t]).max().getAsInt();
    		
    		for(int i=0; i<container[k].length; i++)
    		{
    			if(container[k][i]>maxEle[0])
    			{
    			  colorType = i;
    			  maxEle[0] = container[k][i];
    			}
    		}
    		restSum = Arrays.stream(container[k]).sum() - maxEle[0];
		}
		// now check in all other rows if we have that many maxEle color balls.
		for(int j = 0; j< container.length;j++)
		{
		  sumOfColorType += container[j][colorType];	
		}
		sumOfColorType -= maxEle[0];
	   System.out.println("color type => "+colorType);
	   System.out.println("rest sum => "+restSum);
	   System.out.println("max ele => "+maxEle[0]);
	   System.out.println("sumOfColor Type => "+sumOfColorType);
	
		if(sumOfColorType <= restSum)
			return "POSSIBLE";
		else 
			return "IMPOSSIBLE"; */

    } 
}
