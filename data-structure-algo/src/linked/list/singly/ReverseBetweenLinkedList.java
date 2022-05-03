package linked.list.singly;

public class ReverseBetweenLinkedList {

	 public static ListNode reverseBetween(ListNode head, int left, int right) {
	        int pos = 1;
	        ListNode start = head, curr = head;
	        while(pos < left){
	            start = curr;
	            curr = curr.next;
	            pos++;
	        }
	        ListNode next = null, prev = null, tail = curr;
	        while(pos >= left && pos <= right){
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	            pos++;
	        }
	        start.next = prev;
	        tail.next = curr;
	        if(left == 1) 
	            return prev;
	        else
	            return head;
	    }
	 
	 public static void print(ListNode head) {
		 while(head != null) {
			 System.out.print(head.val + ", ");
			 head = head.next;
		 }
	 }
	 
	 public static void main(String[] args) {
		 ListNode node = new ListNode(1);
		 node.next = new ListNode(2);
		 node.next.next = new ListNode(3);
		 node.next.next.next = new ListNode(4);
		 node.next.next.next.next = new ListNode(5);
		 ListNode result = reverseBetween(node, 1, 4);
		 print(result);
	}
}
