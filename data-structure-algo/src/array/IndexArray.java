package array;

import java.util.Arrays;

public class IndexArray {

	public static void indexArray(int num[]) {
		for (int i = 0; i < num.length; i++) {
			int curr = i;
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
	
	public static void indexArraySelf(int num[]) {
		for(int i = 0; i < num.length; i++) {
			int curr = i;
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
		int num[] = { 8, 10, 6, 1, 9, 3, 2, 7, 4, 5 };
		indexArraySelf(num);
		System.out.println(Arrays.toString(num));
	}
}
