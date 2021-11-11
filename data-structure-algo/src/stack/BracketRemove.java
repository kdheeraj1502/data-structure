package stack;

import java.util.Stack;

public class BracketRemove {

	// Time O(n)
	// Space O(n) StringBuilder + Stack of n size O(2n) ignore constant hence O(n)
	// space
	public static String minRemoveToMakeValid(String s) {
		// Use stack to store the opening bracket ['('] index only
		// and pop the opening bracket index if we find closing bracket
		// else no need to push index of closing bracket in stack
		// if opening bracket is alot lets push all of its index
		// later i another loop we will not add those index value of String in result
		Stack<Integer> stack = new Stack<>();
		// Result string
		// append required character only
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// add its index in stack
			if (ch == '(') {
				stack.push(i);
			}
			if (ch == ')') {
				// remove index of opening bracket if closing bracket is found
				// and stack is not empty
				if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
				} else {
					// is stack is empty and we have found closing bracket, lets ignore it
					stack.push(i);
				}
			}
		}
		// If we have push and then poped all opening bracket index
		// if we have found equivalent closing bracket then return
		// the same string because the brackets are balanced
		if (stack.isEmpty()) {
			return s;
		} else {
			// Run the String loop again from last index because stack is last in first out
			// check if the stack has the same index on top then pop from stack
			// and dont append in result
			// Else append in result string and then reverse because
			// we started from last index and moved on 0 index

			for (int i = s.length() - 1; i >= 0; i--) {
				if (stack.peek() == i) {
					stack.pop();
					continue;
				} else
					sb.append(s.charAt(i));
			}
		}
		return sb.reverse().toString();
	}

	// Time O(n)
	// Space O(n) StringBuilder for result
	// Not using stack instead using a count integer
	// Start loop from starting index 0
	// increment the count if opening bracket found then,
	// decrement the count if closing bracket found but if count is 0 then no need
	// to decrement the counts
	// bcz if count is 0, then 0 value in array to identify the index which will
	// not get added in result
	// Now, run another loop from back and initialize the same count with 0 again
	// before start of the loop
	// increment count if closing bracket found and
	// decrement count is opening brackets are found else add 0 in array index
	public static String minRemoveToMakeValid_1(String s) {
		int count = 0;
		char arr[] = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == '(') {
				count++;
			}
			if (ch == ')') {
				if (count > 0) {
					count--;
				} else {
					arr[i] = 0;
				}
			}
		}
		if (count > 0) {
			count = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				char ch = arr[i];
				if (ch == ')') {
					count++;
				}
				if (ch == '(') {
					if (count > 0) {
						count--;
					} else {
						arr[i] = 0;
					}
				}
			}
		}

		// start to run the loop third time and append in StringBuilder the characters
		// except array value is 0, which we added in previous 2 loops
		StringBuilder sb = new StringBuilder();
		for (char ch : arr) {
			if (ch == 0) {
				continue;
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "))((";
		System.out.println(minRemoveToMakeValid(s));
		System.out.println(minRemoveToMakeValid_1(s));
	}
}
