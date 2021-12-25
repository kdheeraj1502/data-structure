package binary.search;

public class DistanceBetweenTwoNodes {

	static int findDist(Node root, int a, int b) {
        Node LCA = lca(root, a, b);
        int x = dis(LCA, a);
        int y = dis(LCA, b);
        return x + y - 2;
    }
    
    static Node lca(Node root, int n1, int n2){
        if(root == null) return null;
        if(root.val == n1 || root.val == n2) return root;
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        else return null;
    }
    
    static int dis(Node root, int n){
        if(root == null) return 0;
        if(root.val == n) return 1;
        int left = dis(root.left, n);
        int right = dis(root.right, n);
        if(left == 0 && right == 0) return 0;
        return left + right + 1;
    }
    
    public static void main(String[] args) {
    	Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		System.out.println(findDist(root, 2, 3));
	}
}
