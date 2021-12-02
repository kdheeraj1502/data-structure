package stack;

import java.util.*;
import java.util.Stack;

public class RemoveInvalidParentheses {
	
	public int getMin(String s) {
		Stack<Integer> stack = new Stack<>();
		for(int i =0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(')
				stack.push(i);
			else {
				if(!stack.isEmpty() && ch == ')' && s.charAt(stack.peek()) == '(') {
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}
		return stack.size();
	}
	
	public void removeInvalidParentheses(String s){
		int remove = getMin(s);
		Set<String> result = new HashSet<>();
		removeInvalidParentheses(s, remove, result);
		result.forEach(System.out::println);
	}
	
	public void removeInvalidParentheses(String s, int remove, Set<String> buffer){
		if(remove == 0) {
			int removeNow = getMin(s);
			if(removeNow == 0) {
				if(!buffer.contains(s)) {
					//System.out.println(s);
					buffer.add(s);
				}
			}
			
		}
		for(int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i + 1);
			String res = left + right;
		//	if(!buffer.contains(res)) {
			//	buffer.add(res);
				removeInvalidParentheses(res, remove - 1, buffer);
			//}
		}
	}

	public static void main(String[] args) {
		String s = "()())()";
		RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
		rip.removeInvalidParentheses(s);
	}
}
