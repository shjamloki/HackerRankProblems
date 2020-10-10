package queen.attach;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  s = set([(x,y) for y,x in obstacles])
 *  m = [
 *      [-1, 1],[0, 1],[1, 1],
 *      [-1, 0],       [1, 0],
 *      [-1,-1],[0,-1],[1,-1]
 *      ]
 * r = 0
 * for d in m:
 *      y = r_q
 *      x = c_q
 *      while True:
 *             y += d[1]
 *             x += d[0]
 *             if x == 0 or y == 0 or x == n+1 or y == n+1:
 *                 break
 *             if (x,y) in s:
 *                break
 *             r += 1
 * return r
 *
 */
public class QueensAttackNew {
	public static void main(String[] args) {
		/*
		 *     - - - -
		 *     - - - -
		 *     - - - -
		 *     - - - -
		 */
		System.out.println(queensAttack(4,0,4,4, new int[][] {{}}));
	}

	 // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	 Set<String> obstaclesSet = new HashSet<>();
    	 int canAttack = 0;
         for (int i = 0; i < k; i++) {
             obstaclesSet.add(obstacles[i][0] + "-" + obstacles[i][1]);
         }
         int tempR, tempC;
         tempR = r_q;
         tempC = c_q + 1;
         while (tempC <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempC++;
             canAttack++;
         }
         tempC = c_q - 1;
         while (tempC > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempC--;
             canAttack++;
         }

         tempR = r_q + 1;
         tempC = c_q;
         while (tempR <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempR++;
             canAttack++;
         }
         tempR = r_q - 1;
         while (tempR > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempR--;
             canAttack++;
         }
         tempR = r_q + 1;
         tempC = c_q + 1;
         while (tempR <= n && tempC <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempR++;
             tempC++;
             canAttack++;
         }
         tempR = r_q + 1;
         tempC = c_q - 1;
         while (tempR <= n && tempC > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempR++;
             tempC--;
             canAttack++;
         }
         tempR = r_q - 1;
         tempC = c_q - 1;
         while (tempR > 0 && tempC > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempR--;
             tempC--;
             canAttack++;
         }
         tempR = r_q - 1;
         tempC = c_q + 1;
         while (tempR > 0 && tempC <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
             tempR--;
             tempC++;
             canAttack++;
         }

         return canAttack;
    }

}
