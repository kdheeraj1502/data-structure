package binary.search;

import java.util.*;

public class DuplicateSubTree {

	static int dupSub(Node root) {
        Map<String, Integer> map = new HashMap<>();
        dupSub(root, map);
        for(Map.Entry<String, Integer> m : map.entrySet()){
            if(m.getValue() > 1){
                return 1;
            }
        }
        return 0;
    }
    static String dupSub(Node root, Map<String, Integer> map) {
        if(root == null) return "$";
        String res = "";
        if(root.left == null && root.right == null){
            return String.valueOf(root.val);
        }
        res += String.valueOf(root.val);
        res += dupSub(root.left, map);
        res += dupSub(root.right, map);
        map.put(res, map.getOrDefault(res, 0) + 1);
        return res;
    }
    //1 4 4 6 9 5   N 10 5
    public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(4);
		root.right = new Node(4);
		root.left.left = new Node(6);
		root.left.right = new Node(9);
		root.right.left = new Node(5);
		
		root.left.left.left = new Node(10);
		root.left.left.right = new Node(5);
		
		System.out.println(dupSub(root));
	}
}
