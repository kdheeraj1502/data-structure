package trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TrieLongestCommonPrefixIP {
   private Node root = new Node("");
   private static int lcpIndex;

   public void insert(String key) {
      key = key.toLowerCase();
      Node temp = this.root;
      Map<Character, Node> children = temp.getChildren();
      List<Node> kids = temp.getKids();

      for(int i = 0; i < key.length(); ++i) {
         char ch = key.charAt(i);
         if (temp.getChild(ch) == null) {
            Node node = new Node(String.valueOf(ch));
            temp.setChild(ch, node);
            children.put(ch, node);
            kids.add(node);
            temp = node;
         } else {
            temp = temp.getChild(ch);
         }

         children = temp.getChildren();
         kids = temp.getKids();
      }

      temp.setLeaf(Boolean.TRUE);
   }

   public boolean search(String key) {
      Node temp = this.root;

      for(int i = 0; i < key.length(); ++i) {
         char ch = key.charAt(i);
         if (temp.getChild(ch) == null) {
            return false;
         }

         temp = temp.getChild(ch);
      }

      if (!temp.isLeaf()) {
         return false;
      } else {
         return temp.isLeaf();
      }
   }

   public List<String> autoComplete(String prefix) {
      Node temp = this.root;
      List<String> autoCompleteList = new ArrayList();

      for(int i = 0; i < prefix.length(); ++i) {
         char ch = prefix.charAt(i);
         if (temp.getChild(ch) == null) {
            return autoCompleteList;
         }

         temp = temp.getChild(ch);
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
      TrieLongestCommonPrefixIP tlcp = new TrieLongestCommonPrefixIP();
      tlcp.insert("243.189.345.123");
      tlcp.insert("243.189.562.173");
      tlcp.insert("243.145.111.173");
      tlcp.insert("243.189.123.763");
      tlcp.insert("243.189.345.223");
      System.out.println("243.189.562.173 is " + (tlcp.search("243.189.562.173") ? "present" : "Not found"));
      System.out.println("999.189.345.123 is " + (tlcp.search("999.189.345.123") ? "present" : "Not found"));
      System.out.println("243.189.345.123 is " + (tlcp.search("243.189.345.123") ? "present" : "Not found"));
      System.out.println("air is " + (tlcp.search("air") ? "present" : "Not found"));
      System.out.println("---------Longest common prefix-----------");
      System.out.println(tlcp.longestCommonPrefix());
   }
}
