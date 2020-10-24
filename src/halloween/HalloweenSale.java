package halloween;


/*
 *def howManyGames(p, d, m, s):
    count=0
    while(s>=p):
        count+=1
        s -=p
        p = max(p-d,m)
    return count;
 */
public class HalloweenSale {
	public static void main(String[] args) {
		System.out.println(howManyGames(100, 19, 1, 180));
	}
	
	static int howManyGames2(int p, int d, int m, int s) {
        int count = 0;
        while(s>=p){
            count++;
            s -=p;
            p = Math.max(p-d,m);
        }
        return count;
    }

	// Complete the howManyGames function below.
	static int howManyGames(int p, int d, int m, int s) {
		// Return the number of games you can buy
		int count = 0;
		int lastCost = 0;
		while (s > 0) {
			if (s < m) {
				return count;
			}
			if (count == 0 && lastCost == 0) {
				lastCost = p;
				if (s >= lastCost) {
					s -= lastCost;
				} else {
					return count;
				}
			} else {
				lastCost -= d;
				lastCost = (lastCost > m)? lastCost: m;
				if (s < lastCost) {
					return count;
				}
					s -= lastCost;
		      }
			count++;
		}
		return count;
	}
}
