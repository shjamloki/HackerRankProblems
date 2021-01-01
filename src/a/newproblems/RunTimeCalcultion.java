package a.newproblems;

public class RunTimeCalcultion {
	public static void main(String[] args) {
		System.out.println(runningTime2(new int[] { 2, 1, 3, 1, 2 }));

	}

// Complete the runningTime function below.
	static int runningTime(int[] array) {
		int count = 0;
		// calculate the number of shifts by insertion sort.
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int value = array[i];
			while (j >= 1 && array[j - 1] > value) {
				array[j] = array[j - 1];
				j--;
				count++;
			}
			array[j] = value;
		}
		return count;

	}

//Complete the runningTime function below.
	static int runningTime2(int[] arr) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			int loc = i;
			int val = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					loc = j;
					break;
				}
			}
			if (loc != i) {
				int temp = 0;
				for (int k = loc; k < i; k++) {
					if (temp == 0) {
						count++;
						temp = arr[k + 1];
						arr[k + 1] = arr[k];
					} else {
						count++;
						int temp2 = arr[k + 1];
						arr[k + 1] = temp;
						temp = temp2;
					}
					if (k + 1 == i) {
						arr[loc] = val;
					}
				}
			}
		}
		return count;
	}
}
