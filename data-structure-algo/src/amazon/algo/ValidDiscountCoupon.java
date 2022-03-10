package amazon.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

// empty
// xAx
// AB BA
public class ValidDiscountCoupon {

	public static List<Integer> findValidDiscountCoupons(List<String> discounts) {
		List<Integer> result = new ArrayList<>();
		for (String discount : discounts) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < discount.length(); i++) {
				if (!stack.isEmpty() && stack.peek() == discount.charAt(i)) {
					stack.pop();
				} else {
					stack.push(discount.charAt(i));
				}
			}
			if (stack.isEmpty()) {
				result.add(new Integer(1));
			} else {
				result.add(new Integer(0));
			}
		}
		return result;
	}
//1, 0, 1, 1, 1, 0, 0
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abba", "abca", "abbacbbc", "aabb", "xaaxybbyzccz", "vaas", "jay");
		System.out.println(findValidDiscountCoupons(list));
	}
}
