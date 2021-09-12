package stack;

import java.util.Stack;

public class ReverseParenthesis {

	public static int reverseParenthesis(String exp) {
		Stack<Character> stack = new Stack<>();
		int openCount = 0;
		int closedCount = 0;
		if (exp.length() % 2 != 0) {
			System.out.println("not possible");
			return -1;
		}
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				if (stack.size() != 0 && stack.peek() == '(') {
					stack.pop();
				} else
					stack.push(ch);
			}
		}
		while (stack.size() != 0) {
			if (stack.pop() == '(')
				openCount += 1;
			else
				closedCount += 1;
		}
		int rev = (int) (Math.ceil(openCount / 2) + Math.ceil(closedCount / 2));
		return rev;
	}

	public static int reverseParenthesis_self(String exp) {
		Stack<Character> stack = new Stack<>();
		int open = 0;
		int close = 0;
		if (exp.length() % 2 != 0) {
			return -1;
		}
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				if (stack.size() != 0 && stack.peek() == '(') {
					stack.pop();
				} else
					stack.push(ch);
			}
		}
		while (stack.size() != 0) {
			if (stack.pop() == '(')
				open += 1;
			else
				close += 1;
		}
		int rev = (int) (Math.ceil(open / 2) + Math.ceil(close / 2));
		return rev;
	}

	public static void main(String[] args) {
		String exp = "())((()))(())()(()()()()))";
		//String exp = "()()()()";
		int rev = reverseParenthesis_self(exp);
		System.out.println(rev);
	}
}
