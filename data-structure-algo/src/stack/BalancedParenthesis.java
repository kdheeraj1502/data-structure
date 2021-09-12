package stack;

import java.util.Stack;

public class BalancedParenthesis {

	public static boolean isBalance(String exp) {
		Stack<Character> stack = new Stack<>();

		for (Character ch : exp.toCharArray()) {
			switch (ch) {
			case '(':
			case '{':
			case '[':
				stack.push(ch);
				break;
			case ')':
				if (stack.pop() != '(') {
					return false;
				}
				break;
			case '}':
				if (stack.pop() != '{') {
					return false;
				}
				break;
			case ']':
				if (stack.pop() != '[') {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}

	public static int findMaxDepth(String exp) {
		int max = -1;
		int currMax = 0;
		Stack<Character> stack = new Stack<>();
		if (isBalance(exp)) {
			for (Character ch : exp.toCharArray()) {
				if (ch == '(') {
					stack.push(ch);
					currMax += 1;
					max = Math.max(max, currMax);
				} else if (ch == ')') {
					stack.pop();
					currMax -= 1;
				}
			}
		} else {
			System.out.print("It is not balanced ");
		}
		return max;
	}

	public static void main(String[] args) {
		String exp[] = { "((()))()", "((((A)))((((BBB()))))()()()())" };
		for (String str : exp) {
			System.out.println(isBalance(str) + " Max depth is " + findMaxDepth(str));
		}
	}
}
