package stack;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		StackUsingArray<Integer> stack = new StackUsingArray<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(11);
		stack.push(23);
		stack.push(36);
		stack.push(24);
		stack.push(85);
		stack.push(74);
		stack.push(75);
		stack.push(611);
		stack.push(263);

		System.out.println(stack.getSize());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.getSize());
		System.out.println("-------print----------");
		stack.print();
		System.out.println(stack.getSize());

		System.out.println("--------------stack linkedlist--------------");
		StackUsingLinkedList<Integer> list1 = new StackUsingLinkedList();
		list1.push(67);
		list1.push(34);
		list1.push(37);
		list1.push(11);
		list1.push(98);
		list1.push(19);
		/*
		 * list1.push(46); list1.push(13); list1.push(9); list1.push(67);
		 * list1.push(18); list1.push(98); list1.push(76); list1.push(03);
		 * list1.push(35); list1.push(52);
		 */
		/*
		 * System.out.println(list1.getSize()); list1.print(); list1.pop(); list1.pop();
		 * list1.pop(); list1.pop(); list1.pop(); list1.pop(); list1.pop(); list1.pop();
		 */
		System.out.println(list1.getSize());
		list1.print();
		System.out.println("------------sorted insert----------------");
		StackSortedInsert ssi = new StackSortedInsert();
		Stack<Integer> stk = new Stack<>();
		/*
		 * ssi.sortedInsert(stk, 8); ssi.sortedInsert(stk, 8); ssi.sortedInsert(stk,
		 * 67); ssi.sortedInsert(stk, 34); ssi.sortedInsert(stk, 37);
		 * ssi.sortedInsert(stk, 11); ssi.sortedInsert(stk, 98); ssi.sortedInsert(stk,
		 * 19); System.out.println(stk);
		 */
		stk.push(67);
		stk.push(34);
		stk.push(37);
		stk.push(11);
		stk.push(98);
		stk.push(19);
		Stack<Integer> stk1 = ssi.sortStackGEEKSelf(stk);
	//	ssi.sortStack(stk);
	//	Stack<Integer> stk1 = ssi.sortStackIteration(stk);
	//	System.out.println(stk);
		stk1.add(74);
		System.out.println(stk1);
		BottomInsert.bottomInsert(stk1, 75);
		System.out.println(stk1);
		stk1.pop();
		System.out.println(stk1);
		ReverseStack.reverse(stk1);
		System.out.println(stk1);
		ReverseStack.reverseUseQueue(stk1);
		System.out.println(stk1);
		ReverseStack.reverseKElement(stk1, 3);
		System.out.println(stk1);
		
	}
}
