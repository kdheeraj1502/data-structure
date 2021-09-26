package bit.masking;

public class TotalSetCount {
	
	public static int setCount(int num) {
		int count = 0;
		while(num > 0) {
			num = num & (num -1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int num = 18;
		System.out.println(setCount(num));
	}
}
