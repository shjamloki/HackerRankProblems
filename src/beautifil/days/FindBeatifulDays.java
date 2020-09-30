package beautifil.days;

public class FindBeatifulDays {
	
	static int beautifulDays(int i, int j, int k) {
		int count =0;
		for(int l=i; l<=j;l++) {
			       if((l-getReverse(l))%k ==0)  count++;
			    }
		return count;
	}
	public static int getReverse(int n )
	{
		int reversed =0;
		 for(;n != 0; n /= 10) {
	            int digit = n % 10;
	            reversed = reversed * 10 + digit;
	        }
		 return reversed;
	}
	public static int reverse(int number){
	    int reverse = 0;
	    while(number!=0){
	        reverse = 10*reverse +number%10;
	        number = number/10;
	    }
	    reverse += number;
	    return reverse;
	}
	public static void main(String[] args) {
		System.out.println(beautifulDays(20,23,6));
	}
}
