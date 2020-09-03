/*Watson likes to challenge Sherlock's math ability. He will provide a starting and ending value describing a range of integers. Sherlock must determine the number of square integers within that range, inclusive of the endpoints.

Note: A square integer is an integer which is the square of an integer, e.g.1,4,9,16,25

.

For example, the range is a =24 and b=49 inclusive. There are three square integers in the range : 25,36,49.

Function Description

Complete the squares function in the editor below. It should return an integer representing the number of square integers in the inclusive range from a
to b.

squares has the following parameter(s):

    a: an integer, the lower range boundary
    b: an integer, the uppere range boundary

Input Format

The first line contains q
, the number of test cases.
Each of the next q lines contains two space-separated integers denoting a and b, the starting and ending integers in the ranges.

Constraints
1 <= q <= 100
1 <= a <= b <= 10^9

Output Format

For each test case, print the number of square integers in the range on a new line.

Sample Input

2
3 9
17 24

Sample Output

2
0

Explanation

Test Case #00: In range [3,9],4 and 9 are the two square integers.
Test Case #01: In range [17,24], there are no square integers.  */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndSquaresProblem {

    // Complete the squares function below.
    static int squares(int a, int b) {
        int [] count = {0};
      /*  for(int i =a; i<=b; i++)
        {
            double sqrt = Math.sqrt(i);
            double floorN = Math.floor(sqrt);
            if((sqrt-floorN)==0)
            {
                count++;
            }
        } */
      /* return ( int) IntStream.rangeClosed(a,b)
                                  .parallel()
                                  .mapToDouble(i->Math.sqrt(i))
                                  .filter(i ->(i-Math.floor(i)==0))
                                  .count(); */
        return (int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
