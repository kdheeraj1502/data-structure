package recursion;

public class RemoveLinkedListEllement {
//			  |         
	// INPUT 1 , 2 , 6, 3 , 4 , 5, 6 , NULL
	// INPUT 1 , 2 , 6, 3 , 4 , 5, NULL
	public ListNode removeElements_recursion(ListNode head, int val) {

		/**
		 * 1. BASE CONDITION 2. OPERATION/CALCULATION/KAAM DHANDHA 3. RECURSION CALL/
		 * SAME METHOD CALL
		 */
		if (head == null) {
			return null;
		}

		ListNode rightSideHead = removeElements_recursion(head.next, val);

		if (head.val == val) {
			return rightSideHead;
		}

		head.next = rightSideHead;

		// OUTPUT 1, 2, 3, 4, 5
		return head;
	}

	public ListNode removeElements_iteration(ListNode head, int val) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(-1);

		ListNode result = dummy;
		System.out.println(dummy == result);
		// -1, 1 , 2 , 6, 3 , 4 , 5, 6 , NULL
		dummy.next = head;
		ListNode next = null;
		
		while (dummy.next != null) {
			if (dummy.next.val == val) {
				next = dummy.next.next;
				dummy.next = next;
			}
			else
				dummy = dummy.next;
		}

		return result.next;
	}
	
	public ListNode removeElements_iteration_prev(ListNode head, int val) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		// -1,   prev // 1 ,  // 2 , 6, 3 , 4 , 5, 6 , NULL
		ListNode prev = dummy;
		
		// 1 , 2 , 6, 3 , 4 , 5, 6 , NULL
		ListNode cur = head;
		
		while(cur != null) {
			if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {

		RemoveLinkedListEllement rl = new RemoveLinkedListEllement();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);

		System.out.println("-------Before-----------");
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr + ", ");
			curr = curr.next;
		}

		ListNode result = rl.removeElements_recursion(head, 6);
		System.out.println();
		System.out.println("-------After-----------");
		while (result != null) {
			System.out.print(result + ", ");
			result = result.next;
		}
		
		ListNode result1 = rl.removeElements_iteration(head, 7);
		
		System.out.println();
		System.out.println("-------Iteration -----------");
		while (result1 != null) {
			System.out.print(result1 + ", ");
			result1 = result1.next;
		}
		
		ListNode result2 = rl.removeElements_iteration_prev(head, 6);
		
		System.out.println();
		System.out.println();
		System.out.println("-------Iteration Prev-----------");
		while (result2 != null) {
			System.out.print(result2 + ", ");
			result2 = result2.next;
		}
	}
}
