package trie;

public class TrieAssociativeVal {
   private Node root = new Node("");

   public void insert(String key, int value) {
      Node temp = this.root;

      for(int i = 0; i < key.length(); ++i) {
         char ch = key.charAt(i);
         int ascii = ch - 97;
         if (temp.getChild(ascii) == null) {
            Node node = new Node(String.valueOf(ch));
            temp.setChild(ascii, node);
            temp = node;
         } else {
            temp = temp.getChild(ascii);
         }
      }

      temp.setLeaf(Boolean.TRUE);
      temp.setValue(value);
   }

   public Integer search(String key) {
      Node temp = this.root;
      if (temp == null) {
         return null;
      } else {
         for(int i = 0; i < key.length(); ++i) {
            char ch = key.charAt(i);
            int ascii = ch - 97;
            if (temp.getChild(ascii) == null) {
               return null;
            }

            temp = temp.getChild(ascii);
         }

         if (!temp.isLeaf()) {
            return null;
         } else {
            return temp.getValue();
         }
      }
   }

   public static void main(String[] args) {
      TrieAssociativeVal t = new TrieAssociativeVal();
      String a = "air";
      String b = "apple";
      String c = "approve";
      String d = "bee";
      t.insert(a, 10);
      t.insert(b, 7);
      t.insert(c, 5);
      t.insert(d, 15);
      System.out.println(t.search("air"));
      System.out.println(t.search("computer"));
      System.out.println(t.search("bee"));
      System.out.println(t.search("air"));
   }
}
