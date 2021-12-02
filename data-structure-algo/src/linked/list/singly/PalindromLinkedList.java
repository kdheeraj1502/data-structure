package linked.list.singly;

import java.util.*;

public class PalindromLinkedList {

	public boolean isPalindrome(ListNode head) {
	       Stack<ListNode> stack = new Stack<>();
	       ListNode curr = head;
	       while(curr != null){
	           stack.push(curr);
	           curr = curr.next;
	       }
	       curr = head;
	       while(curr != null){
	    	   ListNode node = stack.pop();
	            if(curr.val != node.val){
	               return false;
	           }
	           curr = curr.next;
	       }
	       return true;
	   }
	
    public static boolean isPalindrome_1(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode curr = head;
        ListNode temp = new ListNode();
        ListNode dummy = temp;
        while(curr.next != null){
        	dummy.next = new ListNode(curr.val);
        	dummy = dummy.next;
            curr = curr.next;
        }
        dummy.next = new ListNode(curr.val);
        temp = temp.next;
        ListNode prev = reverse(head);
        curr = temp;
        while(curr != null && prev != null){
            if(curr.val != prev.val){
                return false;
            }
            System.out.print("curr " + curr.val + " prev " + prev.val);
            curr = curr.next;
            prev = prev.next;
        }
        System.out.println();
        if(curr != null || prev != null) {
            return false;
        }
        return true;
    }
    
    private static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(1);
		
		PalindromLinkedList pll = new PalindromLinkedList();
		System.out.println(pll.isPalindrome(node));
		
		System.out.println(isPalindrome_1(node));
	}
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
