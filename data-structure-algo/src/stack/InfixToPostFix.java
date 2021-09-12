package stack;

import java.util.Stack;

public class InfixToPostFix {

	public static int precedence(char x) {
		if (x == '(') {
			return 0;
		}
		if (x == '+' || x == '-') {
			return 1;
		}
		if (x == '*' || x == '/' || x == '%') {
			return 2;
		}
		if (x == '^') {
			return 3;
		}
		return 4;
	}

	public static String infixToPostFix(String expn) {
		String output = "";
		char[] out = infixToPostFix(expn.toCharArray());
		for (char ch : out) {
			output = output + ch;
		}
		return output;
	}

	public static char[] infixToPostFix(char[] expn) {
		Stack<Character> stack = new Stack<>();
		String output = "";
		char out;
		for (char ch : expn) {
			if (ch <= '9' && ch >= '0') {
				output = output + ch;
			} else {
				switch (ch) {
				case '+':
				case '-':
				case '*':
				case '/':
				case '%':
				case '^':
					while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
						out = stack.pop();
						output = output + " " + out;
					}
					stack.push(ch);
					output = output + " ";
					break;
				case '(':
					stack.push(ch);
					break;
				case ')':
					while (!stack.isEmpty() && (out = stack.pop()) != '(') {
						output = output + " " + out + " ";
					}
					break;
				}
			}
		}
		while (!stack.isEmpty()) {
			out = stack.pop();
			output = output + out + " ";
		}
		return output.toCharArray();
	}
	
	public static void main(String[] args) {
		String expn = "10+((3))*5/(16-4)";
		String value = infixToPostFix(expn);
		System.out.println("Inflix Expn : " + expn);
		System.out.println("Postfix expn: " + value);
	}
}
