package binary.search;

import java.util.Arrays;

public class APlusBEquals2MultipyC {

	public static void geoExp(int num[]) {
		Arrays.sort(num);
		int j, k;
		for(int i = 1; i < num.length; i++) {
			j = i - 1;
			k = i + 1;
			int a = 2 * num[i];
			while(j >= 0 && k < num.length) {
				int sum = num[j] + num[k];
				if(sum == a) {
					System.out.println( num[j] + " + "+ num[k] + " = " + a);
					k++;
					j--;
				}
				else if(sum < a)
					k++;
				else
					j--;
			}
		}
	}
	
	public static void main(String[] args) {
		int num[] = { -15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82 };
		geoExp(num);
	}
}
