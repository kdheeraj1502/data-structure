package range.partition;

public class RangePartition {

	public static void rangePartition(int num[]) {
		rangePartition(num, 9, 12);
	}

	private static void rangePartition(int num[], int lower, int higher) {
		int a = 0;
		int b = num.length - 1;
		int i = 0;
		while(i <= b) {
			
			if(num[i] < lower) {
				Main.swap(num, i, a);
				a++;
				i++;
			}
			else if(num[i] > higher) {
				Main.swap(num, i, b);
				b--;
			}
			else
				i++;
		}
	}
}
