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
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(1);
		
		PalindromLinkedList pll = new PalindromLinkedList();
		System.out.println(pll.isPalindrome(node));
	}
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
