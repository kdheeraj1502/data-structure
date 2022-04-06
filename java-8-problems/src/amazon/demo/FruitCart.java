package amazon.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FruitCart {

	public static int foo(List<String> codeList, List<String> shoppingCart) {
		Stack<String> orderStack = new Stack<>();
		Stack<Stack<String>> codeStack = new Stack<>();
		boolean isFound = false;
		String orderFruit = "";
		String prevCodeFruit = "";

		if (codeList.isEmpty()) {
			return 1;
		}

		pushCodeStack(codeList, codeStack);
		pushOrderStack(shoppingCart, orderStack);
//apple, orange, banana
		while (!codeStack.isEmpty()) {
			Stack<String> codeFruitStack = codeStack.pop();
			isFound = false;
			while (!codeFruitStack.isEmpty()) {
				String codeFruit = codeFruitStack.pop();
				if (orderStack.isEmpty()) {
					return 0;
				}

				if (isFound) {
					orderFruit = orderStack.pop();

					if (!checkFruit(codeFruit, orderFruit)) {
						isFound = false;
						codeFruitStack.push(prevCodeFruit);
					}
				}

				// "banana orange apple", "banana";
				// "banana", "apple", "orange", "apple", "apple", "banana", "orange", "apple",
				// "banana";

				while (!isFound && !orderStack.isEmpty()) {
					orderFruit = orderStack.pop();
					if (checkFruit(codeFruit, orderFruit)) {
						isFound = true;
					}
				}

				prevCodeFruit = codeFruit;
			}
		}

		if (!isFound && orderStack.isEmpty()) {
			return 0;
		}

		return 1;
	}

	private static void pushOrderStack(List<String> shoppingCart, Stack<String> orderStack) {
		for (int j = shoppingCart.size() - 1; j >= 0; j--) {
			orderStack.push(shoppingCart.get(j));
		}
	}

	private static void pushCodeStack(List<String> codeList, Stack<Stack<String>> codeStack) {
		for (int i = codeList.size() - 1; i >= 0; i--) {
			String code = codeList.get(i);
			String codes[] = code.split(" ");
			Stack<String> stack = new Stack<>();
			for (int j = codes.length - 1; j >= 0; j--) {
				stack.push(codes[j]);
			}
			codeStack.push(stack);
		}
	}

	private static boolean checkFruit(String codeFruit, String orderFruit) {
		if (codeFruit.equalsIgnoreCase("anything")) {
			return true;
		} else if (codeFruit.equalsIgnoreCase(orderFruit)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		long num = 500000007L;
		int x = 6;
		BigDecimal unscaled = new BigDecimal(num);
		BigDecimal scaled = unscaled.scaleByPowerOfTen(-x);

		String.format("%." + x + "f", scaled.doubleValue());

		// System.out.println(Double.valueOf(scaled.toString()));

		// System.out.println(scaled.doubleValue());

		double newNum = scaled.doubleValue();
		
		getNumbAndCount(78690);

		System.out.println("newNum " + newNum);

		BigDecimal newScaled = new BigDecimal(String.valueOf(newNum));

		BigDecimal newUnsclaed = newScaled.multiply(new BigDecimal(10).pow(x));

		System.out.println(newUnsclaed.longValue());

		System.out.println("-------------------------------");

		List<String> codeList = Arrays.asList("banana orange apple", "banana");
		List<String> shoppingCart = Arrays.asList("banana", "apple", "orange", "apple", "apple", "banana");
		int a = foo(codeList, shoppingCart);
		System.out.println(a);
		StringBuilder sb = new StringBuilder(12345);
		System.out.println(sb);

//		orange
//		apple
//		apple
//		banana
//		orange
//		apple
//		banana

//		
//		3
//		apple apricot
//		banana anything guava
//		papaya anything
//		7
//		banana
//		orange
//		guava
//		apple
//		apricot
//		papaya
//		kiwi
	}

	public static void getNumbAndCount(double num) {
		String str [] = String.valueOf(num).split("\\.");
			long numb = getNumb(str);
			int count = getCount(str[1]);
			System.out.println("numb " + numb);
			System.out.println("count " + count);
	}

	public static long getNumb(String str []) {
		String result = Arrays.stream(str).map(String::valueOf).collect(Collectors.joining());
		return Long.valueOf(result);
	}

	public static int getCount(String str) {
		return str.length();
	}
}
