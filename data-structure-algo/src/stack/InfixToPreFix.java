package stack;

import java.util.Stack;

public class InfixToPreFix {

	public static void main(String[] args) {
		String expn = "10+((3))*5/(16-4)";
//		String expn = "2+3-1";
//		String expn = "5(((6)))3";
		String value = infixToPreFix(expn);
		System.out.println("Inflix Expn : " + expn);
		System.out.println("Postfix expn: " + value);
	}

	private static String infixToPreFix(String expn) {
		Stack<Character> stack = new Stack<>();
		char ch[] = expn.toCharArray();
		String output = "";
		// 10+((3))*5/(16-4)
		for (char c : ch) {
			if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
				output = c + output;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty()) {
					char pren = stack.pop();
					if (pren != '(') {
						output = pren + output;
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
							} else {
								output = op + output;
							}
						}
					}
					stack.push(c);
				}
			}
		}
		while (!stack.isEmpty()) {
			output = stack.pop() + output;
		}
		return output;
	}

	private static int getPriority(char op) {
		if (op == '+' || op == '-') {
			return 1;
		} else
			return 2;
	}
}
