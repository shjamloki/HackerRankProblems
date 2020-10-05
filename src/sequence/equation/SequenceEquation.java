package sequence.equation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * n = int(input().strip())
 * p = list(map(int,input().strip().split(' ')))
 * for i in range(n):   
 *   print(p.index(p.index(i+1)+1)+1)
 *
 *same with multiple lines explanation :
 *n = int(input().strip()) 
 *p = list(map(int,input().strip().split(' ')))
 *for i in range(n):   
 *    x = i+1
 *    first_index = p.index(x)
 *     second_index = p.index(first_index + 1)
 *     ans = second_index + 1
 * print(ans)
 */
public class SequenceEquation {
	public static void main(String[] args) {
		permutationEquation(new int[] {4,3,5,1,2});
	}
	 static int[] permutationEquation(int[] p) {
		 //  2  ,3,1
		 // p(1)=2, p(2)=3,p(3)=1 ==> {1,p(3)},{2,p(1)},{3,p(1)}
		 // x=1 => p(p(3)
		 // x =2 => p(p(1)
		 // x=3 => p(p(2)
		 
		 //4,3,5,1,2
		 //p(1)=4, p(2)=3,p(3)=5,p(4)=1,p(5)=2
		 //x=1 = p(4) => p(p(1)
		 // x=2 = p(5)=p(p(3))
		 
		 //sol[p[p[i-1]-1]-1]
		 //  1st => p[i-1] ==>x
		 //   2nd ==>x-1 ==> y
		 //   3rd ==> y-1
		 // use this for new array sol[y-1] ==>array contents number starts from 1
		/* int []sol=new int[p.length];
	        for(int i:p)  sol[p[p[i-1]-1]-1]=i;
	     System.out.println(Arrays.toString(sol));
		 return sol;
		 
		 
		 The task is to find y where p(p(y)) = x, or y = p_inverse(p_inverse(x)).
         So, we just need to loop the array, get the value x, and use it as an index (and x-1, since 
         the iteration starts from 0, not 1). 
		 */
	        int[] result = new int[p.length];
	        
	        int[] indexArr = new int[p.length];

	        for (int i = 0; i < p.length; i++) {
	            int val = p[i];
	            indexArr[val - 1] = i + 1;

	        }
	        System.out.println("input array : "+Arrays.toString(p));
	        System.out.println("index array "+Arrays.toString(indexArr));
	        for (int i = 0; i < p.length; i++) {
	            result[i] = indexArr[indexArr[i] - 1];
	        }
	        System.out.println("result array : "+Arrays.toString(result));
	        return result;	 
	 }
	 
	 /**
	  * This is what I was attempting it to.
	  * @param p
	  * @return
	  */
	  static int[] permutationEquation1(int[] p) {
	        int[] eqArr = new int[p.length];
	        Map<Integer, Integer> hash = new HashMap();
	        for (int i = 1; i <= p.length; i++)
	            hash.put(p[i - 1], i);
	        for (int i = 0; i < eqArr.length; i++)
	            eqArr[i] = hash.get(hash.get(i + 1));
	        return eqArr;
	    }

}
