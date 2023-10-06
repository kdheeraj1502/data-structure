package trie;

public class Trie {
   private Node root = null;

   public Trie() {
      this.root = new Node("");
   }

   public void insert(String key) {
      Node temp = this.root;

      for(int i = 0; i < key.length(); ++i) {
         char c = key.charAt(i);
         int ascii = c - 97;
         if (temp.getChild(ascii) == null) {
            Node node = new Node(String.valueOf(c));
            temp.setChild(ascii, node);
            temp = node;
         } else {
            temp = temp.getChild(ascii);
         }
      }

      temp.setLeaf(Boolean.TRUE);
   }

   public boolean search(String key) {
      Node temp = this.root;

      for(int i = 0; i < key.length(); ++i) {
         char c = key.charAt(i);
         int ascii = c - 97;
         if (temp.getChild(ascii) == null) {
            return false;
         }

         temp = temp.getChild(ascii);
      }

      if (!temp.isLeaf()) {
         return false;
      } else {
         return true;
      }
   }

   public void print(Node curr) {
      for(int i = 0; i < 26; ++i) {
         if (curr.getChild(i) != null) {
            System.out.println(curr.getCharacter());
            curr = curr.getChild(i);
         }
      }

   }

   public static void main(String[] args) {
      Trie t = new Trie();
      String a = "apir";
      String b = "apple";
      String c = "approve";
      String d = "apee";
      t.insert(a);
      t.insert(b);
      t.insert(c);
      t.insert(d);
   }
}
