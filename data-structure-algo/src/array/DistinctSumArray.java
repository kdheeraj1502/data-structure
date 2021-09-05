package array;

import java.util.*;
import java.util.Map.Entry;

public class DistinctSumArray {

	public static int sum(int num[]) {
		if(num.length == 0) return 0;
		Arrays.sort(num);
		int maxSum = 0;
		for(int i = 0; i < num.length - 1; i++) {
			if(num[i] != num[i + 1]) {
				maxSum += num[i];
			}
		}
		maxSum += num[num.length - 1];
		return maxSum;
	}
	
	public static int sumMap(int num[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for(Integer in : num) {
			map.put(in, map.getOrDefault(in, 1) + 1);
		}
		int maxSum = 0;
		for(Entry<Integer, Integer> m : map.entrySet()) {
			maxSum += m.getKey();
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		
		int num[] = { 5, 8, 2, 7, 3, 4, 6, 6 ,9 , 2, 1 ,1, 6 };
		System.out.println(sumMap(num));
	}
}
