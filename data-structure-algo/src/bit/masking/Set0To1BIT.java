package bit.masking;

public class Set0To1BIT {

	public static void main(String[] args) {
		int num = 309;
		int i = 1;
		int shiftCount = 5;
		// set 5th bit from right end
		System.out.println(num &(~(i << shiftCount)));
		
		//100110101
		//100010101
	}
}