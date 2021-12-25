package zeta;

import java.util.*;
import java.util.Map;

public class Division {

	static int prev = 0;

	public static String divide(int A, int B) {

		StringBuilder sb = new StringBuilder();
		divide(A, B, sb);
		return sb.toString();
	}

	public static void divide(int A, int B, StringBuilder sb) {
		if (A == 0) {
			// sb.append(q);
			return;
		}
		int q = A / B;
		sb.append(q);
		int rem = (A % B) * 10;
		divide(rem, B, sb);

	}

	public static String divide_iteration(int A, int B, StringBuilder sb, Map<Integer, Integer> map) {

		int q = A / B;
		sb.append(q);
		sb.append('.');
		int rem = (A % B);
		if(rem == 0) {
			sb.append('0').append('0');
		}
		while (rem != 0) {
			if(map.containsKey(rem)) {
				int index = map.get(rem);
				String part1 = sb.substring(0, index);
				String part2 = "("
                        + sb.substring(
                            index, sb.length())
                        + ")";
				return part1 + part2;
			}
			map.put(rem, sb.length());
			rem *= 10;
			q = rem / B;
			sb.append(q);
			rem = (rem % B);
		}
		return sb.toString();
	}

	static String fractionToDecimal(int numr, int denr) {
		String res = "";

		HashMap<Integer, Integer> mp = new HashMap<>();
		mp.clear();
		int rem = numr % denr;
		while ((rem != 0) && (!mp.containsKey(rem))) {
			mp.put(rem, res.length());
			rem = rem * 10;
			int res_part = rem / denr;
			res += String.valueOf(res_part);
			rem = rem % denr;
		}

		if (rem == 0)
			return "";
		else if (mp.containsKey(rem))
			return res.substring(mp.get(rem));

		return "";
	}

	public static void main(String[] args) {
		int A = 22;
		int B = 7;
		// System.out.println(divide(A, B));
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		System.out.println("divide_iteration " + divide_iteration(A, B, sb, map));

		int numr = 22, denr = 7;
		String res = fractionToDecimal(numr, denr);
		if (res == "")
			System.out.print("No recurring sequence");
		else
			System.out.print("Recurring sequence is " + res);
	}
}
