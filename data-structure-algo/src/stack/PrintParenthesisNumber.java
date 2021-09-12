package stack;

import java.util.Arrays;
import java.util.Stack;

public class PrintParenthesisNumber {
	
	public static int[] printParenthesinNumber(String exp) {
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[exp.length()];
		int count = 0;
		int index= 0;
		for(int i = 0; i < exp.length(); i++){
			char ch= exp.charAt(i);
			if(ch == '(') {
				count += 1;
				stack.push(count);
				result[index++] = count;
			}
			else if(ch == ')') {
				int val = stack.pop();
				result[index++] = val;
			}
		}
		result = Arrays.copyOfRange(result, 0, 10);
		return result;
	}
	
	public static String printParenthes(String exp) {
		Stack<Integer> stack = new Stack<>();
		String output = new String();
		int count = 0;
		for(int i = 0; i < exp.length(); i++){
			char ch= exp.charAt(i);
			if(ch == '(') {
				count += 1;
				stack.push(count);
				output += count + ", ";
			}
			else if(ch == ')') {
				output += stack.pop() + ", ";
			}
		}
		return output;
	}

	public static void main(String[] args) {
		String exp = "(((a+(b))+(c+d)))";
		System.out.println(printParenthes(exp));
	}
}
