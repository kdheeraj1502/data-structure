package stack;

import java.util.Stack;

public class DuplicateParenthesis {

	public static boolean findDuplicateParenthesis(String exp) {
		Stack<Character> stack = new Stack<>();
		int count;
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == ')') {
				count = 0;
				while (stack.size() != 0 && stack.peek() != '(') {
					stack.pop();
					count += 1;
				}
				if (count >= 1)
					return true;
			} else
				stack.push(ch);
		}
		return false;
	}
	
	public static void main(String[] args) {
		String exp = "(((a + b)) + c)";
		System.out.println(findDuplicateParenthesis(exp));
	}
}
