package bit.masking;

public class BitShift {

	public static void main(String[] args) {
		
		System.out.println(57 << (32 - 6));
		
		System.out.println(Integer.toBinaryString(57 >> 1));
		System.out.println(Integer.toBinaryString(57 >>> 1));
		System.out.println(Integer.toBinaryString(-57 >> 1));
		System.out.println(Integer.toBinaryString(-57 >>> 1));
		String num = Integer.toBinaryString(-57 >> 1);
		int count = 0;
		for (char c : num.toCharArray()) {
			if (c == '1') {
				count++;
			}
		}
		System.out.println("1 is " + count + " total size is " + num.toCharArray().length);
	}
}
