package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
   private String character;
   private Node[] child;
   private boolean isLeaf;
   private boolean isVisited;
   private int value;
   private Map<Character, Node> children;
   private List<Node> kids;

   public Node(String character) {
      this.character = character;
      this.child = new Node[126];
      this.children = new HashMap();
      this.kids = new ArrayList();
   }

   public List<Node> getKids() {
      return this.kids;
   }

   public void setKids(List<Node> kids) {
      this.kids = kids;
   }

   public Map<Character, Node> getChildren() {
      return this.children;
   }

   public void setChildren(Map<Character, Node> children) {
      this.children = children;
   }

   public int getValue() {
      return this.value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   public String getCharacter() {
      return this.character;
   }

   public void setCharacter(String character) {
      this.character = character;
   }

   public void setChild(int index, Node node) {
      this.child[index] = node;
   }

   public boolean isLeaf() {
      return this.isLeaf;
   }

   public void setLeaf(boolean isLeaf) {
      this.isLeaf = isLeaf;
   }

   public boolean isVisited() {
      return this.isVisited;
   }

   public void setVisited(boolean isVisited) {
      this.isVisited = isVisited;
   }

   public Node getChild(int index) {
      return this.child[index];
   }

   public String toString() {
      return this.character;
   }
}
