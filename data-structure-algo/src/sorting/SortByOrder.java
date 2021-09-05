package sorting;

import java.util.*;

public class SortByOrder {

	public static void sortByOrder(int num1[], int num2[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < num1.length; i++) {
			map.put(num1[i], map.getOrDefault(map.get(num1[i]), 1) + 1);
		}
		for(int j = 0; j < num2.length; j++) {
			if(map.containsKey(num2[j])) {
				int value = map.get(num2[j]);
				for(int k = 0; k < value; k++) {
					System.out.print(num2[j] + ", ");
				}
				map.remove(num2[j]);
			}
		}
		
		System.out.println();
		for(int i = 0; i < num1.length; i++) {
			if(map.containsKey(num1[i])) {
				int value = map.get(num1[i]);
				for(int k = 0; k < value; k++) {
					System.out.print(num1[i] + ", ");
				}
				map.remove(num1[i]);
			}
		}
		System.out.println();
	}
}
