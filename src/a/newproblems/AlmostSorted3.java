package a.newproblems;

public class AlmostSorted3 {
	public static void main(String[] args) {
		//almostSorted(new int[] { 1, 5, 4, 3, 2, 6 });
		//almostSorted(new int[] {43,65,1,98,99,101});
		//following example even after swaping the array is not sorted.
		almostSorted(new int[] {1,8,7,11,14,10,17});
	}

	// Complete the almostSorted function below.
	static void almostSorted(int[] a) {
		int count = 0;
		int u = 0, v = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (i > 0 && a[i - 1] > a[i]) {
				++count;
				if (u == 0) {
					u = i;
				}
				v = i;
			}
		}
		if (count == 1) {
			if (n > 2 && a[u - 1] < a[v + 1] && a[v] > a[u - 2 >= 0 ? u - 2 : 0]) {
				System.out.println("yes\nswap " + u + " " + (v + 1));
			} else if (n == 2) {
				System.out.println("yes\nswap " + u + " " + (v + 1));
			} else {
				System.out.println("no");
			}
		} else if (count == 2) {
			System.out.println("yes\nswap " + u + " " + (v + 1));
		} else if (count > 2) {
			if (a[u - 2] < a[v] && a[u - 1] < a[v + 1] && v - u == count - 1) {
				System.out.println("yes\nreverse " + u + " " + (v + 1));
			} else {
				System.out.println("no");
			}
		} else if (count == 0) {
			System.out.println("yes");
		}
	}
}
