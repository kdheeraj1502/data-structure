package linked.list.doubly;

public class MultiLevelDoubleLinkedListFlatten {
   public NodeWithChild flatten(NodeWithChild head) {
      NodeWithChild curr = head;

      while(true) {
         while(curr != null) {
            if (curr.child == null) {
               curr = curr.next;
            } else {
               NodeWithChild tail;
               for(tail = curr.child; tail.next != null; tail = tail.next) {
               }

               tail.next = curr.next;
               if (tail.next != null) {
                  tail.next.prev = tail;
               }

               curr.next = curr.child;
               curr.next.prev = curr;
               curr.child = null;
            }
         }

         return head;
      }
   }

   public static void main(String[] args) {
      NodeWithChild node = new NodeWithChild(1);
      node.next = new NodeWithChild(2);
      node.next.prev = node;
      node.next.next = new NodeWithChild(3);
      node.next.next.prev = node.next;
      node.next.next.child = new NodeWithChild(7);
      node.next.next.child.next = new NodeWithChild(8);
      node.next.next.child.next.prev = node.next.next.child;
      node.next.next.child.next.child = new NodeWithChild(11);
      node.next.next.child.next.child.next = new NodeWithChild(12);
      node.next.next.child.next.child.next.prev = node.next.next.child.next.child;
      node.next.next.child.next.next = new NodeWithChild(9);
      node.next.next.child.next.next.prev = node.next.next.child.next;
      node.next.next.child.next.next.next = new NodeWithChild(10);
      node.next.next.child.next.next.next.prev = node.next.next.child.next.next;
      node.next.next.next = new NodeWithChild(4);
      node.next.next.next.prev = node.next.next;
      node.next.next.next.next = new NodeWithChild(5);
      node.next.next.next.next.prev = node.next.next.next;
      node.next.next.next.next.next = new NodeWithChild(6);
      node.next.next.next.next.next.prev = node.next.next.next.next;
      MultiLevelDoubleLinkedListFlatten mdlf = new MultiLevelDoubleLinkedListFlatten();

      for(NodeWithChild result = mdlf.flatten(node); result != null; result = result.next) {
         System.out.print(result.val + ", ");
      }

   }
}
