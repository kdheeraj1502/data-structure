package array;

import java.util.Arrays;
import java.util.Stack;

public class ElementFrequencyCount {

	public static int[] frequencyCount(int num[]) {
		int aux[] = new int[num.length];
		Arrays.fill(aux, 0);
		for (int i = 0; i < num.length; i++) {
				aux[num[i] - 1] = aux[num[i] - 1] + 1;
		}
		return aux;
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 2, 2, 1, 3, 4, 5};
		System.out.println(Arrays.toString(frequencyCount(num)));
		System.out.println(Arrays.toString(frequencyCountUseSort(num)));
	}
	
	public static int[] frequencyCountUseSort(int num[]) {
		Arrays.sort(num);
		int count = 1;
		int aux[] = new int[num.length];
		int start = 0;
		int index = 0;
		while(start < num.length - 1) {
			if(num[start] == num[start + 1]) {
				count++;
			}
			else {
				aux[index] = count;
				count = 1;
				index++;
			}
			start++;
		}
		aux[index] = count;
		return aux;
	}
}
