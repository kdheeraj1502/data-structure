package com.hellokoding.algorithm;

import com.hellokoding.datastructure.BSTByLinkedList;
import java.util.ArrayDeque;
import java.util.Deque;

public class TreeDepthFirstTraversalIterably extends BSTByLinkedList {
   public void preTraversal(BSTByLinkedList.Node node) {
      if (node != null) {
         Deque<BSTByLinkedList.Node> stack = new ArrayDeque();
         stack.push(node);

         while(!stack.isEmpty()) {
            BSTByLinkedList.Node currentNode = (BSTByLinkedList.Node)stack.pop();
            System.out.println(currentNode);
            if (currentNode.right != null) {
               stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
               stack.push(currentNode.left);
            }
         }

      }
   }

   public void inTraversal(BSTByLinkedList.Node node) {
      ArrayDeque stack;
      for(stack = new ArrayDeque(); node != null; node = node.left) {
         stack.push(node);
      }

      while(!stack.isEmpty()) {
         node = (BSTByLinkedList.Node)stack.pop();
         System.out.println(node);
         if (node.right != null) {
            stack.push(node.right);
         }
      }

   }

   public void postTraversal(BSTByLinkedList.Node node) {
      ArrayDeque stack;
      for(stack = new ArrayDeque(); node != null; node = node.left) {
         stack.push(node);
      }

      BSTByLinkedList.Node lastVisitedNode = null;

      while(true) {
         while(!stack.isEmpty()) {
            node = (BSTByLinkedList.Node)stack.peek();
            if (node.right != null && node.right != lastVisitedNode) {
               stack.push(node.right);
            } else {
               System.out.println(node);
               lastVisitedNode = (BSTByLinkedList.Node)stack.pop();
            }
         }

         return;
      }
   }

   public static void main(String[] args) {
      TreeDepthFirstTraversalIterably tree = new TreeDepthFirstTraversalIterably();
      tree.insert(7);
      tree.insert(2);
      tree.insert(3);
      tree.insert(1);
      tree.insert(9);
      System.out.println("Pre-order Traversal");
      tree.preTraversal(tree.root);
      System.out.println();
      System.out.println("In-order Traversal");
      tree.inTraversal(tree.root);
      System.out.println();
      System.out.println("Post-order Traversal");
      tree.postTraversal(tree.root);
   }
}
