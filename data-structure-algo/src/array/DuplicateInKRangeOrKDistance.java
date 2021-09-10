package array;

import java.util.*;

public class DuplicateInKRangeOrKDistance {
	
	public static boolean duplicateKDistance(int num[], int dis) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < num.length; i++) {
			if(map.containsKey(num[i])) {
				if(dis >= (i - map.get(num[i]))){
					return true;
				}
			}
			map.put(num[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 3, 1, 4, 5 };
		System.out.println(duplicateKDistance(num, 2));
	}
}
