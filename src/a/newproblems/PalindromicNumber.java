package a.newproblems;

public class PalindromicNumber {
	public static void main(String[] args) {
		    int input = 4;
			int power = (int) Math.pow(10, input);
			System.out.println("power : "+power);
			int t = ((power - 1) / 9);
			System.out.println("t "+t);
			int l = (int) Math.pow(t,2);
			System.out.println("l "+ l);
			System.out.println(System.getProperty("java.io.tmpdir"));
			while(l !=0)
			{
				System.out.println("---> "+l%10);
				l /= 10;
			}
		} 
		/*
		 * 11*2 = 121
		 * 111*2 = 12321
		 * 1111*2 = 1234321
		 */
		/*int input = 4;
		System.out.println("initial user input ==> "+input);
		int val = (int)Math.pow(((Math.pow(10, input))-1)/9,2.0);
		*/
	//}
}
