package a.newproblems;

public class AlmostSorted {
	public static void main(String[] args) {
		almostSorted(new int[] { 1, 5, 4, 3, 2, 6 });
	}

	// Complete the almostSorted function below.
	static void almostSorted(int[] arr) {

		int start = 0;
		int end = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				start = i;
				break;
			}
		}
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				end = i;
				break;
			}
		}
		if (swap(arr, start, end)) {
			System.out.println("yes");
			System.out.printf("swap %d %d", start + 1, end + 1);
			return;
		}
		if (reverse(arr, start, end)) {
			System.out.println("yes");
			System.out.printf("reverse %d %d", start + 1, end + 1);
			return;
		}
		System.out.println("no");
	}

	private static boolean reverse(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		while (i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return isSorted(arr);
	}

	private static boolean swap(int[] arr, int i, int j) {
		int k = arr[i];
		int l = arr[j];

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		if (isSorted(arr)) {
			return true;
		} else {
			arr[i] = k;
			arr[j] = l;
			return false;
		}

	}

	private static boolean isSorted(int arr[]) {
		boolean unsorted = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				unsorted = false;
				break;
			}
		}
		return unsorted;
	}

}
