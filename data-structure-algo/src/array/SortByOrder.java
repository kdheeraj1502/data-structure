package array;

import java.util.*;

public class SortByOrder {

	public static int[] sortByOrder(int num[], int order[]) {
		Map<Integer, Integer> map = new HashMap<>();
		int result[] = new int[num.length];
		int i = 0;
		int index = 0;
		while (i < num.length) {
			System.out.println(num[i]);
			map.put(num[i], map.getOrDefault(num[i], 0) + 1);
			i++;
		}

		for (i = 0; i < order.length; i++) {
			if (map.containsKey(order[i])) {
				int j = map.get(order[i]);
				while (j > 0) {
					result[index] = order[i];
					index++;
					j--;
				}
				map.remove(order[i]);
			}
		}
		
		i = 0;
//		index = 0;
		while (i < num.length) {
			if(map.containsKey(num[i])) {
				int j = map.get(num[i]);
				while (j > 0) {
					result[index] = num[i];
					index++;
					j--;
				}
				map.remove(num[i]);
			}
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int order[] = { 2, 1, 8, 3 };
		int result[] = sortByOrder(num, order);
		System.out.println(Arrays.toString(result));
	}
}
