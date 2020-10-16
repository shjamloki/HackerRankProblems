package kaprekar.numbers;


/**
 * count = 0
 * for i in range(int(input()),int(input())+1):
 *   s = str(i**2)
 *   x = s[len(s)//2:]
 *   y = s[0:len(s)//2]
 *   if x=='':x=0
 *   if y=='':y=0
 *   if int(x)+int(y)==i:print(i,end=' ');count+=1
 * if count==0:print("INVALID RANGE")
 *
 */
public class KaprekarNumbers {
	public static void main(String[] args) {
		kaprekarNumbers(1,99999);
		//1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
	}
	
	static void kaprekarNumbers2(int p, int q) {
        int base;
        boolean flag = false;
        for(int n = p; n <= q; ++n){
            int l = Integer.toString(n).length();
            base = (int) Math.pow(10,l);
            long pow = (long) Math.pow(n, 2);
            long mod = pow % base;
            long div = (pow - mod) / base;
            if((div + mod) == n){
                System.out.printf("%d ", n);
                flag = true;
            }
        }
        if(!flag)
            System.out.printf("%s", "INVALID RANGE"); 
    }

	//Complete the kaprekarNumbers function below.
	static void kaprekarNumbers(int p, int q) {
		StringBuilder builder = new StringBuilder();
		for(int i=p; i<=q;i++)
		{
			long square = (long)Math.pow(i, 2);
			String strSq = String.valueOf(square);
			if(strSq.indexOf(".")>0)
			strSq  = strSq.substring(0,strSq.indexOf("."));
			if(strSq.length()==1) 
			{
				if(square ==i)
				{
					builder.append(i+" ");
				}
				continue;
			}
			int midPoint = strSq.length()/2;
			int l = Integer.parseInt(strSq.substring(0,midPoint));
			int r = Integer.parseInt(strSq.substring(midPoint,strSq.length()));
			if((l+r) ==i)
			{
				builder.append(i+" ");
			}
		}
		if(builder.length()==0)
		{
			System.out.println("INVALID RANGE");
		}
		else
		{
			System.out.println(builder.toString());
		}

	}
}
