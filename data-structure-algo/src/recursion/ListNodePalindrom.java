package recursion;

import java.util.*;

public class ListNodePalindrom {

    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        Stack<Integer> stack = new Stack<>();
        while(curr != null){
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            int val = stack.pop();
            if(curr.val != val){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}
