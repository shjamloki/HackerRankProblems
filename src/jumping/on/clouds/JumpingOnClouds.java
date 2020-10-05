package jumping.on.clouds;


/**
 * python -3 :
 * 
 *  print(100-sum([3 if c[x]==1 else 1 for x in range(0,len(c),k)]))
 *
 */
public class JumpingOnClouds {
	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[]{0,0,1,0,0,1,1,0},2));
	}
	//Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c, int k) {
		int i =0;
		int energy =100;
		// 1st itr : i=2 e = 97
		// 2nd itr :i=4 e 96
		//3d itr : i=4+2%8=6 e= 93
		//4 itr  :i= 6+2%8 =0 e =92
		do
		{
		  i = (i+k) % c.length;
		  energy--;
		  if(c[i]==1)
		  {
			  energy -= 2;
		  }
		}
		while(i !=0);
		return energy;
	}

}
