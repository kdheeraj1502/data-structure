package trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TrieAutoComplete {
   private Node root = new Node("");
   private static int lcpIndex;

   public void insert(String key, int value) {
      key = key.toLowerCase();
      Node temp = this.root;
      Map<Character, Node> children = temp.getChildren();
      List<Node> kids = temp.getKids();

      for(int i = 0; i < key.length(); ++i) {
         char ch = key.charAt(i);
         int ascii = ch - 97;
         if (temp.getChild(ascii) == null) {
            Node node = new Node(String.valueOf(ch));
            temp.setChild(ascii, node);
            children.put(ch, node);
            kids.add(node);
            temp = node;
         } else {
            temp = temp.getChild(ascii);
         }

         children = temp.getChildren();
         kids = temp.getKids();
      }

      temp.setLeaf(Boolean.TRUE);
      temp.setValue(value);
   }

   public Integer search(String key) {
      Node temp = this.root;

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

   public List<String> autoComplete(String prefix) {
      Node temp = this.root;
      List<String> autoCompleteList = new ArrayList();

      for(int i = 0; i < prefix.length(); ++i) {
         char ch = prefix.charAt(i);
         int ascii = ch - 97;
         if (temp.getChild(ascii) == null) {
            return autoCompleteList;
         }

         temp = temp.getChild(ascii);
      }

      this.collect(temp, prefix, autoCompleteList);
      return autoCompleteList;
   }

   private void collect(Node curr, String prefix, List<String> autoCompleteList) {
      if (curr != null) {
         if (curr.isLeaf()) {
            autoCompleteList.add(prefix);
         }

         Iterator var4 = curr.getChildren().entrySet().iterator();

         while(var4.hasNext()) {
            Map.Entry<Character, Node> entry = (Map.Entry)var4.next();
            Node child = (Node)entry.getValue();
            if (entry.getValue() != null) {
               String childCharacter = child.getCharacter();
               this.collect(child, prefix + childCharacter, autoCompleteList);
            }
         }

      }
   }

   public List<String> sort() {
      return this.autoComplete("");
   }

   public String longestCommonPrefix() {
      Node node = this.root;

      String lcp;
      for(lcp = ""; this.numOfChildren(node) == 1 && !node.isLeaf(); lcp = lcp + node.getCharacter()) {
         node = (Node)node.getKids().get(lcpIndex);
      }

      return lcp;
   }

   private int numOfChildren(Node curr) {
      int numOfChildren = 0;

      for(int i = 0; i < curr.getKids().size(); ++i) {
         if (curr.getKids().get(i) != null) {
            ++numOfChildren;
            lcpIndex = i;
         }
      }

      return numOfChildren;
   }

   public static void main(String[] args) {
      TrieAutoComplete tac = new TrieAutoComplete();
      String g = "baus";
      String d = "baus";
      String e = "baus";
      String f = "baus";
      tac.insert(g, 76);
      tac.insert(d, 15);
      tac.insert(e, 134);
      tac.insert(f, 1);
      System.out.println(tac.search("air"));
      System.out.println(tac.search("computer"));
      System.out.println(tac.search("bee"));
      System.out.println(tac.search("air"));
      Iterator var6 = tac.autoComplete("b").iterator();

      String s;
      while(var6.hasNext()) {
         s = (String)var6.next();
         System.out.println(s);
      }

      System.out.println("------------------");
      var6 = tac.sort().iterator();

      while(var6.hasNext()) {
         s = (String)var6.next();
         System.out.println(s);
      }

      System.out.println("---------Longest common prefix-----------");
      System.out.println(tac.longestCommonPrefix());
   }
}
