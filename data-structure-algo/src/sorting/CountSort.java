package sorting;

public class CountSort {

	public static void sort(int num[]) {
		sort(num, 100);
	}
	public static void sort(int num[], int maxVal) {
		int aux[] = new int[maxVal + 1];
		int i ;
		for(i = 0; i < num.length; i++) {
			aux[num[i]] = aux[num[i]] + 1;
		}
		
		int j = 0;
		for(i = 0; i < aux.length; i++) {
			int val = aux[i];
			while(val > 0) {
				num[j++] = i;
				val--;
			}
		}
	}
}
