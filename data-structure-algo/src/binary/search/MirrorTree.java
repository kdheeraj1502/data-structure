package binary.search;

public class MirrorTree {

    void mirror(Node node) {
        // Your code here
        convert(node);
    }
    
    Node convert(Node node) {
        if(node == null) return null;
        Node left = convert(node.left);
        Node right = convert(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
    
    public static void main(String[] args) {
		
	}
}
