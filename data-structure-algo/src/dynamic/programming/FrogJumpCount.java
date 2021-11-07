package dynamic.programming;

import java.util.Arrays;

public class FrogJumpCount {
	
	public static int canCross(int num[]) {
		int aux[] = new int[num.length];
		Arrays.fill(aux, Integer.MAX_VALUE);
		aux[0] = 0;
		for(int i = 0; i < num.length; i++) {
			for(int j = i + 1; j < Math.min(num.length, i + 1 + num[i]); j++) {
				aux[j] = Math.min(aux[j], aux[i] + 1);
			}
		}
		return aux[aux.length - 1];
	}

	public static void main(String[] args) {
		int num[] = { 2, 3, 1, 1, 4 };
		System.out.println(canCross(num));
	}
}
