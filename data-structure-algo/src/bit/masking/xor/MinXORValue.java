package bit.masking.xor;

import java.util.*;

public class MinXORValue {

	public static int findMinXor(List<Integer> A) {
		Collections.sort(A);
		int first = 0;
		int second = first + 1;
		int minXor = Integer.MAX_VALUE;
		int xor = 0;
		while(second < A.size() - 1 && first < A.size()) {
			second = first + 1;
			xor = A.get(first) ^ A.get(second);
			minXor = Math.min(minXor, xor);
			first++;
		}
		return minXor;
		
	}
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0, 4, 7, 9);
		System.out.println(findMinXor(list));
	}
}
