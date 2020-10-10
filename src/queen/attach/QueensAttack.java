package queen.attach;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QueensAttack {
	public static void main(String[] args) {
		System.out.println(queensAttack(4,0,4,4, new int[][] {{}}));
	}

	 // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	Point queen = new Point(r_q, c_q);
        
        Set<Point> obstacleSet = new HashSet<>();
        for(int i = 0; i < k; i++){
        	obstacleSet.add(new Point(obstacles[i][0], obstacles[i][1]));
        }
       return queensAttack(n, queen, obstacleSet);
    }
    static int queensAttack(int n, Point queen, Set<Point> obstacles) {
        return Arrays.stream(Direction.values())
                     .mapToInt(d -> queensAttack(n, queen, obstacles, d))
                     .sum();
    }
    
    static int queensAttack(int n, Point queen, Set<Point> obstacles, Direction direction) {
        int result = 0;
        
        Point point = direction.move(queen);
        
        while(isInside(n, point) && !obstacles.contains(point)){
            result++;
            // System.out.println(point);
            point = direction.move(point);
        }
        
        return result;
    }
    
    static boolean isInside(int n, Point p){
        return 0 < p.getX() && p.getX() <= n &&
               0 < p.getY() && p.getY() <= n;
    }
    
    enum Direction {
        N( 0,   1),
        NE(1,   1),
        E( 1,   0),
        SE(1,  -1),
        S( 0,  -1),
        SW(-1, -1),
        W( -1,  0),
        NW(-1,  1);
        
        private int dx;
        private int dy;
        
        private Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
        
        private Point move(Point input) {
            Point result = (Point) input.clone();
            result.translate(dx, dy);
            return result;
        }
    }

}
