package kangaroo;

/**
 *You are choreographing a circus show with various animals. For one act, you are given 
 *two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
 *
 * -> The first kangaroo starts at x1 location and moves at v1 a rate of meters per jump. 
 * -> The second kangaroo starts at x2 location and moves at v2 a rate of meters per jump. 
 * 
 *You have to figure out a way to get both kangaroos at the same location at the same
 *time as part of the show. If it is possible, return YES, otherwise return NO.
 *
 *For example, kangaroo 1  starts at x1 =2 with a jump distance v1=1  and kangaroo 
 *starts at with a jump distance of v2=2. After one jump, 
 *they are both at x=3, (x1+v1=2+1,x2+v2=1+2), so our answer is YES. 
 *
 *Function Description 
 *Complete the function kangaroo in the editor below. It should return YES if they reach the same position at the same time, or NO if they don't.
 *kangaroo has the following parameter(s):
 *  
 *  x1, v1: integers, starting position and jump distance for kangaroo 1
 *  x2, v2: integers, starting position and jump distance for kangaroo 2
 *
 *Input Format
 *A single line of four space-separated integers denoting the respective values of
 * x1,v1 ,x2 , and v2.
 * Constraints
 *   -> 0 <= x1 <= x2 <= 10000
 *   ->0 <= v1 <= 10000
 *   ->0 <= v2 <= 10000
 *   Output Format
 *   Print YES if they can land on the same location at the same time; otherwise, print NO.
 *   Note: The two kangaroos must land at the same location after making the same number of jumps.
 *   
 *   Sample Input 
 *   x1 v1 x2 v2
 *   0  3  4  2
 * 
 *   
 *   Sample Output 
 *   YES
 *   
 *   
 *   I think the formula is messing people up on this. I have found that using words, rather than 
 *   variable names, to be helpful when writing out the problem. 
 *   So we have two kangaroos starting at different locations, and jumping forward at different 
 *   distances. If we want to know where any kangaroo is at any given time, there is an intuitive
 *    equation for that: 
 *    Kangaroo Position = (Number of Jumps * Distance per Jump) + Starting Position. 
 *    We could also write this as: 
 *    
 *    K = yv + x 
 *    such that K = Kangaroo Position, y = Number of Jumps, v = Distance Per Jump, and x = Starting Position. 
 *    
 *    That almost looks like an equation your teacher went over in algebra that one time you were dozing off: 
 *    
 *   y = mx + b. I know we are talking about kangaroos here, but in the background we are really just 
 *   checking to see when two lines intersect. If we have two kangaroos and we want to know when (or if) 
 *   they will intersect, given their Starting Position and Distance per Jump, the only thing left to solve 
 *   for is Number of Jumps. 
 *   The kangaroos crossing paths essentially means that Kangaroo Position is equal for both kangaroos. 
 *   Remember the equation up above K = yv + x? Now that we have two kangaroos, we need to have 2 different 
 *   equations, and need to determine which value of y (Number of Jumps) can be plugged in to make them equal.
 *    So now we have something like this: 
 *    
 *    (y * v1) + x1 = (y * v2) + x2 
 *    
 *    We need to get y on one side of the equation, so we will begin reducing it down. 
 *    
 *    (x1 - x2) = (y * v2) - (y * v1) 
 *    (x1 - x2) = y(v2 - v1) 
 *    (x1 - x2) / (v2 - v1) = y 
 *    Luckily, the problem statement gives us the Starting Position and Distance per Jump (x1, x2, v1, and v2) 
 *    for each kangaroo. When we plug in these numbers it will tell us how many jumps it would take for  
 *    the kangaroos to end up in the same spot. But not so fast! We can do a a little work up front to check  
 *    if the kangaroo that is starting in front is moving faster than the kangaroo in the rear i.e we need  
 *    to see if Distance Per Jump for the kangaroo in front is larger than the one in the rear. If so, then  
 *    the one in the back will never catch up. Before we even attempt find an intersection we need to ensure 
 *    that v2 < v1 is true. If this evalutes to false then we are done and the lines will not intersect at  
 *    any point in the future. If the kangaroos started going the other direction then that would be a different story. 
 *    Anyway, so we plugged the numbers in and we are ready to see how many jumps it will take. At this point  
 *    there are two scenarios that will occur: 
 *     you got a whole number greater than zero   you got a fractional number greater than zero In scenario one, 
 *     this means that after y jumps, the kangaroos will be in the same spot. 
 *     In scenario two, the kangaroos will intersect, but they will be in the air. Kinda cool, but not what we wanted. 
 *     Now we get to the part that seems to mess with peoples heads: the dreaded % operator. Keep reading, and you will  
 *     see the solution to this problem.
 */

public class Kangaroo {
	// Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
    	String response = "NO";
    	boolean canCatchUp = (v2 < v1);
    	if(canCatchUp) {
    	    boolean willIntersectOnLand = (x1 - x2) % (v2 - v1) == 0;
    	    if(willIntersectOnLand) {
    	        response = "YES";
    	    }
    	}

    	return response;

    }
public static void main(String[] args) {
	
}
}
