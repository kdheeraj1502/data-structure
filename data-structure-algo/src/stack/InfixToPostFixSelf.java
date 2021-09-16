package stack;

import java.util.Stack;

public class InfixToPostFixSelf {

	public static String infixToPostFixSelf(String exp) {
		Stack<Character> stack = new Stack<>();
		String postfix = "";
		char ch[] = exp.toCharArray();
		// 2 + 3 - 1
		for (char c : ch) {
			if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
				postfix = postfix + c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty()) {
					char paren = stack.pop();
					if (paren != '(') {
						postfix = postfix + paren;
					} else
						break;
				}
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				if (stack.isEmpty()) {
					stack.push(c);
				} else {
					while (!stack.isEmpty()) {
						char op = stack.pop();
						if (op == '(') {
							stack.push(op);
							break;
						} else if (op == '+' || op == '-' || op == '*' || op == '/') {
							if (getPriority(op) < getPriority(c)) {
								stack.push(op);
								break;
							} else
								postfix = postfix + op;
						}
					}
					stack.push(c);
				}
			}
		}
		while (!stack.isEmpty()) {
			postfix = postfix + stack.pop();
		}
		return postfix;
	}

	private static int getPriority(char op) {
		if (op == '+' || op == '-') {
			return 1;
		} else
			return 2;
	}

	public static void main(String[] args) {
		String expn = "10+((3))*5/(16-4)";
//		String expn = "2+3-1";
//		String expn = "5(((6)))3";
		String value = infixToPostFixSelf(expn);
		System.out.println("Inflix Expn : " + expn);
		System.out.println("Postfix expn: " + value);
	}
}
