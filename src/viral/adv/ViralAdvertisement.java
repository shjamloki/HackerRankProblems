package viral.adv;

/**
 * bit wise python
 * m = 2
 * tot = 2
 * for _ in range(1, input()):
 * 	 m += m>>1
 *   tot += m
 * print tot
 *===============
 *m = [2]
 *for i in range(int(input())-1):
 *    m.append(int(3*m[i]/2))
 *print(sum(m))
 */
public class ViralAdvertisement {
	
	// Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
    	int valAtTheEndoftheDay =5;
    	int liked=2;
    	for(int i =2;i<=n;i++)
    	{
    		valAtTheEndoftheDay = (int) (Math.floor(valAtTheEndoftheDay/2)*3);
        	liked += Math.floor(valAtTheEndoftheDay/2);
    	}
    	return liked;
    }
    //recursion approach
    private static int viralAdvertising(int n, int days) {
        return ( days == 0 ) ? 0 : ((n >> 1) + viralAdvertising(((n >> 1) * 3), --days));
  }
	public static void main(String[] args) {
		System.out.println(viralAdvertising(3));
	}

}
