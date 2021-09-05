package array;

public class ArrayIndexMaxDifference {

	public static int arrayIndexMaxDiff(int num[]) {
		int maxDiff = -1;
		int j;
		for (int i = 0; i < num.length; i++) {
			j = num.length - 1;
			while (j > i) {
				if (num[j] > num[i]) {
					maxDiff = Math.max(maxDiff, j - i);
					break;
				}
				j -= 1;
			}
		}
		return maxDiff;
	}

	public static int arrayIndexMaxDiffSelf(int num[]) {
		int maxDiff = -1;
		int j;
		for (int i = 0; i < num.length; i++) {
			j = num.length - 1;
			while (j > i && j >= 0) {
				if (num[j] > num[i]) {
					maxDiff = Math.max(maxDiff, j - 1);
					break;
				}
				j -= 1;
			}
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		int num[] = { 33, 9, 10, 3, 2, 60, 30, 33, 1 };
		System.out.println(arrayIndexMaxDiffSelf(num));
	}
}
