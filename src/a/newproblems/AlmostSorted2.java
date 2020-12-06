package a.newproblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class AlmostSorted2 {
	public static void main(String[] args) {
		almostSorted(new int[] { 1, 5, 4, 3, 2, 6 });
	}
	// Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        int[] sorted = IntStream.range(0, arr.length).map(a -> arr[a]).sorted().toArray();

        if (Arrays.equals(sorted, arr)) System.out.println("yes");

        int left = assignL(arr);
        int right = assignR(arr);

        if (swap(left, right, arr, sorted)) {
            System.out.println("yes");
            System.out.println("swap " + (1 + left) + " " + (1 + right));
        } else if (reverse(left, right, arr, sorted)) {
            System.out.println("yes");
            System.out.println("reverse " + (1 + left) + " " + (1 + right));
        } else System.out.println("no");
    }

    private static boolean reverse(int left, int right, int[] arr, int[] sorted) {
        int[] test = Arrays.copyOf(arr, arr.length);
        reverse(left, right, test);
        return Arrays.equals(sorted, test);
    }

    private static boolean swap(int left, int right, int[] arr, int[] sorted) {
        int[] test = Arrays.copyOf(arr, arr.length);
        swapF(left, right, test);
        return Arrays.equals(sorted, test);
    }

    private static int assignL(int[] arr) {
        return IntStream.range(0, arr.length).filter(a -> arr[a] > arr[a + 1]).findFirst().orElse(0);
    }

    private static int assignR(int[] arr) {
        return IntStream.range(1, arr.length).boxed().sorted(Collections.reverseOrder()).filter(a -> arr[a - 1] > arr[a]).findFirst().orElse(0);
    }

    private static void reverse(int a, int b, int[] test) {
        int start = a;
        int end = b;
        while (start < end) {
            swapF(start, end, test);
            start++;
            end--;
        }
    }

    private static void swapF(int a, int b, int[] test) {
        int temp = test[b];
        test[b] = test[a];
        test[a] = temp;
    }
	
}
