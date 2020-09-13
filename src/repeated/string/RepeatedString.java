package repeated.string;

/**
 *Lilah has a string s of lowercase English letters that she repeated infinitely many 
 *times.Given an integer n find and print the number of letter a's in the first n
 *letters of Lilah's infinite string.
 *
 *For example, if the string s= 'abcac' and n =10, the substring we consider is abcacabcac, 
 *the first 10 characters of her infinite string. There are occurrences of a in the substring.
 *
 *Function Description 
 *Complete the repeatedString function in the editor below. It should return an integer 
 *representing the number of occurrences of a in the prefix of length in the infinitely 
 * repeating string. repeatedString has the following parameter(s):
 *     s: a string to repeat
 *     n: the number of characters to consider
 *
 *Input Format
 *The first line contains a single string, s.
 *The second line contains an integer, n.
 *
 *Constraints 
 *  -> 1 <= |s| <= 100
 *  -> 1 <= n <= 10^12  
 *  -> 25% For of the test cases, n <= 10^6 .
 *  
 *  Output Format
 *  Print a single integer denoting the number of letter a's in the first letters of the infinite string 
 *  created by repeating infinitely many times.
 *  
 *  Sample Input 0 
 *  aba
 *  10 
 *  Sample Output 0 
 *  7
 */
public class RepeatedString {

	    public static void main(String[] args)  {
	    	String s = "abc";
	    	long n = 10;		
            long result = repeatedString2(s, n);
            System.out.println(result);
        }
	
	static long repeatedString2 (String s,long n)
	{
		long aCountInString = s.chars().filter(i -> i =='a').count();
		long reminining = s.substring(0, (int) (n % s.length())).chars().filter(i -> i == 'a').count();
		return n/s.length()* aCountInString +reminining;
	}
	
	 // Complete the repeatedString function below.
    static long repeatedString1(String s, long n) {
            long result = 0;
            long sLength = s.length();
            long divident = n/sLength;
            long remainder = n %sLength;
            long aCount =0;
            for(int i =0; i< sLength; i++)
            {
                if(s.charAt(i)=='a')
                {
                    aCount++;
                }
            }
        result = aCount*divident;
        aCount =0;
        for(int i =0; i< remainder; i++)
        {
            if(s.charAt(i) == 'a')
            {
                aCount++;
            }
        }
        return result + aCount;
    }
    
}
