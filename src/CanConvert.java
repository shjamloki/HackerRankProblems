import java.util.Scanner;

/**
 * 
 *  You have a string of lowercase English alphabetic letters. You can perform two types of operations on the string:

    Append a lowercase English alphabetic letter to the end of the string.
    Delete the last character in the string. Performing this operation on an empty string results in an empty string.

Given an integer,
, and two strings, and , determine whether or not you can convert to by performing exactly of the above operations on

. If it's possible, print Yes. Otherwise, print No.

For example, strings
and . Our number of moves, . To convert to , we first delete all of the characters in moves. Next we add each of the characters of in order. On the move, you will have the matching string. If there had been more moves available, they could have been eliminated by performing multiple deletions on an empty string. If there were fewer than

moves, we would not have succeeded in creating the new string.

Function Description

Complete the appendAndDelete function in the editor below. It should return a string, either Yes or No.

appendAndDelete has the following parameter(s):

    s: the initial string
    t: the desired string
    k: an integer that represents the number of operations

Input Format

The first line contains a string
, the initial string.
The second line contains a string , the desired final string.
The third line contains an integer

, the number of operations.

Constraints

1<= |s| <=100
1 <= |t| <= 100
1 <= k <= 100

s and t consist of lowercase English alphabetic letters,ascii[a-z].

Output Format

Print Yes if you can obtain string
by performing exactly operations on

. Otherwise, print No.

Sample Input 0

hackerhappy
hackerrank
9

Sample Output 0

Yes

Explanation 0

We perform
delete operations to reduce string to hacker. Next, we perform append operations (i.e., r, a, n, and k), to get hackerrank. Because we were able to convert to by performing exactly

operations, we print Yes.

Sample Input 1

aba
aba
7

Sample Output 1

Yes

Explanation 1

We perform
delete operations to reduce string to the empty string (recall that, though the string will be empty after deletions, we can still perform a delete operation on an empty string to get the empty string). Next, we perform append operations (i.e., a, b, and a). Because we were able to convert to by performing exactly

operations, we print Yes.

Sample Input 2

ashley
ash
2

Sample Output 2

No

Explanation 2

To convert ashley to ash a minimum of
steps are needed. Hence we print No as answer. 
 *  
 *  =================
        CASE A:
        What this case is finding is if k is bigger than the difference in length of the two strings. example: s = "123456789", t = "1", k = 5 in this case, you definitely need a bigger k to transform s to t or vice versa, therefore you reject any such cases.
		Case B:
		now that the case has passed A, we can say that the total number of letters required to change is less than or equal to k. However the next problem comes because the question specified that exactly k moves must be done, no more no less. this leads to an example whereby:
		s = "010101", t = "01010", k = any EVEN number
		OR
		s = "010101", t = "010101", k = any ODD number
		from these two examples you can see that only if k is odd/even matches the odd/even of number of different digits will such cases pass.
		Case C:
		However there is a way to overcome this odd/even problem if you are able to completely delete away one string as a deletion action on an empty string results in another empty string.
		Example: s = '1' t = '101' k = 5
		in this case, to get a S from T you could do delete-delete-delete-delete-add(1) and you will satisfy the condition.
		Case D:
		all other cases will fail the test 
*/

public class CanConvert {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(canConvert(s, t, k) ? "Yes" : "No");
    }    
	
	 private static boolean canConvert(String s, String t, int k) {
	        /* Case 1 */
	        if (s.length() + t.length() <= k) {
	            return true;
	        }
	        
	        /* Case 2 */
	        int i = 0; // represents index of 1st non-matching character
	        for (   ; i < s.length() && i < t.length(); i++) {
	            if (s.charAt(i) != t.charAt(i)) {
	                break;
	            }
	        }
	        int minOperations = (s.length() - i) + (t.length() - i);
	        return k >= minOperations && (k - minOperations) % 2 == 0;
	    }

}
