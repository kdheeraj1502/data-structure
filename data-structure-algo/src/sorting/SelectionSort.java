package sorting;

import array.reduction.Main;

public class SelectionSort {

	public static void sort(int num[]) {
		int i, j, max, temp;
		
		for(i = 0; i < num.length; i++) {
			max = 0;
			for(j = 1; j < num.length - i; j++) {
				if(num[j] > num[max]) {
					max = j;
				}
			}
			Main.swap(num, max, num.length - 1 - i);
		}
	}
}
