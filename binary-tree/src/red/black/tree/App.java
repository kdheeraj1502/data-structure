package red.black.tree;

public class App {

	public static void main(String[] args) {
		Tree tree = new RedAndBlackTree();
		try {
			tree.insert(10);
			tree.insert(20);
			tree.insert(30);
			tree.insert(40);
			tree.traverse();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
