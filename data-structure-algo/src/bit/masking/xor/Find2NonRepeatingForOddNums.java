package bit.masking.xor;

import java.util.ArrayList;
import java.util.List;

public class Find2NonRepeatingForOddNums {

	public static void find2OddNumberReapeatingNums(int num[]) {
		int xor = 0;
		for (int i = 0; i < num.length; i++) {
			xor ^= num[i];
		}
		int temp = xor;

		int digit = 0;

		while (temp > 0) {
			temp = temp / 2;
			digit++;
		}
		temp = xor;
		int pos = 0;
		for (int i = 0; i <= digit; i++) {
			if ((temp & (1 << i)) > 0) {
				pos = i;
				break;
			}
		}
		List<Integer> left = new ArrayList<>();

		for (int i = 0; i < num.length; i++) {
			if ((num[i] & (1 << pos)) > 0) {
				left.add(num[i]);
			}
		}
		temp = xor;
		for (int i = 0; i < left.size(); i++) {
			temp ^= left.get(i);
		}
		int a = temp;
		int b = temp ^ xor;

		System.out.println("a is " + a + " b is " + b);
		System.out.println("a in binary " + Integer.toBinaryString(a) + " b in binary is " + Integer.toBinaryString(b));
		System.out.println("Position is " + pos);
		System.out.println(Integer.toBinaryString(a ^ b));
	}

	public static void find2OddNumberReapeatingNums_self(int num[]) {
		// 1. XOR all values
		int xor = 0;
		for (int val : num) {
			xor ^= val;
		}

		// 2. Find first set bit position in XOR
		int temp = xor;
		int shiftCount = 0;
		int position = xor ^ -xor;
		/*
		 * while (temp > 0) { if (((temp >> shiftCount) & 1) != 0) { position =
		 * shiftCount++; break; } }
		 */

		// 3. Now find num in array , which has 1 bit or set bit at same position in
		// binary

		shiftCount = 0;
		List<Integer> setBitList = new ArrayList<>();
		List<Integer> offSetBitList = new ArrayList<>();
		for (int val : num) {
			if ((val & (1 << shiftCount)) != 0) {
				setBitList.add(val);
			} else {
				offSetBitList.add(val);
			}
		}

		int a = 0;
		int b = 0;

		for (int val : setBitList) {
			a ^= val;
		}

		for (int val : offSetBitList) {
			b ^= val;
		}
		/*
		 * temp = xor; for (int val : setBitList) { temp ^= val; } int a = temp; int b =
		 * temp ^ xor;
		 */
		System.out.println("First num is " + a + " second num is " + b);
	}

	public static void main(String[] args) {
		// int num[] = { 55, 88, 13, 81, 13, 55, 81, 76 };
		// int num[] = { 18, 24, 24, 21, 10, 29, 8, 10, 29, 18 };
		int num[] = { 18, 24, 24, 21, 10, 29, 8, 10, 29, 18 };
		find2OddNumberReapeatingNums(num);
		int a = 86;
		Object obj = a;
		System.out.println(obj);

		int b = (int) obj;
		System.out.println(b);

		find2OddNumberReapeatingNums_self(num);
	}
}
