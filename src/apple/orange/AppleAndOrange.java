package apple.orange;


/**
 * Sam's house has an apple tree and an orange tree that yield an abundance of fruit. 
 * In the diagram below, the red region denotes his house, where s is the start point, 
 * and t is the endpoint. The apple tree is to the left of his house, and the orange 
 * tree is to its right. You can assume the trees are located on a single point, 
 * where the apple tree is at point a, and the orange tree is at point b.
 * 
 * When a fruit falls from its tree, it lands units of distance from its tree of 
 * origin along the -axis. A negative value of means the fruit fell units to the 
 * tree's left, and a positive value of means it falls units to the tree's right.
 * Given the value of for apples and oranges, determine how many apples and oranges
 * will fall on Sam's house (i.e., in the inclusive range)?
 * 
 * For example, Sam's house is between s=7 and  t=10. The apple tree is located at a=4 and the
 * orange at b=4. There are m=3 apples and n=3 oranges. Apples are thrown apples=[2,3,-4 ]
 * units distance from a, and oranges= [3,-2,-4] units distance. Adding each apple distance
 * to the position of the tree, they land at [4+2,4+3,4+ -4]=[6,7,0]. Oranges land at 
 * [12+3,12+ -2,12+ -4]=[15,10,8]. One apple and two oranges land in the inclusive range 7-10 so we print 
 * 
 *    1
 *    2
 */
public class AppleAndOrange {
	// Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount =0;
        int orangeCount =0;
    	for (int apple : apples) {
			if(s <= (apple+a) && (apple+a)<=t)
			{
				appleCount++;
			}
		}
    	for (int orange : oranges) {
    		if(s <= (orange+b) && (orange+b)<=t)
			{
				orangeCount++;
			}
		}
    	System.out.println(appleCount);
    	System.out.println(orangeCount);
    }
    public static void main(String[] args) {
		countApplesAndOranges(7,11, 5, 15, new int[] {-2,2,1}, new int[] {5,-6});
	}
}
