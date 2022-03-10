package amazon.algo;

import java.util.*;

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
				// "banana", "apple", "orange", "apple", "apple", "banana", "orange", "apple", "banana";

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
		for(int i = codeList.size() - 1; i >= 0; i--) {
			String code = codeList.get(i);
			String codes [] = code.split(" ");
			Stack<String> stack = new Stack<>();
			for(int j = codes.length - 1; j >= 0; j--) {
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
		List<String> codeList = Arrays.asList("banana orange apple", "banana");
		List<String> shoppingCart = Arrays.asList( "banana", "apple", "orange", "apple", "apple", "banana");
		int a = foo(codeList, shoppingCart);
		System.out.println(a);
		
		

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
}
