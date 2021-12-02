package recursion;

public class ReverseLinkedList {

    ListNode result = new ListNode(-1);
    
    public ListNode reverseList(ListNode head) {
        ListNode curr = result;
        int val = reverse(head);
        if(head.val == val) {
        	while(result.next != null) {
        		result = result.next;
        	}
        	 result.next = new ListNode(reverse(head));;
        }
        return curr.next;
    }
    
    public int reverse(ListNode head) {
        
        // 1. Base
        if(head.next == null) 
        	return head.val;
        
        // 3. recursion
        int rightSide = reverse(head.next);
        
        result.next = new ListNode(rightSide);
        result = result.next;
        
        return head.val;
    }
    
    ListNode prev = null;
    public ListNode reverseList_recursion(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = reverseList(next);
        head.next = prev;
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode node = new ListNode(1);
    	node.next = new ListNode(2);
    	node.next.next = new ListNode(3);
    	node.next.next.next = new ListNode(4);
    	node.next.next.next.next = new ListNode(5);
    	
    	ReverseLinkedList rl = new ReverseLinkedList();
    	
    	ListNode result = rl.reverseList(node);
    	
    	while(result != null) {
    		System.out.print(result + " ");
    		result = result.next;
    	}
    	
	}
}
