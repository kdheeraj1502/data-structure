package array;

import java.util.Arrays;

public class MaxCountOfElementInArray {

	public static int findMaxCount(int num[]) {
		Arrays.sort(num);
		int currCount = 1;
		int maxCount = 1;
		int currEle = num[0];
		int maxEle = num[0];
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] == num[i + 1]) {
				currCount++;
			} else {
				currCount = 1;
				currEle = num[i + 1];
			}
			if(maxCount < currCount) {
				maxCount = currCount;
				maxEle = currEle;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		int num[] = { 4, 9, 6, 9, 1, 4, 1, 7, 6, 1, 9 };
		count(num);
		System.out.println(Arrays.toString(num));
		System.out.println(findMaxCountUsingCountSort(num));
		System.out.println("===============================");
		System.out.println(findMaxCount(num));
		System.out.println(findMaxCountIsingCountSort_1(num));
	}

	public static int findMaxCountUsingCountSort(int num[]) {
		int aux[] = new int[100];
		for (int i = 0; i < num.length; i++) {
			aux[num[i]] += 1;
		}
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			max = Math.max(max, aux[num[i]]);
		}
		return max;
	}
	
	public static int findMaxCountIsingCountSort_1(int num[]) {
		int currCount = 1;
		int maxCount = 1;
		int maxEle = num[0];
		int aux[] = new int[100];
		for (int i = 0; i < num.length; i++) {
			aux[num[i]] += 1;
			currCount = aux[num[i]];
			if(currCount > maxCount) {
				maxCount = currCount;
				maxEle = num[i];
			}
		}
		return maxEle;
	}

	public static void count(int num[]) {
		int aux[] = new int[100];
		for (int i = 0; i < num.length; i++) {
			aux[num[i]] += 1;
		}
		int j = 0;
		for (int i = 0; i < aux.length; i++) {
			int val = aux[i];
			while (val > 0) {
				num[j++] = i;
				val--;
			}
		}
	}
}
