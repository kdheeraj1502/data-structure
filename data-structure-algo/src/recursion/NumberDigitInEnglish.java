package recursion;

public class NumberDigitInEnglish {
	
	static String []digit= {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

	//431
	public static void numDigitName(int num) {
		if(num <= 0) {
			return;
		}
		int a = num % 10;
		num = num / 10;
		numDigitName(num);
		System.out.print(digit[a] + " ");
	}
	
	public static void main(String[] args) {
		numDigitName(43010);
	}
}
