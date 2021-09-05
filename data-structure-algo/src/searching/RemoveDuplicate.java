package searching;

import java.util.*;
import java.util.Map.Entry;

public class RemoveDuplicate {

	public static int[] removeDuplicate(int num[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i< num.length; i++) {
			if(map.containsValue(num[i])) {
				continue;
			}
			else {
				map.put(i, num[i]);
			}
		}
		int result[] = new int[map.size()];
		int i = 0;
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			result[i++] = entry.getValue();
		}
		return result;
	}
	
	public static int[] removeDuplicateUseArray(int num[]) {
		Arrays.sort(num);
		int i; int j = 0;
		for(i = 0; i < num.length; i++) {
			if(num[i] != num[j]) {
				j++;
				num[j] = num[i];
			}
		}
		int result[] = Arrays.copyOf(num, j + 1);
		return result;
	}
}
