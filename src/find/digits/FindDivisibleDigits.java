package find.digits;

/**
 *  print len([i for i in map(int, list(str(value))) if i != 0 and value % i == 0])
 *  
 *  2 ==>
 *  return sum(a != '0' and n%int(a)==0 for a in str(n))
 *
 */
public class FindDivisibleDigits {
	public static void main(String[] args) {
		System.out.println(findDigits(1012));
	}
	
	static int findDigits(int n) {
		int count=0;
		while(n > 0){
		    if(n % 10 != 0 && n % (n % 10) == 0) count++;
		    n = n / 10;
		}
		return count;
	/* String s = String.valueOf(n);
	 int[] count = {0};
	 for (int i=0; i< s.length(); i++) {
		 int charVal = Integer.parseInt(s.charAt(i)+"");
		 if(charVal==0)continue;
		 	if(n%charVal ==0)
				{
				count[0]++;
				}
	}
	 return count[0]; */
	/* s.chars().forEach(c->{
		int charVal = Integer.parseInt(c+"");
		if(n%charVal ==0)count[0]++;
	 });
     return count[0];*/
    }

}
