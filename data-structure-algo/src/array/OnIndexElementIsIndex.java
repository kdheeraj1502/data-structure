package array;

import java.util.Arrays;

public class OnIndexElementIsIndex {
	
	
	public static int[] indexArray(int num[]) {
		
		for(int i = 1; i < num.length; i++) {
			int curr = i;
			int val = -1;
			
			while(curr != -1 && curr < num.length && num[curr] != curr - 1) {
				int temp = num[curr - 1];
				num[curr - 1] = val;
				val = curr = temp;
			}
			
			if(val != -1) {
				num[curr - 1] = val;
			}
		}
		
		return num;
	}

	public static void indexArrayOnSwap(int num[]) {
		
		for(int i = 0; i < num.length; i++) {
			int temp;
			while(num[i] != -1 && num[i] != i) {
				temp = num[i];
				num[i] = num[temp];
				num[temp] = temp;
			}
		}
		
	//	return num;
	}
	
	public static void main(String[] args) {
		int num [] = {8, -1, 6, 1, 9, 3, 2, 7, 4, -1, 0 };
		indexArrayOnSwap(num);
		System.out.println(Arrays.toString(num));
	}
}
