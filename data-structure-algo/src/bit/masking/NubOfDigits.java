package bit.masking;

public class NubOfDigits {

	public static void main(String[] args) {
		int num = 13;
		int count = 0;
		System.out.println("Binary digit count " + count);
		while(num > 0) {
			num = num/2;
			count++;
		}
		
		System.out.println("Dicimal digit count " + count);
		num = 13;
		count = 0;
		while(num > 0) {
			num = num/10;
			count++;
		}
	}
}
