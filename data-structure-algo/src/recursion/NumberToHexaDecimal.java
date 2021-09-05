package recursion;

public class NumberToHexaDecimal {
	
	
	public static String printInt(int num, StringBuilder result) {
		String coversion = "0123456789ABCDEF";
		int base = 16;
		char digit = (char) (num % base);
		num = num/base;
		if(num != 0)
			printInt(num, result);
		result.append(coversion.charAt(digit));
		//System.out.print(coversion.charAt(digit));
		return result.toString();
	}

	public static void main(String[] args) {
		int num = 108;
		System.out.println(printInt(num, new StringBuilder()));
	}
}
