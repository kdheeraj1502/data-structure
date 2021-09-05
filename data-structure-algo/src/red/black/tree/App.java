package red.black.tree;

public class App {

	public static void main(String[] args) {
		Tree bst = new RedAndBlackTree();
		try {
			bst.insert(10);//
			bst.insert(20);
			bst.insert(30);
			bst.insert(40);
			bst.insert(19);//
			bst.insert(15);//-------
			bst.insert(25);//
			bst.insert(13);//
			bst.insert(23);//
			bst.insert(33);
			bst.insert(35);
			bst.insert(45);
			bst.insert(05);
			bst.insert(55);
			bst.insert(12);
			bst.insert(11);
			bst.insert(67);
			bst.insert(43);
			bst.insert(17);
	//		TraverseBST.onLevelTraverse(bst.getRoot());
			bst.traverse();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
