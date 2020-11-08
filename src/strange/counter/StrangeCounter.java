package strange.counter;

/*
 * python - 3
 * t = int(input())
	print((1 << ((t + 2) // 3).bit_length()) * 3 - 2 - t)
 */
public class StrangeCounter {
	public static void main(String[] args) {
		System.out.println(strangeCounterBitWise(21));
	}
	
	static long strangeCounterBitWise(long t)
	{
		long x = t+2/3;
		long y = (Long.bitCount(x)*3)-2-t;
		return 1 << y;
	}
	
	static long strangeCounter1(long t)
	{
		/**
		 * Hint: Notice that the number of elements in each column 
		 * form a geometric series: 3, 6, 12, ..., 3 * 2^(column - 1) 
		 */
		int n = 2;
        while (3 * (n - 1) < t) n = 2 * n;
        return (3 * (n - 1) - t + 1);
	}
	
	static long strangeCounter5(long t) {
		int rem = 3;
		while (t > rem) {
			t = t - rem;
			rem *= 2;
		}
		return (rem - t + 1);
	}
	
	
	static long strangeCounter4(long t)
	{
		long x = (t + 2) / 3;
        long b = Long.highestOneBit(x);//this is for 2 power.
        long tb = 3 * b;
        return tb - (t - (tb - 2));
	}
	
	static long myStrangeCounter(long t)
	{
		int n=2;
		while(3* (n-1)<t)
		{
			n = 2 * n;
		}
		return (3*(n-1)-t+1);
	}
	static long strangeCounter3(long t)
	{
		long v=4;

	    while(v<=t)
	    {
	        v=v*2+2;
	    }
	    return v-t;
	}

	//Complete the strangeCounter function below.
	static long strangeCounter(long t) {
		//series : 1,4,10,34
		//         1, 1+3,4+6,10+12
		//         1,1+3,1+3+6,1+3+6+12
		// i = 0 ====> 1
		// i =1 ====> 1+3 = prev =4,prevM=3
		// i =2 ===> prev+3*2 ==> prev=10,prevM=6
		//i=3 ==> prev+6*2 ==> prev=22,prevM=12
		int multiplier =3;
		long next = 1;
		long prevM = 3;
		long prevNext =1;
		for (long i=0;i<200;i++)
		{
			if(t <= next)
			{
				break;
			}
			if(i==0)
			{
				multiplier =0;
				prevNext =0;
				prevM = 0;
				next=3;
			}
			else if(i==1)
			{
				multiplier = 3;
				prevNext=4;
				prevM=6;
				next = 4;
			}
			else
			{
				prevNext = next;
				multiplier *=2;
				prevM=multiplier;
				next += multiplier;
			}
		}
		long diff = t-prevNext;
		if(diff == prevM)return prevM+diff;
		return prevM-diff;
		
	}
}
