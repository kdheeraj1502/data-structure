package array;

import java.util.Arrays;

public class IndexArraySelf {
	
	public static void indexArray(int num[]) {
		int curr = 0;
		for(int i = 0; i < num.length; i++) {
			curr = i;
			int value = -1;
			while(num[curr] != -1 && num[curr] != curr) {
				int temp = num[curr];
				num[curr] = value;
				value = temp;
				curr = temp;
			}
			if(value != -1)
				num[curr] = value;
		}
	}

	public static void main(String[] args) {
		int num[] = { 8, 0, 6, 1, 9, 3, 2, 7, 4, 5 };
		indexArray(num);
		System.out.println(Arrays.toString(num));
	}
}
