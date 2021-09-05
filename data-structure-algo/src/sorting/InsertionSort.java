package sorting;

public class InsertionSort {

	public static void sort(int num[]) {
		int temp, j;
		for (int i = 1; i < num.length; i++) {
			temp = num[i];
			j = i;
			while(j > 0 && num[j - 1] > temp) {
				num[j] = num[j - 1];
				j--;
			}
			num[j] = temp;
		}
	}
}


