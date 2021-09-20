package recursion;

import java.util.*;

public class Permutation {

	public static List<List<Integer>> permutation(int num[]) {
		List<List<Integer>> result = new ArrayList<>();
		permutation(num, result, 0);
		return result;
	}

	public static void permutation(int num[], List<List<Integer>> result, int index) {
		if (index == num.length) {
			List<Integer> curr = new ArrayList<>();
			for (int in : num) {
				curr.add(in);
			}
			result.add(curr);
			return;
		}
		for (int i = index; i < num.length; i++) {
			swap(num, i, index);
			permutation(num, result, index + 1);
			swap(num, i, index);
		}
	}

	public static void swap(int num[], int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void main(String[] args) {
		int num[] = new int[5];
		for (int i = 0; i < 5; i++) {
			num[i] = i;
		}
		permutation(num).stream().forEach(System.out::println);
		//System.out.println(permutation(num));
	}
}
