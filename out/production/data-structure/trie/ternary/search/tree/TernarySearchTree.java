package trie.ternary.search.tree;

public class TernarySearchTree {
   private Node root;

   public void put(String key, int value) {
      this.root = this.insert(this.root, key, value, 0);
   }

   private Node insert(Node node, String key, int value, int index) {
      char ch = key.charAt(index);
      if (node == null) {
         node = new Node(ch);
      }

      if (ch < node.getCharacter()) {
         node.setLeftChild(this.insert(node.getLeftChild(), key, value, index));
      } else if (ch > node.getCharacter()) {
         node.setRightChild(this.insert(node.getRightChild(), key, value, index));
      } else if (index < key.length() - 1) {
         node.setMiddleChild(this.insert(node.getMiddleChild(), key, value, index + 1));
      } else {
         node.setLeaf(Boolean.TRUE);
         node.setValue(value);
      }

      return node;
   }

   public int get(String key) {
      return this.search(this.root, key, 0);
   }

   private Integer search(Node node, String key, int index) {
      char ch = key.charAt(index);
      if (node == null) {
         return null;
      } else if (ch < node.getCharacter()) {
         return this.search(node.getLeftChild(), key, index);
      } else if (ch > node.getCharacter()) {
         return this.search(node.getRightChild(), key, index);
      } else if (index < key.length() - 1) {
         return this.search(node.getMiddleChild(), key, index + 1);
      } else {
         return !node.isLeaf() ? null : node.getValue();
      }
   }

   public void traverse() {
      if (this.root != null) {
         this.traverse(this.root, "");
      }

   }

   private void traverse(Node curr, String s) {
      if (curr != null) {
         if (curr.getMiddleChild() == null || curr.getValue() != 0) {
            System.out.println(s + curr.getCharacter() + " " + curr.getValue());
            s = "";
         }

         if (curr.getLeftChild() != null) {
            this.traverse(curr.getLeftChild(), s);
         }

         if (curr.getMiddleChild() != null) {
            this.traverse(curr.getMiddleChild(), s + curr.getCharacter());
         }

         if (curr.getRightChild() != null) {
            this.traverse(curr.getRightChild(), s);
         }

      }
   }

   public static void main(String[] args) {
      TernarySearchTree tst = new TernarySearchTree();
      tst.put("car", 10);
      tst.put("bus", 5);
      tst.put("banana", 7);
      tst.put("city", 20);
      tst.put("person", 2);
      System.out.println(tst.get("car"));
      System.out.println(tst.get("bus"));
      System.out.println(tst.get("banana"));
      System.out.println(tst.get("city"));
      System.out.println(tst.get("person"));
      tst.traverse();
   }
}
