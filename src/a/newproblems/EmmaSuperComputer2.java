package a.newproblems;

import java.util.ArrayList;

/**
 *
from itertools import repeat, chain, combinations

# naive solution should work here -- itertools and composition for sanity preservation
N, M = [int(x) for x in input().strip().split(' ')]
grid = [[c == 'G' for c in input().strip()] for _ in range(N)]

def all_plusses(i0, j0):
    # edge coordinates of all plusses radiating from this location
    # including the 1-square "plus"
    return chain([[(i0, j0)]],
                 zip(zip(range(i0+1, N), repeat(j0)), \
                     zip(reversed(range(0, i0)), repeat(j0)), \
                     zip(repeat(i0), range(j0+1, M)), \
                     zip(repeat(i0), reversed(range(0, j0)))))

def valid_plusses(i0, j0):
    # yields sets of coordinates each describing a valid
    # plus originating at (i0, j0)
    coords = set()
    for edge in all_plusses(i0, j0):
        if all(grid[i][j] for i, j in edge):
            coords.update(edge)
            yield frozenset(coords)
        else:
            return

# finally generate all possible plusses
poss_plusses = chain.from_iterable(valid_plusses(i, j) for i in range(N) for j in range(M))

# find the non-intersecting pair with the largest area product
# (we only need to remember the largest size)
max_size = -1
for p1, p2 in combinations(poss_plusses, 2):
    if not (p1 & p2):
        max_size = max(max_size, len(p1) * len(p2))
        
print(max_size) 
 *
 */
public class EmmaSuperComputer2 {
	public static void main(String[] args) {
		System.out.println(twoPluses(new String[] { "GGGGGG", "GBBBGB", "GGGGGG", "GGBBGB", "GGGGGG" }));
		System.out.println("=================================");
	/*	System.out.println(twoPluses(new String[] { "BGBBGB", "GGGGGG", "BGBBGB", "GGGGGG", "BGBBGB", "BGBBGB" }));
		System.out.println("=================================");
		System.out
				.println(twoPluses(new String[] { "GGGGGGG", "BGBBBBG", "BGBBBBG", "GGGGGGG", "GGGGGGG", "BGBBBBG" }));
		System.out.println("=================================");
		System.out.println(twoPluses(new String[] { "GGGGGGGGGG", "GBBBBBBGGG", "GGGGGGGGGG", "GGGGGGGGGG",
				"GBBBBBBGGG", "GGGGGGGGGG", "GBBBBBBGGG", "GBBBBBBGGG", "GGGGGGGGGG"

				/**
				 * "GGGGGGG G GG", "GBBBBBB G GG", "GGGGGG G G G G", "GGGGGGG G GG", "GBBBBBB G
				 * GG", -------------- "GGGGGGGG G G", "GBBBBBBG G G", "GBBBBBBG G G",
				 * "GGGGGGGGGG"
				 */
		//}));
	}
	
	static class Plus {
        int x;
        int y;
        int len;
        int size;
        
        Plus(int x, int y) {
            this.x = x;
            this.y = y;
            this.len = 0;
            this.size = 1;
        }
        
        Plus(int x, int y, int len, int size) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.size = size;
        }
        
        void grow() {
            this.len++;
            this.size += 4;
        }
        
        boolean overlaps(Plus p2, int r, int c) {
        
            if(this.x != p2.x && this.y == p2.y) {
                if(p2.x >= this.x - this.len && 
                   p2.x <= this.x + this.len ||
                   p2.x < this.x - this.len && 
                   p2.x + p2.len >= this.x - this.len ||
                   p2.x > this.x + this.len && 
                   p2.x - p2.len <= this.x + this.len)
                    return true;                
            }
            
            if(this.y != p2.y && this.x == p2.x) {
                if(p2.y >= this.y - this.len && 
                   p2.y <= this.y + this.len ||
                   p2.y < this.y - this.len && 
                   p2.y + p2.len >= this.y - this.len ||
                   p2.y > this.y + this.len && 
                   p2.y - p2.len <= this.y + this.len)
                    return true;
            }
            
            boolean[][] grid = new boolean[r][c];
            
            for(int i = this.x - this.len; i <= this.x + this.len; i++) 
                grid[this.y][i] = true;
            for(int i = this.y - this.len; i <= this.y + this.len; i++)
                grid[i][this.x] = true;
            
            for(int i = p2.x - p2.len; i <= p2.x + p2.len; i++) {
                if(grid[p2.y][i] == true)
                    return true;          
            }
            for(int i = p2.y - p2.len; i <= p2.y + p2.len; i++) {
                if(grid[i][p2.x] == true)
                    return true;             
            }
            return false;
        }
    } 
	static int twoPluses(String []grid) {
		 int r = grid.length;
		 int c = grid[0].length();
		ArrayList<Plus> list = new ArrayList<Plus>();
		//find all pluses in the grid.
		 for(int y = 0; y < r; y++) {
	            for(int x = 0; x < c; x++) {
	            	if(grid[y].charAt(x) != 'B')
	                    findPlus(x, y, r, c, grid, list);
	            }
	        }        
	        
	        int max = 0;
	        //remove overlap 
	        //and then get first two in decreasing order to get product of the size.
	        for(int i = 0; i < list.size()-1; i++) {
	            Plus p1 = list.get(i);
	            for(int j = i+1; j < list.size(); j++) {
	                Plus p2 = list.get(j);
	                int sum = p1.size * p2.size; 
	                if(sum > max && !p1.overlaps(p2, r, c)) {
	                    max = sum;
	                }  
	            }
	        }
	        return max;
	}
    static void findPlus(int x, int y, int r, int c, String[] grid, ArrayList<Plus> list) {
        Plus plus = new Plus(x, y);
        int s = 1;
        while(y-s >= 0 && grid[y-s].charAt(x) != 'B' &&
              y+s < r && grid[y+s].charAt(x) != 'B' &&
              x-s >= 0 && grid[y].charAt(x-s) != 'B' &&
              x+s < c && grid[y].charAt(x+s) != 'B') {
            list.add(new Plus(plus.x, plus.y, plus.len, plus.size));
            plus.grow();
            s++;
        }
        list.add(plus);
    }
}
