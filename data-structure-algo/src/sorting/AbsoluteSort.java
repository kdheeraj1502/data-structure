package sorting;

import array.reduction.Main;

public class AbsoluteSort {
	public static void absBubbleSort(int num[]) {
		int ref = 5;
		absBubbleSort(num, ref);
	}

	private static void absBubbleSort(int num[], int ref) {
		for (int i = 0; i < (num.length - 1); i++) {
			for (int j = 0; j < (num.length - 1 - i); j++) {
				if (Math.abs(num[j] - ref) > Math.abs(num[j + 1] - ref))
					Main.swap(num, j, j + 1);
			}
		}
	}

	private static boolean absMore(int val1, int val2, int ref) {
		return (Math.abs(val1 - ref) > Math.abs(val2 - ref));
	}
}
